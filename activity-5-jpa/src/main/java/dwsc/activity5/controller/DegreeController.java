package dwsc.activity5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dwsc.activity5.model.Degree;
import dwsc.activity5.repository.DegreeRepository;

@RestController
public class DegreeController {
	@Autowired
	DegreeRepository degreeRepo;

	@GetMapping("/degrees")
	public ResponseEntity<Iterable<Degree>> getStudents() {
		return ResponseEntity.ok(degreeRepo.findAll());
	}

	@GetMapping("/degrees/{code}")
	public ResponseEntity<Degree> getDegreeByCode(@PathVariable String code) {
		Degree degree = degreeRepo.findByCode(code);
		if (degree != null) {
			return ResponseEntity.ok(degree);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/degrees")
	public ResponseEntity<Degree> deleteDegree(@RequestBody Degree degree) {
		degreeRepo.delete(degree);
		return ResponseEntity.ok(degree);
	}
	
	@PutMapping("/degrees")
	public ResponseEntity<Degree> updateStudent(@RequestBody Degree degree) {
		return ResponseEntity.ok(degreeRepo.save(degree));
	}
}