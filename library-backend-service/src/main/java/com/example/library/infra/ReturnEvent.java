package com.example.library.infra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnEvent {
    private int id;
    private String isbn;
    private String userId;
    private LocalDateTime date;
}
