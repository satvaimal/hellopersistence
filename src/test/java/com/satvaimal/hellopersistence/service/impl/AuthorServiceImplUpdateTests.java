package com.satvaimal.hellopersistence.service.impl;
 
import static com.satvaimal.hellopersistence.AuthorTestUtils.*;
import com.satvaimal.hellopersistence.CommonTestConfig;
import com.satvaimal.hellopersistence.domain.Author;
import com.satvaimal.hellopersistence.service.AuthorService;
 
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
public class AuthorServiceImplUpdateTests {
 
  @Rule
  public ExpectedException thrown = ExpectedException.none();
 
  @Autowired
  private AuthorService authorService;
 
  @Test
  public void updateEntitySuccessfully() throws Exception {
 
    Author author = authorService.create( createAuthor( "J. R. Tolkien" ) );
    author.setName( "Mario Puzo" );
    Author sameAuthor = authorService.update( author );
    assertNotNull( sameAuthor );
    assertEquals( sameAuthor.getId(), author.getId() );
    assertEquals( sameAuthor.getName(), author.getName() );
 
  }// End of method
 
  @Test
  public void entityNotFound() throws Exception {
 
    Author author = new Author();
    thrown.expect( IllegalArgumentException.class );
    thrown.expectMessage( "authorService.update.author.not.found" );
    authorService.update( author );
 
  }// End of method
 
  @Test
  public void entityWithErrors() throws Exception {
 
    Author author = authorService.create( createAuthor( "J. R. Tolkien" ) );
    author.setName( null );
    thrown.expect( DataIntegrityViolationException.class );
    thrown.expectMessage(
        "not-null property references a null or transient value" );
    authorService.update( author );
 
  }// End of method
 
  @Test
  public void entityIsNull() throws Exception {
 
    thrown.expect( IllegalArgumentException.class );
    thrown.expectMessage( "authorService.update.author.null" );
    authorService.update( null );
 
  }// End of method
 
}// End of class
