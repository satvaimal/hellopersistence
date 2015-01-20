package com.satvaimal.hellopersistence.domain;
 
import java.util.Date;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="author")
public class Author {
 
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
 
  @Column(nullable = false, length = 50)
  private String name;
 
  @Column(nullable = false)
  private Date birthdate;
 
  public void setId( long id ) {
    this.id = id;
  }// End of method
 
  public long getId() {
    return id;
  }// End of method
 
  public void setName( String name ) {
    this.name = name;
  }// End of method
 
  public String getName() {
    return name;
  }// End of method
 
  public void setBirthdate( Date birthdate ) {
    this.birthdate = birthdate;
  }// End of method
 
  public Date getBirthdate() {
    return birthdate;
  }// End of method
 
}// End of class
