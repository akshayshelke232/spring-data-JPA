package com.bootrestbook.services;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import com.bootrestbook.Dao.BookRepository;
import com.bootrestbook.entities.Book;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
//	private static List<Book> list = new ArrayList<>();
//	
//	static 
//	{
//		list.add(new Book(11,"java","Akshay"));
//		list.add(new Book(22,"python","sachin"));
//		list.add(new Book(33,"c++","pratik"));
//	}
	public List<Book> getAllBooks()
	{
		List<Book> list=(List<Book>) this.bookRepository.findAll();
		return list;
	}
	public Book getBookByID(int id)
	{ 
		Book book = null;
		try
		{
//		book = list.stream().filter(e->e.getId() == id).findFirst().get();
			
			book = this.bookRepository.findById(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return book;
	}
	

	public Book addBook(Book b)
	{
//		list.add(b);
		Book result = bookRepository.save(b);
		return result;
	}
	
	public void deleteBook(int id) {
		Book book = null;
//		list = list.stream().filter(e->(e.getId() != id)).collect(Collectors.toList());
		bookRepository.deleteById(id);

	}
	public void updateBook(Book book, int bookId) {
		
//		list = list.stream().map(b->{
//			if(b.getId() == bookId)
//			{
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		book.setId(bookId);
		bookRepository.save(book);
		
	}
}
