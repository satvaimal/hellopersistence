package com.satvaimal.hellopersistence.service.impl;

import static com.satvaimal.hellopersistence.BookTestUtils.*;
import com.satvaimal.hellopersistence.CommonTestConfig;
import com.satvaimal.hellopersistence.domain.Book;
import com.satvaimal.hellopersistence.service.BookService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@CommonTestConfig
public class BookServiceImplGetTests {

  @Autowired
  private BookService bookService;

  @PersistenceContext
  private EntityManager em;

  @Test
  public void getEntitySuccessfully() throws Exception {

    Book book = persistBook( "The Lord of the Rings", "J. R. Tolkien", em );
    Book sameBook = bookService.get( book.getId() );
    assertNotNull( sameBook );
    assertEquals( sameBook.getId(), book.getId() );

  }// End of method

  @Test
  public void entityNotFound() throws Exception {

    Book book = bookService.get( 1L );
    assertNull( book );

  }// End of method

}// End of class
