package com.shredder.studentws.service;

import com.shredder.studentws.entity.StudentEntity;
import com.shredder.studentws.model.StudentCreateRequest;
import com.shredder.studentws.model.StudentUpdateRequest;
import com.shredder.studentws.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void createUser(StudentCreateRequest request){

        if(request.getName().equals("")) throw new RuntimeException("hrfhrfhrf");

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(request.getName());
        studentEntity.setDob(request.getDob());
        studentEntity.setStd(request.getStd());

        studentRepository.save(studentEntity);
    }
    public List<StudentEntity> createStudents(List<StudentEntity> studentEntityList){
        return (List<StudentEntity>) studentRepository.saveAll(studentEntityList);
    }
    public StudentEntity getStudentByID (Long userID){

        Optional<StudentEntity> studentOptional = studentRepository.findById(userID);
        return studentOptional.orElseGet(StudentEntity::new);
    }
    public StudentEntity getStudentByName (String name){

        Optional<StudentEntity> studentOptional = studentRepository.findByName(name);
        return studentOptional.orElseGet(StudentEntity::new);
    }
    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }
   public String deleteStudent(long userID){
        studentRepository.deleteById(userID);
        return "Student details deleted"+userID;
   }
    public String deleteStudents(){
        studentRepository.deleteAll();
        return "All student details deleted";
    }
   public StudentEntity updateStudent(StudentUpdateRequest updateRequest, Long userId){

       Optional<StudentEntity> byId = studentRepository.findById(userId);
       StudentEntity studentEntity = byId.get();

       studentEntity.setDob(updateRequest.getDob());
       studentEntity.setName(updateRequest.getName());
       studentEntity.setStd(updateRequest.getStd());
       return studentRepository.save(studentEntity);


   }



}
