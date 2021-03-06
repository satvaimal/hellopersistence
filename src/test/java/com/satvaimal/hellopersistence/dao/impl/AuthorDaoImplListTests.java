package com.satvaimal.hellopersistence.dao.impl;
 
import com.satvaimal.hellopersistence.CommonTestConfig;
import com.satvaimal.hellopersistence.AppConfig;
import com.satvaimal.hellopersistence.dao.AuthorDao;
import com.satvaimal.hellopersistence.domain.Author;
 
import java.util.Date;
import java.util.List;
 
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
@RunWith(SpringJUnit4ClassRunner.class)
@CommonTestConfig
public class AuthorDaoImplListTests {
 
  @Autowired
  private AuthorDao authorDao;
 
  @Test
  public void listEntitiesSuccessfully() throws Exception {
 
    persistAuthor( "J. R. Tolkien" );
    persistAuthor( "Mario Puzo" );
    List<Author> authors = authorDao.list();
    assertEquals( 2, authors.size() );
 
  }// End of method
 
  private void persistAuthor( String name ) throws Exception {
 
    Author author = new Author();
    author.setName( name );
    author.setBirthdate( new Date() );
    authorDao.save( author );
 
  }// End of method
 
}// End of class
