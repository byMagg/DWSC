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
import dwsc.activity5swagger.model.Degree;
import dwsc.activity5swagger.repository.DegreeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class DegreeController {
	@Autowired
	DegreeRepository degreeRepo;

	@Operation(summary = "Buscar todos los degrees", description = "Operación para buscar todos los degrees")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Degrees obtenidos")
	})
	@GetMapping("/degrees")
	public ResponseEntity<Iterable<Degree>> getStudents() {
		return ResponseEntity.ok(degreeRepo.findAll());
	}

	@Operation(summary = "Buscar degrees por código", description = "Operación para buscar los degrees dado un código")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Degree obtenido"),
			@ApiResponse(responseCode = "404", description = "Degree no encontrado", content = @Content(schema = @Schema(implementation = CustomResponse.class)))
	})
	@GetMapping("/degrees/{code}")
	public ResponseEntity<Degree> getDegreeByCode(
			@Parameter(description = "El código del degree") @PathVariable String code) {
		Degree degree = degreeRepo.findByCode(code);
		if (degree != null) {
			return ResponseEntity.ok(degree);
		} else {
			throw new ElementNotFoundException(HttpStatus.NOT_FOUND, "Este degree no existe");
		}
	}

	@Operation(summary = "Eliminar un degree", description = "Operación para eliminar un degree dado en elemento en el body")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Degree eliminado")
	})
	@DeleteMapping("/degrees")
	public ResponseEntity<Degree> deleteDegree(@RequestBody Degree degree) {
		degreeRepo.delete(degree);
		return ResponseEntity.ok(degree);
	}

	@Operation(summary = "Añadir un degree", description = "Operación para añadir un degree dado en el body")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Degree añadido")
	})
	@PutMapping("/degrees")
	public ResponseEntity<Degree> updateStudent(@RequestBody Degree degree) {
		return ResponseEntity.ok(degreeRepo.save(degree));
	}
}