package com.bsa.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bsa.graphql.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

}
