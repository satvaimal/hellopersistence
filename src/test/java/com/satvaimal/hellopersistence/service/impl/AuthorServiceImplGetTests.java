package com.satvaimal.hellopersistence.service.impl;
 
import static com.satvaimal.hellopersistence.AuthorTestUtils.*;
import com.satvaimal.hellopersistence.CommonTestConfig;
import com.satvaimal.hellopersistence.domain.Author;
import com.satvaimal.hellopersistence.service.AuthorService;
 
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
@RunWith(SpringJUnit4ClassRunner.class)
@CommonTestConfig
public class AuthorServiceImplGetTests {
 
  @Autowired
  private AuthorService authorService;
 
  @Test
  public void getEntitySuccessfully() throws Exception {
 
    Author author = authorService.create( createAuthor( "J. R. Tolkien" ) );
    Author sameAuthor = authorService.get( author.getId() );
    assertNotNull( sameAuthor );
    assertEquals( sameAuthor.getId(), author.getId() );
 
  }// End of method
 
  @Test
  public void entityNotFound() throws Exception {
 
    Author author = authorService.get( 1L );
    assertNull( author );
 
  }// End of method
 
}// End of class
