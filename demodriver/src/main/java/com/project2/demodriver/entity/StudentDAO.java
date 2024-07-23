package com.project2.demodriver.entity;

import java.util.List;

public interface StudentDAO {

    void save(Student thestudent);

    Student findById(Integer id);

    List<Student> findAll();

    void deleteBylastname();

    List<Student> findByLastName(String lastname);


    void updateObject(int id);


}
