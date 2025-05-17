package io.github.niveastelmam.libraryapi.repositories;


import io.github.niveastelmam.libraryapi.models.Author;
import io.github.niveastelmam.libraryapi.models.Book;
import io.github.niveastelmam.libraryapi.models.BookGenre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Test
    void saveTest(){
         Book book = new Book();
         book.setIsbn("12345-67853");
         book.setPrice(BigDecimal.valueOf(100));
         book.setGender(BookGenre.FICTION);
         book.setTitle("The outsider");
         book.setPublicationDate(LocalDate.of(2018, 5, 22));

         Author author = authorRepository.findById(UUID.fromString("3d8c2b36-e948-4dfd-b1b1-2f097f9fbc6b")).orElse(null);

         book.setAuthor(author);

         bookRepository.save(book);
    }

}