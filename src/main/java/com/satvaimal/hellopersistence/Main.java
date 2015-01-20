package com.satvaimal.hellopersistence;
 
import com.satvaimal.hellopersistence.domain.Author;
 
import java.util.Date;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class Main {
 
  public static void main( String[] args ) {
 
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(
        "helloPersistence" );
    EntityManager em = emf.createEntityManager();
 
    try {
 
      em.getTransaction().begin();
 
      Author author = new Author();
      author.setName( "J. R. Tolkien" );
      author.setBirthdate( new Date() );
      em.persist( author );
 
      em.getTransaction().commit();
 
    } catch ( Exception e ) {
 
      em.getTransaction().rollback();
      e.printStackTrace();
 
    } finally {
      emf.close();
    }// End of try/catch/finally block
 
  }// End of method
 
}// End of class
