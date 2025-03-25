package io.github.niveastelmam.libraryapi;

import io.github.niveastelmam.libraryapi.models.Author;
import io.github.niveastelmam.libraryapi.repositories.AuthorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class LibraryapiApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(LibraryapiApplication.class, args);
		AuthorRepository repository = context.getBean(AuthorRepository.class);

		exampleSaveRecord(repository);

	}

	public static void exampleSaveRecord(AuthorRepository authorRepository){
		Author author = new Author();
		author.setName("George Orwell");
		author.setNationality("British");
		author.setDateBirth(LocalDate.of(1903, 6, 25));

		var authorSaved = authorRepository.save(author);
		System.out.println("Author saved: " + authorSaved );

	}
}
