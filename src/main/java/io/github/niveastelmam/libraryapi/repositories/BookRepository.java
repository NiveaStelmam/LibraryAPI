package io.github.niveastelmam.libraryapi.repositories;

import io.github.niveastelmam.libraryapi.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
