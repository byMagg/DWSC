package dwsc.activity5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestBody;

import dwsc.activity5.model.Student;

@RestResource(path="students", rel="students")
public interface StudentRepository extends CrudRepository<Student, Long> {
	
	Student findByDni(@Param("dni") String dni);
	void delete(@RequestBody Student student);
	<S extends Student> S save(@RequestBody S student);
}
