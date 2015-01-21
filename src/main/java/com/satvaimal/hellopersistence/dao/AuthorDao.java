package com.satvaimal.hellopersistence.dao;
 
import com.satvaimal.hellopersistence.domain.Author;

import java.util.List;

public interface AuthorDao {
 
  public Author save( Author author ) throws Exception;

  public List<Author> list();
 
}// End of class
