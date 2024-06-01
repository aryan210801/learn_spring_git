//package com.example.demo.student;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class StudentService {
//    private final StudentRepository studentRepository;
//    @Autowired
//    public StudentService(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
//
//    public List<Student> getStudents(){
//        return studentRepository.findAll();
//    }
//
//    public void addNewStudent(Student student) {
//
//    }
//
//    public String delStudentById(Long id){
//        studentRepository.deleteById(id);
//        return "deleted";
//    }
//}

package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student){
        studentRepository.save(student);
    }

    @Transactional
    public String delStudentById(Long id) {
        try {
            studentRepository.deleteById(id);
            return "deleted";
        } catch (Exception e) {
            return "Student with ID " + id + " does not exist.";
        }
    }
    @Transactional
    public String updateStudentById(Long id, Student updatedStudent){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            Student existingStudent = studentOptional.get();
            if(updatedStudent.getName() != null){
                existingStudent.setName(updatedStudent.getName());
            }
            if(updatedStudent.getEmail() != null){
                existingStudent.setEmail(updatedStudent.getEmail());
            }
            studentRepository.save(existingStudent);
            return "updated";
        }
        else{
            return "student with id"+id+"not found";
        }
    }

    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

        

}

