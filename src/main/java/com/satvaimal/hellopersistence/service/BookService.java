package com.satvaimal.hellopersistence.service;
 
import com.satvaimal.hellopersistence.domain.Book;
 
import java.util.List;
 
public interface BookService {
 
  public Book create( Book book ) throws Exception;
 
  public List<Book> list();
 
  public Book get( long id );
 
  public Book update( Book book ) throws Exception;
 
  public void delete( Book book ) throws Exception;
 
}// End of class
