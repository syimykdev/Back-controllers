package com.example.Impreza.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    private final JpaRepository<Student, Long> repository;

    public StudentConfig(JpaRepository<Student, Long> repository) {
        this.repository = repository;
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
        Student mary = new Student(
                    1L,
                    "Mary",
                    "mary@gmail.com",
                    LocalDate.of(2000, Month.MAY,9)
            );
            Student sam = new Student(
                    2L,
                    "Sam",
                    "Sam@gmail.com",
                    LocalDate.of(2001, Month.MAY,12)
            );
            
            repository.saveAll(
                    List.of(mary,sam)
            );
        };
    }
}
