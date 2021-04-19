package com.udemy.Lamkhayar.controllers;

import com.udemy.Lamkhayar.entities.Etudiant;
import com.udemy.Lamkhayar.json.Student;
import com.udemy.Lamkhayar.producer.IProducer;
import com.udemy.Lamkhayar.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class ProducerController {
    @Autowired
    private IProducer producer;
    @Autowired
    private EtudiantRepository repository;
    @GetMapping(value="/send")
    public String sendMessage(){
        Student student = Student.builder().name("Lamkhayar").firstname("Elmejor").age(28).build();
        Etudiant etudiant = Etudiant.builder().nom(student.getName()).prenom(student.getFirstname()).age(student.getAge()).build();
        /*student.setName("Lamkhayar");
        student.setFirstname("Elmejor");
        student.setAge(28);*/

        repository.save(etudiant);
        producer.produceMessage(student);
        return student.toString();
    }

    @PostMapping("/save")
    public ResponseEntity saveAndSendStudent(@RequestBody Student student) {
        if (student == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Object student cannot be null");
        }
        Etudiant etudiant = Etudiant.builder().nom(student.getName()).prenom(student.getFirstname()).age(student.getAge()).build();
        /*student.setName("Lamkhayar");
        student.setFirstname("Elmejor");
        student.setAge(28);*/

        repository.save(etudiant);
        producer.produceMessage(student);
        return ResponseEntity.ok(student);
    }
}
