//package com.example.demo.student;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "api/v1/student")
//public class StudentController {
//
//    private final StudentService studentService;
//    @Autowired
//    public StudentController(StudentService studentService){
//        this.studentService = studentService;
//    }
//    @GetMapping
//    public List<Student> getStudents(){
//            return studentService.getStudents();
//    }
//
//    @PostMapping("add")
//     public void addStudent(@RequestBody Student student){
//        studentService.addNewStudent(student);
//    }
//
//    @DeleteMapping("{id}")
//    public String delStudentById(@PathVariable("id") Long id){
//        return studentService.delStudentById(id);
//    }
//
//}

package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("add")
    public void addStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping("{id}")
    public String delStudentById(@PathVariable("id") Long id) {
        return studentService.delStudentById(id);
    }

    @PutMapping("update/{id}")
    public String updateStudentById(@PathVariable("id") Long id, Student updatedStudent){
        return studentService.updateStudentById(id, updatedStudent);
    }

    @GetMapping("name")
    public ResponseEntity<List<Student>> findByName(@RequestParam String name) {
        List<Student> students = studentService.findByName(name);
        if (students.isEmpty()) {
            return ResponseEntity.status(404).body(students);
        }
        return ResponseEntity.ok(students);
    }
}

