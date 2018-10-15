package com.bsa.graphql.service.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import com.bsa.graphql.model.Book;
import com.bsa.graphql.repository.BookRepository;

@Component
public class AllBooksDataFetcher implements DataFetcher<List<Book>>{
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> get(DataFetchingEnvironment environment) {
		return bookRepository.findAll();
	}

}
