package com.satvaimal.hellopersistence.dao.impl;
 
import com.satvaimal.hellopersistence.dao.AuthorDao;
import com.satvaimal.hellopersistence.domain.Author;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
 
public class AuthorDaoImpl implements AuthorDao {
 
  private EntityManagerFactory emf;
 
  public Author save( Author author ) throws Exception {
 
    EntityManager em = emf.createEntityManager();
 
    try {
 
      em.getTransaction().begin();
      em.persist( author );
      em.getTransaction().commit();
      return author;
 
    } catch ( Exception e ) {
 
      em.getTransaction().rollback();
      throw new IllegalArgumentException( "authorDaoImpl.save.error: " +
          e.getMessage() );
 
    }// End of catch
 
  }// End of method
 
  public void setEntityManagerFactory( EntityManagerFactory emf ) {
    this.emf = emf;
  }// End of method
 
}// End of class
