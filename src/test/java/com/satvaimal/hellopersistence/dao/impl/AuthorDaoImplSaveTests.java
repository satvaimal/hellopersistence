package com.satvaimal.hellopersistence.dao.impl;
 
import com.satvaimal.hellopersistence.AppConfig;
import com.satvaimal.hellopersistence.dao.AuthorDao;
import com.satvaimal.hellopersistence.domain.Author;
 
import java.util.Date;
 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
public class AuthorDaoImplSaveTests {
 
  @Rule
  public ExpectedException thrown = ExpectedException.none();
 
  @PersistenceContext
  private EntityManager em;
 
  @Autowired
  private AuthorDao authorDao;
 
  @Test
  public void entityPersistedSuccessfully() throws Exception {
 
    Author author = new Author();
    author.setName( "J. R. Tolkien" );
    author.setBirthdate( new Date() );
    authorDao.save( author );
    assertEquals( 1, em.createQuery(
        "select a from Author a" ).getResultList().size() );
 
  }// End of method
 
  @Test
  public void entityWithErrors() throws Exception {
 
    Author author = new Author();
    author.setName( null );
    author.setBirthdate( new Date() );
 
    thrown.expect( IllegalArgumentException.class );
    thrown.expectMessage( "authorDaoImpl.save.error: " );
    thrown.expectMessage(
        "not-null property references a null or transient value" );
    authorDao.save( author );
 
  }// End of method
 
  @Test
  public void entityIsNull() throws Exception {
 
    thrown.expect( IllegalArgumentException.class );
    thrown.expectMessage( "authorDaoImpl.save.error: " );
    thrown.expectMessage( "attempt to create create event with null entity" );
    authorDao.save( null );
 
  }// End of method
 
}// End of class
