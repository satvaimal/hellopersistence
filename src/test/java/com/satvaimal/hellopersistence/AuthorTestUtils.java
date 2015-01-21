package com.satvaimal.hellopersistence;
 
import com.satvaimal.hellopersistence.domain.Author;
 
import java.util.Date;
 
public class AuthorTestUtils {
 
  public static Author createAuthor( String name ) {
 
    Author author = new Author();
    author.setName( name );
    author.setBirthdate( new Date() );
    return author;
 
  }// End of method
 
}// End of class
