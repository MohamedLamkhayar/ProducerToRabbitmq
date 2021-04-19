package com.udemy.Lamkhayar.repositories;

import com.udemy.Lamkhayar.entities.Etudiant;
import com.udemy.Lamkhayar.json.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

}
