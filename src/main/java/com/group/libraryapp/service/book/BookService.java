package com.group.libraryapp.service.book;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {

	private final BookRepository bookRepository;
	private final UserLoanHistoryRepository userLoanHistoryRepository;
	private final UserRepository userRepository;

	@Transactional
	public void saveBook(BookCreateRequest request) {
		bookRepository.save(new Book(request.getName()));
	}

	/**
	 * 1. 책 정보를 가져온다
	 * 2. 대출기록을 확인하여 대출여부를 검증한다
	 * 3. 대출 중이라면 예외가 발생한다
	 * 4. 유저 정보를 가져온다
	 * 5. 유저 정보와 책 정보를 기반으로 대출정보를 저장한다
	 */
	@Transactional
	public void loanBook(BookLoanRequest request) {
		Book book = bookRepository.findByName(request.getBookName()).orElseThrow(IllegalArgumentException::new);

		// 반납되지 않은 책이 존재한다면 (대출 중) -> 예외
		if (userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)) {
			throw new IllegalArgumentException("이미 대출 중입니다");
		}

		User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalArgumentException::new);
		user.loanBook(book.getName());
	}

	@Transactional
	public void returnBook(BookReturnRequest request) {
		User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalArgumentException::new);

		user.returnBook(request.getBookName());
	}
}
