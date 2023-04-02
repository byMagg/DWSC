package dwsc.activity5.repository;

import org.springframework.data.repository.CrudRepository;

import dwsc.activity5.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	Student findByDni(String dni);
	void delete(Student student);
	<S extends Student> S save(S student);
}
