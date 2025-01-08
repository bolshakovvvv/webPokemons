package kseoni.ch.pkmn.controllers;

import kseoni.ch.pkmn.models.Student;
import kseoni.ch.pkmn.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{group}")
    public ResponseEntity<List<Student>> getStudentsByGroup(@PathVariable String group) {
        return ResponseEntity.ok(studentService.getStudentsByGroup(group));
    }

    @GetMapping
    public ResponseEntity<Student> getStudentByFio(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.getStudentByFio(
                student.getFirstName(), student.getSurName(), student.getFamilyName()));
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.saveStudent(student));
    }
}
