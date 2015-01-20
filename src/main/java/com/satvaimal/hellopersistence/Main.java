package com.satvaimal.hellopersistence;
 
import com.satvaimal.hellopersistence.dao.AuthorDao;
import com.satvaimal.hellopersistence.dao.impl.AuthorDaoImpl;
import com.satvaimal.hellopersistence.domain.Author;
 
import java.util.Date;
 
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class Main {
 
  private static EntityManagerFactory emf;
 
  private static AuthorDao authorDao;
 
  private static void setup() {
 
    emf = Persistence.createEntityManagerFactory( "helloPersistence" );
    authorDao = new AuthorDaoImpl();
    ( (AuthorDaoImpl)authorDao ).setEntityManagerFactory( emf );
 
  }// End of method
 
  private static void cleanup() {
    emf.close();
  }// End of method 
 
  public static void main( String[] args ) {
 
    setup();
 
    try {
 
      Author author = new Author();
      author.setName( "J. R. Tolkien" );
      author.setBirthdate( new Date() );
      authorDao.save( author );
 
    } catch ( Exception e ) {
      e.printStackTrace();
    } finally {
      cleanup();
    }// End of finally
 
  }// End of method
 
}// End of class
