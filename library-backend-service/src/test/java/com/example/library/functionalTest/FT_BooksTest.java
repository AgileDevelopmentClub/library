package com.example.library.functionalTest;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FT_BooksTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Nested
    class 検索 {
        @DisplayName("本の一覧を取得する")
        @Test
        void test_01() throws URISyntaxException {
            URI url = URI.create("/v1/books");

            RequestEntity requestEntity = RequestEntity.get(url).build();

            ResponseEntity<Object> response =
                    restTemplate.exchange(requestEntity, Object.class);

            SoftAssertions softly = new SoftAssertions();
            softly.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_IMPLEMENTED);
            softly.assertAll();
        }
    }

}