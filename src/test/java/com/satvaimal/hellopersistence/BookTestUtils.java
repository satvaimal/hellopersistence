package com.satvaimal.hellopersistence;
 
import com.satvaimal.hellopersistence.domain.Book;
 
import static com.satvaimal.hellopersistence.AuthorTestUtils.*;
import java.util.Date;
 
import javax.persistence.EntityManager;
 
public class BookTestUtils {
 
  public static Book createBook( String title, String author ) {
 
    Book book = new Book();
    book.setTitle( title );
    book.setAuthor( createAuthor( author ) );
    return book;
 
  }// End of method
 
  public static Book persistBook( String title, String author,
      EntityManager em ) {
 
    Book book = createBook( title, author );
    em.persist( book.getAuthor() );
    em.persist( book );
    return book;
 
  }// End of method
 
}// End of class
