//package com.example.demo.student;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class StudentConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository repository){
//        return args -> {
//            Student Aryan = new Student(
//            "aryan",
//            "aryab@jbdsa.com",
//            21
//            );
//            Student Sharma = new Student(
//                    "sharma",
//                    "sharma@jbdsa.com",
//                    22
//            );
//
//            repository.saveAll(
//                    List.of(Aryan, Sharma)
//            );
//        };
//    }
//}
