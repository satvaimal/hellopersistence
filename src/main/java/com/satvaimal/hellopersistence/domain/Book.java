package com.satvaimal.hellopersistence.domain;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name="book")
public class Book {
 
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
 
  @Column(nullable = false, length = 100)
  private String title;
 
  @ManyToOne(optional = false)
  private Author author;
 
  public void setId( long id ) {
    this.id = id;
  }// End of method
 
  public long getId() {
    return id;
  }// End of method
 
  public void setTitle( String title ) {
    this.title = title;
  }// End of method
 
  public String getTitle() {
    return title;
  }// End of method
 
  public void setAuthor( Author author ) {
    this.author = author;
  }// End of method
 
  public Author getAuthor() {
    return author;
  }// End of method
 
}// End of class
