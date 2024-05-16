package org.example.library.jbel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="sortie")
public class DemandeSortie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable=false)
    private String motif;

    @Column(nullable=false)
    private String codeSalarie;

    @Column(nullable=false)
    private String matricule;

    @Column(nullable=false)
    private String respDep;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateSortie;


    @Column(nullable=false)
    private String fullname;

    @Column(name = "heureEntree")
    private LocalTime heureEntree;

    @Column(name = "heureSortie")
    private LocalTime heureSortie;

    @ManyToOne
    @JoinColumn(name = "users")
    private User utilisateur;

    // Getters and setters
}
