package io.github.niveastelmam.libraryapi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_author", schema = "public")
@Data
public class Author {

    @Id
    @Column(name =  "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "date_birth", nullable = false)
    private LocalDate dateBirth;

    @Column(name = "nationality", length = 50, nullable = false)
    private String nationality;

    //@OneToMany(mappedBy = "author" )
    @Transient
    private List<Book> books;

}
