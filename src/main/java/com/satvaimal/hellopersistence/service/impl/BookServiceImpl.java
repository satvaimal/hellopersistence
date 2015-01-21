package com.satvaimal.hellopersistence.service.impl;
 
import com.satvaimal.hellopersistence.domain.Book;
import com.satvaimal.hellopersistence.repository.BookRepository;
import com.satvaimal.hellopersistence.service.BookService;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
 
public class BookServiceImpl implements BookService {
 
  @Autowired
  private BookRepository bookRepository;
 
  @Transactional
  public Book create( Book book ) throws Exception {
 
    validateNull( book, "create" );
    return bookRepository.save( book );
 
  }// End of method
 
  @Transactional
  public List<Book> list() {
    return bookRepository.findAll();
  }// End of method
 
  @Transactional
  public Book get( long id ) {
    return bookRepository.findOne( id );
  }// End of method
 
  @Transactional
  public Book update( Book book ) throws Exception {
 
    validateNull( book, "update" );
 
    if ( !bookRepository.exists( book.getId() ) ) {
      throw new IllegalArgumentException(
          "bookService.update.book.not.found" );
    }// End of if
 
    return book;
 
  }// End of method
 
  @Transactional
  public void delete( Book book ) throws Exception {
 
    validateNull( book, "delete" );
    bookRepository.delete( book );
 
  }// End of method
 
  private void validateNull( Book book, String method ) throws Exception {
 
    if ( book == null ) {
      throw new IllegalArgumentException( "bookService." + method +
          ".book.null" );
    }// End of if
 
  }// End of method
 
}// End of class
