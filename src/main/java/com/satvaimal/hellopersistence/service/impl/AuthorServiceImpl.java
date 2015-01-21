package com.satvaimal.hellopersistence.service.impl;
 
import com.satvaimal.hellopersistence.dao.AuthorDao;
import com.satvaimal.hellopersistence.domain.Author;
import com.satvaimal.hellopersistence.service.AuthorService;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
 
public class AuthorServiceImpl implements AuthorService {
 
  @Autowired
  private AuthorDao authorDao;
 
  @Transactional
  public Author create( Author author ) throws Exception {
 
    if ( author == null ) {
      throw new IllegalArgumentException( "authorService.create.author.null" );
    }// End of if
 
    return authorDao.save( author );
 
  }// End of method
 
  @Transactional
  public List<Author> list() {
    return authorDao.list();
  }// End of method
 
}// End of class
