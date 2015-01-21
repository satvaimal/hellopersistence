package com.satvaimal.hellopersistence.service.impl;
 
import com.satvaimal.hellopersistence.domain.Author;
import com.satvaimal.hellopersistence.repository.AuthorRepository;
import com.satvaimal.hellopersistence.service.AuthorService;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
 
public class AuthorServiceImpl implements AuthorService {
 
  @Autowired
  private AuthorRepository authorRepository;
 
  @Transactional
  public Author create( Author author ) throws Exception {
 
    validateNull( author, "create" );
    return authorRepository.save( author );
 
  }// End of method
 
  @Transactional
  public List<Author> list() {
    return authorRepository.findAll();
  }// End of method
 
  @Transactional
  public Author get( long id ) {
    return authorRepository.findOne( id );
  }// End of method
 
  @Transactional
  public Author update( Author author ) throws Exception {
 
    validateNull( author, "update" );
 
    if ( !authorRepository.exists( author.getId() ) ) {
      throw new IllegalArgumentException(
          "authorService.update.author.not.found" );
    }// End of if
 
    return author;
 
  }// End of method
 
  @Transactional
  public void delete( Author author ) throws Exception {
 
    validateNull( author, "delete" );
    authorRepository.delete( author );
 
  }// End of method
 
  private void validateNull( Author author, String method ) throws Exception {
 
    if ( author == null ) {
      throw new IllegalArgumentException( "authorService." + method +
          ".author.null" );
    }// End of if
 
  }// End of method
 
}// End of class
