package com.example.library.infra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LendingEvent {
    public LendingEvent(String isbn, String userId, LocalDateTime lendingDate) {
        this.isbn = isbn;
        this.userId = userId;
        this.lendingDate = lendingDate;
    }

    String isbn;
    String userId;
    LocalDateTime lendingDate;
    // TODO なんに使う？
    int count;
}
