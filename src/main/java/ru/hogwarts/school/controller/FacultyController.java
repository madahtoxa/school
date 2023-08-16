package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService service;

    public FacultyController(FacultyService service) {
        this.service = service;
    }
    @GetMapping("/{id}")
    public Faculty getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Faculty create(@RequestBody Faculty faculty) {
        return service.create(faculty);
    }

    @GetMapping
    public Collection<Faculty> getAll() {
        return service.getAll();
    }
    @GetMapping("/filtered")
    public Collection<Faculty> getColor(@RequestParam("color") String color) {
        return service.getByColor(color);
    }
    @PutMapping
    public Faculty update (@PathVariable("id") Long id, @RequestBody Faculty faculty) {
        return service.update(id, faculty);
    }

    @DeleteMapping
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }


}