package io.zipcoder.crudapp;

import javax.persistence.*;

@Entity
@Table(name="PERSON")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    Person() {
    }

    Person(Integer id, String firstname, String lastname){
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastname;
    }

    Person(String firstname, String lastname) {
        this.firstName = firstname;
        this.lastName = lastname;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

}
