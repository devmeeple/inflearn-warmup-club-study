package com.group.libraryapp.service.book;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Transactional
	public void saveBook(BookCreateRequest request) {
		bookRepository.save(new Book(request.getName()));
	}
}
