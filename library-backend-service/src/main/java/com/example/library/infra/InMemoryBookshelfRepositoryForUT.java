package com.example.library.infra;

import com.example.library.biz.bookshelf.Bookshelf;
import com.example.library.biz.bookshelf.BookshelfRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InMemoryBookshelfRepositoryForUT implements BookshelfRepository {

    private Bookshelf bookshelf;

    @Override
    public Bookshelf get() {

        return new Bookshelf(new ArrayList<>());
    }

    @Override
    public void store(Bookshelf bookshelf) {
        this.bookshelf = bookshelf;
    }

}