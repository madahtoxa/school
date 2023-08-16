package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.DataNotFoundExceptions;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty create(Faculty faculty) {return facultyRepository.save(faculty);
    }

    public Faculty getById(Long id) {
        return facultyRepository.findById(id).orElseThrow(DataNotFoundExceptions::new);
    }
    public Collection<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    public Collection<Faculty> getByColor(String color) {
        return facultyRepository.findAllByColor(color);
    }

    public Faculty update(Long id, Faculty faculty) {
        Faculty existingFaculty = facultyRepository.findById(id)
                .orElseThrow(DataNotFoundExceptions::new);
        if (faculty.getColor() != null) {
            existingFaculty.setColor(faculty.getColor());
        }
        if (faculty.getName() != null) {
            existingFaculty.setName(faculty.getName());
        }
        return facultyRepository.save(existingFaculty);
    }

    public Faculty delete(Long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(DataNotFoundExceptions::new);
        facultyRepository.delete(faculty);
        return faculty;
    }
}