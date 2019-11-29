package com.example.library.infra;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class LendingEvent {

    private int id;
    private String isbn;
    private String userId;
    private LocalDateTime date;

    public LendingEvent(int id, String isbn, String userId, LocalDateTime date) {
        this.id = id;
        this.isbn = isbn;
        this.userId = userId;
        this.date = date;
    }
}
