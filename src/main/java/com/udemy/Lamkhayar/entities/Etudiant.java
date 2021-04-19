package com.udemy.Lamkhayar.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ETUDIANT")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue
    private Long idEtudiant;
    private String nom;
    private String prenom;
    private int age;
}
