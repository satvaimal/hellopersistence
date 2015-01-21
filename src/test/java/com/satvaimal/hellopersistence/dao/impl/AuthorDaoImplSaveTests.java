package com.satvaimal.hellopersistence.dao.impl;

import com.satvaimal.hellopersistence.dao.AuthorDao;
import com.satvaimal.hellopersistence.dao.impl.AuthorDaoImpl;
import com.satvaimal.hellopersistence.domain.Author;
 
import java.util.Date;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
 
public class AuthorDaoImplSaveTests {
 
  @Rule
  public ExpectedException thrown = ExpectedException.none();
 
  private static EntityManagerFactory emf;
 
  private static AuthorDao authorDao;
 
  @BeforeClass
  public static void setup() {
 
    emf = Persistence.createEntityManagerFactory( "helloPersistence" );
    authorDao = new AuthorDaoImpl();
    ( (AuthorDaoImpl) authorDao ).setEntityManagerFactory( emf );
 
  }// End of method
 
  @AfterClass
  public static void cleanup() {
    emf.close();
  }// End of method
 
  @Test
  public void entityPersistedSuccessfully() throws Exception {
 
    Author author = new Author();
    author.setName( "J. R. Tolkien" );
    author.setBirthdate( new Date() );
    authorDao.save( author );
    assertEquals( 1, emf.createEntityManager().createQuery(
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
