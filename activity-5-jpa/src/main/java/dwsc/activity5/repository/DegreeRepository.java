package dwsc.activity5.repository;

import org.springframework.data.repository.CrudRepository;

import dwsc.activity5.model.Degree;

public interface DegreeRepository extends CrudRepository<Degree, Long> {
	
	Degree findByCode(String code);
	void delete(Degree degree);
	<S extends Degree> S save(S degree);
}
