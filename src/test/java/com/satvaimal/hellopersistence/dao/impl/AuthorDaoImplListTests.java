package com.satvaimal.hellopersistence.dao.impl;
 
import com.satvaimal.hellopersistence.dao.AuthorDao;
import com.satvaimal.hellopersistence.dao.impl.AuthorDaoImpl;
import com.satvaimal.hellopersistence.domain.Author;
 
import java.util.Date;
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
 
public class AuthorDaoImplListTests {
 
  private static EntityManagerFactory emf;
 
  private static AuthorDao authorDao;
 
  @BeforeClass
  public static void setup() throws Exception {
 
    emf = Persistence.createEntityManagerFactory( "helloPersistence" );
    authorDao = new AuthorDaoImpl();
    ( (AuthorDaoImpl) authorDao ).setEntityManagerFactory( emf );
    persistAuthor( "J. R. Tolkien" );
    persistAuthor( "Mario Puzo" );
 
  }// End of method
 
  @AfterClass
  public static void cleanup() {
    emf.close();
  }// End of method
 
  @Test
  public void listEntitiesSuccessfully() {
 
    List<Author> authors = authorDao.list();
    assertEquals( 2, authors.size() );
 
  }// End of method
 
  private static void persistAuthor( String name ) throws Exception {
 
    Author author = new Author();
    author.setName( name );
    author.setBirthdate( new Date() );
    authorDao.save( author );
 
  }// End of method
 
}// End of class
