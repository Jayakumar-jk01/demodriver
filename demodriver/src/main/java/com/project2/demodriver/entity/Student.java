package com.project2.demodriver.entity;


import jakarta.persistence.*;

@Entity
@Table(name= "Student")
public class Student extends Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private  String last_name;

    @Column(name = "email")
    private String email;
    public Student(){}

    public Student( String first_name, String last_name, String email) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Student{firstName=" + this.first_name + ", lastName='" + this.last_name + "', email='" + email + "'}";
    }
}
