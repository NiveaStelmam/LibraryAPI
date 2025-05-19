package io.github.niveastelmam.libraryapi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_book")
@Data
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "isbn", length = 20, nullable = false)
    private String isbn;

    @Column(name = "title", length = 150, nullable = false)
    private String title;

    @Column(name = "publication_name")
    private LocalDate publicationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 30, nullable = false)
    private BookGenre gender;

    @Column(name = "price", precision = 18, scale = 2)
    private BigDecimal price;

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_author")
    private Author author;

}
