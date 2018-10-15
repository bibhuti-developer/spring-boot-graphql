package com.bsa.graphql.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table 
@Entity
public class Book {
	@Id
	private String isn;
	private String title;
	private String publisher;
	private String[] authors;
	private String publishedDate;
	
	protected Book() {
		super();
	}

	public Book(String isn, String title, String publisher, String[] authors, String publishedDate) {
		super();
		this.isn = isn;
		this.title = title;
		this.publisher = publisher;
		this.authors = authors;
		this.publishedDate = publishedDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [isn=");
		builder.append(isn);
		builder.append(", title=");
		builder.append(title);
		builder.append(", publisher=");
		builder.append(publisher);
		builder.append(", authors=");
		builder.append(Arrays.toString(authors));
		builder.append(", publishedDate=");
		builder.append(publishedDate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
