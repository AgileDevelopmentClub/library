package com.example.library.app_service;

import com.example.library.domain.book.Book;
import com.example.library.domain.book.BookRepository;
import com.example.library.domain.lending.LendingRecord;
import com.example.library.domain.lending.LendingRecordRepository;
import com.example.library.domain.user.User;
import com.example.library.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LendingRecordsServiceImpl implements LendingRecordsService {
    private final LendingRecordRepository lendingRecordRepository;
    private  final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Override
    public List<LendingRecord> searchForEvent(String... options) {
        return lendingRecordRepository.findAllForEvent();
    }

    @Override
    public void borrow(String isbn, String userId) {
        Book book = bookRepository.findById(isbn);
        User user = userRepository.findById(userId);

        if(book == null || user == null) throw new RuntimeException("本かユーザが登録されていない");

        LendingRecord lendingRecord = new LendingRecord(book, user);
        lendingRecordRepository.register(lendingRecord);
    }

    @Override
    public void returnn(String isbn, String userId) {
        Book book = bookRepository.findById(isbn);
        User user = userRepository.findById(userId);

        if(book == null || user == null) throw new RuntimeException("本かユーザが登録されていない");

        LendingRecord lendingRecord = lendingRecordRepository.findById(book, user);
        lendingRecordRepository.delete(lendingRecord);
    }
}
