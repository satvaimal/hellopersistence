package com.satvaimal.hellopersistence.dao.impl;
 
import com.satvaimal.hellopersistence.dao.AuthorDao;
import com.satvaimal.hellopersistence.domain.Author;
 
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 
public class AuthorDaoImpl implements AuthorDao {
 
  @PersistenceContext
  private EntityManager em;
 
  public Author save( Author author ) throws Exception {
 
    try {
 
      em.persist( author );
      return author;
 
    } catch ( Exception e ) {
 
      throw new IllegalArgumentException( "authorDaoImpl.save.error: " +
          e.getMessage() );
 
    }// End of catch
 
  }// End of method
 
  @SuppressWarnings("unchecked")
  public List<Author> list() {
 
    Query query = em.createQuery( "select a from Author a" );
    return (List<Author>)( query.getResultList() );
 
  }// End of method
 
}// End of class
