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
@Table(name="Mobilite")
public class DemandeMobilite {

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
    private Date dateDemandeMobilite;

    @Column(nullable=false)
    private String fullname;

    @Column(nullable=false)
    private Double salairePrs;

    @Column(nullable=false)
    private String depActuel;

    @Column(nullable=false)
    private String fonctActuel;

    @Column(nullable=false)
    private String depDemande;

    @Column(nullable=false)
    private String fonctDemande;



    @Column(nullable=false)
    private boolean augSalaire;

    @ManyToOne
    @JoinColumn(name = "users")
    private User utilisateur;

    public boolean getAugSalaire() {
        return augSalaire;
    }


    // Getters and setters
}

