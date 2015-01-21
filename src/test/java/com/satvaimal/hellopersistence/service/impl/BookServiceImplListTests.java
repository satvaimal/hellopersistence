package com.satvaimal.hellopersistence.service.impl;
 
import static com.satvaimal.hellopersistence.BookTestUtils.*;
import com.satvaimal.hellopersistence.CommonTestConfig;
import com.satvaimal.hellopersistence.domain.Book;
import com.satvaimal.hellopersistence.service.BookService;
 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
@RunWith(SpringJUnit4ClassRunner.class)
@CommonTestConfig
public class BookServiceImplListTests {
 
  @Autowired
  private BookService bookService;

  @PersistenceContext
  private EntityManager em;
 
  @Test
  public void listEntitiesSuccessfully() throws Exception {
 
    persistBook( "The Lord of the Rings", "J. R. Tolkien", em );
    persistBook( "The Godfather", "Mario Puzo", em );
    List<Book> books = bookService.list();
    assertEquals( 2, books.size() );
 
  }// End of method
 
}// End of class
