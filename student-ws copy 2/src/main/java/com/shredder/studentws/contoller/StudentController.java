package com.shredder.studentws.contoller;


import com.shredder.studentws.entity.StudentEntity;
import com.shredder.studentws.model.StudentCreateRequest;
import com.shredder.studentws.model.StudentUpdateRequest;
import com.shredder.studentws.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {
//    SOLID
    @Autowired
    StudentService studentService;
    @PostMapping("/api/v1/student")
    public ResponseEntity<String> createStudent(@Valid @RequestBody StudentCreateRequest studentCreateRequest){

        studentService.createUser(studentCreateRequest);

        return ResponseEntity.ok("Created");

    }
    @PostMapping("/api/v1/students")
    public ResponseEntity<String> createStudents(@Valid @RequestBody List<StudentEntity> studentEntityList){
        studentService.createStudents(studentEntityList);
        return ResponseEntity.ok("Successfully created");

    }
    @GetMapping("/api/v1/studentById/{userid}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable Long userid){

        return ResponseEntity.ok(studentService.getStudentByID(userid));
    }
    @GetMapping("/api/v1/studentByName/{name}")
    public ResponseEntity<StudentEntity> getStudentByName(@PathVariable String name){

        return ResponseEntity.ok(studentService.getStudentByName(name));
    }
    @GetMapping("/api/v1/studentFindAll")
    public ResponseEntity<List<StudentEntity>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }
    @PutMapping("/api/v1/student/{userId}")
    public StudentEntity updateStudent(@RequestBody StudentUpdateRequest studentUpdateRequest, @PathVariable Long userId){

        return studentService.updateStudent(studentUpdateRequest,userId);
    }
    @DeleteMapping("/api/v1/student/delete/{userid}")
    public String deleteStudent(@PathVariable long userid){
        return studentService.deleteStudent(userid);
    }

    @DeleteMapping("/api/v1/student/deleteAll")
    public String deleteStudents()
    {
        studentService.deleteStudents();
        return "All details deleted";
    }


}
