package com.oscarhanke.secretmanager;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @PostMapping
    public Book saveBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @GetMapping
    public List<Book> findBooks(){
        return bookRepository.findAll();
    }

    @SneakyThrows
    @GetMapping("{id}")
    public Book findBook(@PathVariable int id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID: " + id + " not found."));
        return book;
    }
}
