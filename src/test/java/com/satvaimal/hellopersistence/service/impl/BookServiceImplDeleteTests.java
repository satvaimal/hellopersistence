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
public class BookServiceImplDeleteTests {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Autowired
  private BookService bookService;

  @PersistenceContext
  private EntityManager em;

  @Test
  public void deleteEntitySuccessfully() throws Exception {

    Book book = persistBook( "The Lord of the Rings", "J. R. Tolkien", em );
    assertEquals( 1, em.createQuery(
        "select a from Book a" ).getResultList().size() );
    bookService.delete( book );
    assertEquals( 0, em.createQuery(
        "select a from Book a" ).getResultList().size() );

  }// End of method

  @Test
  public void entityNotFound() throws Exception {

    Book book = new Book();
    thrown.expect( DataIntegrityViolationException.class );
    thrown.expectMessage(
        "not-null property references a null or transient value" );
    bookService.delete( book );

  }// End of method

  @Test
  public void entityIsNull() throws Exception {

    thrown.expect( IllegalArgumentException.class );
    thrown.expectMessage( "bookService.delete.book.null" );
    bookService.delete( null );

  }// End of method

}// End of class
