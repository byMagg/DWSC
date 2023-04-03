package dwsc.activity5swagger.repository;

import org.springframework.data.repository.CrudRepository;

import dwsc.activity5swagger.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	Student findByDni(String dni);

	void delete(Student student);

	<S extends Student> S save(S student);
}
