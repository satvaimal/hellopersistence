package com.satvaimal.hellopersistence.service.impl;
 
import static com.satvaimal.hellopersistence.AuthorTestUtils.*;
import com.satvaimal.hellopersistence.CommonTestConfig;
import com.satvaimal.hellopersistence.domain.Author;
import com.satvaimal.hellopersistence.service.AuthorService;
 
import java.util.List;
 
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
@RunWith(SpringJUnit4ClassRunner.class)
@CommonTestConfig
public class AuthorServiceImplListTests {
 
  @Autowired
  private AuthorService authorService;
 
  @Test
  public void listEntitiesSuccessfully() throws Exception {
 
    authorService.create( createAuthor( "J. R. Tolkien" ) );
    authorService.create( createAuthor( "Mario Puzo" ) );
    List<Author> authors = authorService.list();
    assertEquals( 2, authors.size() );
 
  }// End of method
 
}// End of class
