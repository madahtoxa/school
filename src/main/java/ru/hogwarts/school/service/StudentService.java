package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.DataNotFoundExceptions ;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.Optional;


@Service

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Collection<Student> getByAge(int age){
        return studentRepository.findAllByAge(age);
    }

    public Student getById(Long id){
        return studentRepository.findById(id).orElseThrow(DataNotFoundExceptions::new);
    }
    public Collection<Student> getAll(){
        return studentRepository.findAll();
    }
    public Student create(Student student){
        return studentRepository.save(student);
    }
    public Student update(Long id, Student student){
        Student existingStudent = studentRepository.findById(id).orElseThrow(DataNotFoundExceptions::new);
        Optional.ofNullable(student.getName()).ifPresent(existingStudent::setName);
        Optional.ofNullable(student.getAge()).ifPresent(existingStudent::setAge);
        return studentRepository.save(student);
    }
    public Student delete(Long id){
        Student existingStudent = studentRepository.findById(id).orElseThrow(DataNotFoundExceptions::new);
        studentRepository.delete(existingStudent);
        return existingStudent;
    }
    public Collection<Student> getByAgeBetween(int min, int max){
        return studentRepository.findAllByAgeBetween(min,max);
    }
    public Collection<Student> getByFacultyId(Long facultyId){
        return studentRepository.findAllByFacultyId(facultyId);
    }
}