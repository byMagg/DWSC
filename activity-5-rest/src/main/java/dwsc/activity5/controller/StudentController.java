package dwsc.activity5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dwsc.activity5.model.Student;
import dwsc.activity5.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository studentRepo;

	@GetMapping("/students")
	public ResponseEntity<Iterable<Student>> getStudents() {
		return ResponseEntity.ok(studentRepo.findAll());
	}
	
	@GetMapping("/students/{dni}")
	public ResponseEntity<Student> getStudentByDni(@PathVariable String dni) {
		Student student = studentRepo.findByDni(dni);
		if (student != null) {
			return ResponseEntity.ok(student);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/students")
	public ResponseEntity<Student> deleteStudent(@RequestBody Student student) {
		studentRepo.delete(student);
		return ResponseEntity.ok(student);
	}
	
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		return ResponseEntity.ok(studentRepo.save(student));
	}

}