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
public class BookServiceImplCreateTests {
 
  @Rule
  public ExpectedException thrown = ExpectedException.none();
 
  @Autowired
  private BookService bookService;
 
  @PersistenceContext
  private EntityManager em;
 
  @Test
  public void entityCreatedSuccessfully() throws Exception {
 
    Book book = createBook( "J. R. Tolkien", "The Lord of the Rings" );
    em.persist( book.getAuthor() );
    bookService.create( book );
    assertEquals( 1, em.createQuery(
        "select a from Book a" ).getResultList().size() );
 
  }// End of method
 
  @Test
  public void entityWithErrors() throws Exception {
 
    Book book = createBook( "J. R. Tolkien", "The Lord of the Rings" );
    em.persist( book.getAuthor() );
    book.setTitle( null );
    thrown.expect( DataIntegrityViolationException.class );
    thrown.expectMessage(
        "not-null property references a null or transient value" );
    bookService.create( book );
 
  }// End of method
 
  @Test
  public void entityIsNull() throws Exception {
 
    thrown.expect( IllegalArgumentException.class );
    thrown.expectMessage( "bookService.create.book.null" );
    bookService.create( null );
 
  }// End of method
 
}// End of class
