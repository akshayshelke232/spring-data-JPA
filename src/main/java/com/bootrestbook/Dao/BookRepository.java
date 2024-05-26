package com.bootrestbook.Dao;

import org.springframework.data.repository.CrudRepository;

import com.bootrestbook.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

	public Book findById(int id);
}
