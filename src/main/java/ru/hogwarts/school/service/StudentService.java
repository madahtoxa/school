package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.DataNotFoundExceptions;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow(DataNotFoundExceptions::new);
    }
    public Collection<Student> getAll() {
        return studentRepository.findAll();
    }
    public Collection<Student> getByAge(int age) {
        return studentRepository.findAllByAge(age);
    }
    public Student create(Student student) {
        return studentRepository.save(student);
    }
    public Student update(Long id, Student student) {
        Student exsistingStudent = studentRepository.findById(id).orElseThrow(DataNotFoundExceptions::new);
        Optional.ofNullable(student.getName()).ifPresent(exsistingStudent::setName);
        Optional.ofNullable(student.getAge()).ifPresent(exsistingStudent::setAge);
        return studentRepository.save(exsistingStudent);
    }
    public Student delete(Long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(DataNotFoundExceptions::new);
        studentRepository.delete(existingStudent);
        return existingStudent;
    }

}