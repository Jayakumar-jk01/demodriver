package com.project2.demodriver.entity;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntitymanager)
    {
        entityManager=theEntitymanager;
    }

    @Override
    @Transactional
    public void save(Student theStudent)
    {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery=entityManager.createQuery("select s FROM Student s order by first_name", Student.class);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void deleteBylastname() {
        int noofrows=entityManager.createQuery("DELETE FROM Student WHERE last_name='friend'").executeUpdate();


    }

    @Override
    public List<Student> findByLastName(String lastname) {
        TypedQuery<Student> theQuery= entityManager.createQuery("select s FROM Student s WHERE last_name=:theData", Student.class);

        theQuery.setParameter("theData",lastname);

        return theQuery.getResultList();


    }

    @Override
    @Transactional
    public void updateObject(int id) {

        Student theStudent=entityManager.find(Student.class,1);

        theStudent.setLast_name("Azahaiya Laila");
        entityManager.merge(theStudent);

    }


}
