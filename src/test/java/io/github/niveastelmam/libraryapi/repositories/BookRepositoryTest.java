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


    // Default: Find the author, associate it with the book, then save the book
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

    // Save the Book and the Author in the same method. First save the author and then the book.
    @Test
    void saveAuthorAndBookTest(){
        Book book = new Book();
        book.setIsbn("12345-67853");
        book.setPrice(BigDecimal.valueOf(100));
        book.setGender(BookGenre.FICTION);
        book.setTitle("Uzumaki");
        book.setPublicationDate(LocalDate.of(2018, 5, 22));

        Author author = new Author();
        author.setName("Junji Ito");
        author.setNationality("Japanese");
        author.setDateBirth(LocalDate.of(1947, 9, 21));

        authorRepository.save(author);

        book.setAuthor(author);

        bookRepository.save(book);
    }

    // Example Cascade: create a new Author, Book association and save only the Book
    @Test
    void saveCascadeTest(){
        Book book = new Book();
        book.setIsbn("12345-67853");
        book.setPrice(BigDecimal.valueOf(100));
        book.setGender(BookGenre.FICTION);
        book.setTitle("Revolução dos bichos");
        book.setPublicationDate(LocalDate.of(2018, 5, 22));

        Author author = new Author();
        author.setName("George Orwell");
        author.setNationality("British");
        author.setDateBirth(LocalDate.of(1947, 9, 21));


        book.setAuthor(author);

        bookRepository.save(book);
    }

    @Test
    void updateTheBookAuthor(){
        UUID id = UUID.fromString("b8351d74-5440-459b-afe8-a4552279fed0");
        var bookToUpdate = bookRepository.findById(id).orElse(null);

        UUID idAuthor = UUID.fromString("3d8c2b36-e948-4dfd-b1b1-2f097f9fbc6b");
        Author stephen = authorRepository.findById(idAuthor).orElse(null);

        bookToUpdate.setAuthor(stephen);
        bookRepository.save(bookToUpdate);

    }

    @Test
    void delete(){
        UUID id = UUID.fromString("b8351d74-5440-459b-afe8-a4552279fed0");
        bookRepository.deleteById(id);
    }

    @Test
    void deleteCascade(){
        UUID id = UUID.fromString("54daccae-c5b9-4948-8b3c-dfac83a98fc1");
        bookRepository.deleteById(id);

    }
    
}