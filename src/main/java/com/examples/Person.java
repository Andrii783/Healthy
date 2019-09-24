package com.examples;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    @Enumerated(EnumType.ORDINAL)
    private NewGender gender;

    public Person(String firstName, NewGender gender) {
        this.firstName = firstName;
        this.gender = gender;
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public NewGender getGender() {
        return gender;
    }

    public void setGender(NewGender gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class TestPerson {
    public static void main(String[] args) {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("healthy");

            EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        NewGender gender = NewGender.MAN;

        Person person = new Person("John", gender);

        //em.persist(person);

        Person person1 = em.find(Person.class, 1);

        transaction.commit();

        em.close();
    }
}
