package com.satvaimal.hellopersistence.repository;
 
import com.satvaimal.hellopersistence.domain.Author;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface AuthorRepository extends JpaRepository<Author, Long> {}
