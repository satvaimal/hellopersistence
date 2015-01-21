package com.satvaimal.hellopersistence.service;
 
import com.satvaimal.hellopersistence.domain.Author;
 
import java.util.List;
 
public interface AuthorService {
 
  public Author create( Author author ) throws Exception;
 
  public List<Author> list();
 
  public Author get( long id );
 
  public Author update( Author author ) throws Exception;
 
  public void delete( Author author ) throws Exception;
 
}// End of class
