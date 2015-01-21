package com.satvaimal.hellopersistence.service;
 
import com.satvaimal.hellopersistence.domain.Author;
 
import java.util.List;
 
public interface AuthorService {
 
  public Author create( Author author ) throws Exception;
 
  public List<Author> list();
 
}// End of class
