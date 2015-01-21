package com.satvaimal.hellopersistence.repository;
 
import com.satvaimal.hellopersistence.domain.Book;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface BookRepository extends JpaRepository<Book, Long> {}
