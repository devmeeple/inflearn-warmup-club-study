package com.group.libraryapp.domain.user.loanhistory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {
	// SELECT * FROM user_loan_history WHERE book_name = ? AND is_return = ?
	boolean existsByBookNameAndIsReturn(String bookName, boolean isReturn);

	Optional<UserLoanHistory> findByUserIdAndBookName(long userId, String bookName);
}
