package com.satvaimal.hellopersistence.service.impl;

import static com.satvaimal.hellopersistence.BookTestUtils.*;
import com.satvaimal.hellopersistence.CommonTestConfig;
import com.satvaimal.hellopersistence.domain.Book;
import com.satvaimal.hellopersistence.service.BookService;

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
public class BookServiceImplUpdateTests {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Autowired
  private BookService bookService;

  @PersistenceContext
  private EntityManager em;

  @Test
  public void updateEntitySuccessfully() throws Exception {

    Book book = persistBook( "The Lord of the Rings", "J. R. Tolkien", em );
    book.setTitle( "The Hobbit" );
    Book sameBook = bookService.update( book );
    assertNotNull( sameBook );
    assertEquals( sameBook.getId(), book.getId() );
    assertEquals( sameBook.getTitle(), book.getTitle() );

  }// End of method

  @Test
  public void entityNotFound() throws Exception {

    Book book = new Book();
    thrown.expect( IllegalArgumentException.class );
    thrown.expectMessage( "bookService.update.book.not.found" );
    bookService.update( book );

  }// End of method

  @Test
  public void entityWithErrors() throws Exception {

    Book book = persistBook( "The Lord of the Rings", "J. R. Tolkien", em );
    book.setTitle( null );
    thrown.expect( DataIntegrityViolationException.class );
    thrown.expectMessage(
        "not-null property references a null or transient value" );
    bookService.update( book );

  }// End of method

  @Test
  public void entityIsNull() throws Exception {

    thrown.expect( IllegalArgumentException.class );
    thrown.expectMessage( "bookService.update.book.null" );
    bookService.update( null );

  }// End of method

}// End of class
