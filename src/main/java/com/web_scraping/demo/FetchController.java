package com.web_scraping.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fetch")
public class FetchController {

    @Autowired
    private final BookScrapping bookScrapping;

    public FetchController(BookScrapping bookScrapping) {
        this.bookScrapping = bookScrapping;
    }

    @GetMapping("/book")
    public ResponseEntity book(){

        bookScrapping.fetchBook();

        return ResponseEntity.ok().build();
    }

}
