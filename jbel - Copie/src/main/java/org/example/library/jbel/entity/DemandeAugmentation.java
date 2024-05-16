package org.example.library.jbel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Augmentation")
public class DemandeAugmentation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable=false)
    private String motif;

    @Column(nullable=false)
    private String codeSalarie;

    @Column(nullable=false)
    private String matricule;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDemandeAug;

    @Column(nullable=false)
    private Boolean augPrime;


    @Column(nullable=false)
    private Boolean augSalaire;

    @Column(nullable=false)
    private String fullname;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateLastAug;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateEmbauche;

    @Column(nullable=false)
    private Double salairePrs;


    @Column(nullable=false)
    private Double salaireDemande;


    @Column(nullable=false)
    private Double prime;

    @ManyToOne
    @JoinColumn(name = "users")
    private User utilisateur;

    // Getters and setters
}

