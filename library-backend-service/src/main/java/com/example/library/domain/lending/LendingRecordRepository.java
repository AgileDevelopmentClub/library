package com.example.library.domain.lending;


public interface LendingRecordRepository {
    void register(LendingRecord lendingRecord);

    void receive(LendingRecord lendingRecord);
}
