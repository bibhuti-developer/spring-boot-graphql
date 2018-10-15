package com.bsa.graphql.service;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.bsa.graphql.model.Book;
import com.bsa.graphql.repository.BookRepository;
import com.bsa.graphql.service.datafetcher.AllBooksDataFetcher;
import com.bsa.graphql.service.datafetcher.BookDataFetcher;

import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {
	
	@Value("classpath:books.graphql")
	private Resource resource;
	
	@Autowired
	private AllBooksDataFetcher allBooksDataFetcher;
	
	@Autowired
	private BookDataFetcher bookDataFetcher;
	
	@Autowired
	private BookRepository bookRepository;
	
	private GraphQL graphQL;
	
	@PostConstruct
	private void loadSchema() throws IOException {
		loadDataIntoHSQL();
		
		// get the schema
		File schemaFile = resource.getFile();
		
		// parse schema
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();
	}

	private void loadDataIntoHSQL() {
		Stream.of(
				new Book("A103", "JAVA" , "XYZ", new String[] {"First"},"APR 2018"),
				new Book("A109", "JS" , "ABC", new String[] {"Second"},"JAN 2015")
		).forEach(
				book -> bookRepository.save(book)
		);
	}

	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring.newRuntimeWiring()
				.type("Query", typeWiring -> {
					return typeWiring
						.dataFetcher("allBooks", allBooksDataFetcher)
						.dataFetcher("books", bookDataFetcher);
						})
				.build();
	}
	
	public GraphQL getGraphQL() {
		return graphQL;
	}
}
