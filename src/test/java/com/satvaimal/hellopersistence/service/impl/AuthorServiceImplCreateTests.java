package com.satvaimal.hellopersistence.service.impl;
 
import static com.satvaimal.hellopersistence.AuthorTestUtils.*;
import com.satvaimal.hellopersistence.CommonTestConfig;
import com.satvaimal.hellopersistence.domain.Author;
import com.satvaimal.hellopersistence.service.AuthorService;
 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
@RunWith(SpringJUnit4ClassRunner.class)
@CommonTestConfig
public class AuthorServiceImplCreateTests {
 
  @Rule
  public ExpectedException thrown = ExpectedException.none();
 
  @Autowired
  private AuthorService authorService;
 
  @PersistenceContext
  private EntityManager em;
 
  @Test
  public void entityCreatedSuccessfully() throws Exception {
 
    authorService.create( createAuthor( "J. R. Tolkien" ) );
    assertEquals( 1, em.createQuery(
        "select a from Author a" ).getResultList().size() );
 
  }// End of method
 
  @Test
  public void entityWithErrors() throws Exception {
 
    thrown.expect( DataIntegrityViolationException.class );
    thrown.expectMessage(
        "not-null property references a null or transient value" );
    authorService.create( createAuthor( null ) );
 
  }// End of method
 
  @Test
  public void entityIsNull() throws Exception {
 
    thrown.expect( IllegalArgumentException.class );
    thrown.expectMessage( "authorService.create.author.null" );
    authorService.create( null );
 
  }// End of method
 
}// End of class
