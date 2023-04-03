package dwsc.activity5swagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dwsc.activity5swagger.exception.CustomResponse;
import dwsc.activity5swagger.exception.ElementNotFoundException;
import dwsc.activity5swagger.model.Student;
import dwsc.activity5swagger.repository.StudentRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class StudentController {
	@Autowired
	StudentRepository studentRepo;

	@Operation(summary = "Buscar todos los students", description = "Operación para buscar todos los students")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "students obtenidos")
	})
	@GetMapping("/students")
	public ResponseEntity<Iterable<Student>> getStudents() {
		return ResponseEntity.ok(studentRepo.findAll());
	}

	@Operation(summary = "Buscar students por código", description = "Operación para buscar los students dado un código")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "student obtenido"),
			@ApiResponse(responseCode = "404", description = "student no encontrado", content = @Content(schema = @Schema(implementation = CustomResponse.class)))
	})
	@GetMapping("/students/{dni}")
	public ResponseEntity<Student> getStudentByDni(
			@Parameter(description = "El dni del student") @PathVariable String dni) {
		Student student = studentRepo.findByDni(dni);
		if (student != null) {
			return ResponseEntity.ok(student);
		} else {
			throw new ElementNotFoundException(HttpStatus.NOT_FOUND, "Este student no existe");
		}
	}

	@Operation(summary = "Eliminar un student", description = "Operación para eliminar un student dado en elemento en el body")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "student eliminado")
	})
	@DeleteMapping("/students")
	public ResponseEntity<Student> deleteStudent(@RequestBody Student student) {
		studentRepo.delete(student);
		return ResponseEntity.ok(student);
	}

	@Operation(summary = "Añadir un student", description = "Operación para añadir un student dado en el body")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "student añadido")
	})
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		return ResponseEntity.ok(studentRepo.save(student));
	}

}