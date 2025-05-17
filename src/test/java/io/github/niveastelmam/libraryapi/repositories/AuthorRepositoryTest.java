package io.github.niveastelmam.libraryapi.repositories;

import io.github.niveastelmam.libraryapi.models.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;


    @Test
    public void saveTest(){

        Author author = new Author();
        author.setName("Stephen King");
        author.setNationality("American");
        author.setDateBirth(LocalDate.of(1947, 9, 21));

        var authorSaved = authorRepository.save(author);
        System.out.println("Author saved: " + authorSaved );

    }

    @Test
    public void updateTest(){
        var id = UUID.fromString("21f06242-89c0-4d04-84a3-81bccf5bb6db");

        Optional<Author> possibleAuthor = authorRepository.findById(id);

        Author authorFound = possibleAuthor.get();
        if(possibleAuthor.isPresent()){
            System.out.println("Author details");
            System.out.println(authorFound);

            authorFound.setDateBirth(LocalDate.of(1948,9,21));
            authorRepository.save(authorFound);

        }
    }
    @Test
    public void updateWithoutFindById (){
        var id = UUID.fromString("21f06242-89c0-4d04-84a3-81bccf5bb6db");
        Author authorExistent = new Author();

        authorExistent.setName("teste");
        authorExistent.setNationality("brazilian");
        authorExistent.setId(id);
        authorExistent.setDateBirth(LocalDate.of(1989, 10, 5));

        authorRepository.save(authorExistent);
    }

    @Test
    public void ListTest(){
       List<Author> list = authorRepository.findAll();
       list.forEach(System.out::println);

    }

    @Test
    public void countTest(){
        System.out.println("Number of authors:" + authorRepository.count());
    }

    @Test
    public void deleteByIdTest(){
        var id = UUID.fromString("21f06242-89c0-4d04-84a3-81bccf5bb6db");
        authorRepository.deleteById(id);
    }

    // Delete the object, complete entity
    @Test
    public void deleteTest(){
        var id = UUID.fromString("0245583e-9891-466d-9c21-f051204ca862");
        var test = authorRepository.findById(id).get();
        authorRepository.delete(test);
    }
}

