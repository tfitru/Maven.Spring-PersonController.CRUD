package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/people")
@CrossOrigin(value="http://localhost:63342")
public class PersonController {


    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Integer id){
        if(!personRepository.exists(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Person person = personRepository.findOne(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Person>> getAllPerson(){
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Integer id, @RequestBody Person person){
        if(personRepository.exists(id)){
           Person person1 = personRepository.findOne(id);
            person1.setFirstName(person.getFirstName());
            person1.setLastName(person.getLastName());
            personRepository.save(person1);
            return new ResponseEntity<>(person1, HttpStatus.OK);
        } else if(!personRepository.exists(id)){
            personRepository.save(person);
            return new ResponseEntity<>(person, HttpStatus.CREATED);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deleteById(@PathVariable Integer id){
        Person person = personRepository.findOne(id);
        personRepository.delete(person);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

  }

