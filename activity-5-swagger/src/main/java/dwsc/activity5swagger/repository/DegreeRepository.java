package dwsc.activity5swagger.repository;

import org.springframework.data.repository.CrudRepository;

import dwsc.activity5swagger.model.Degree;

public interface DegreeRepository extends CrudRepository<Degree, Long> {

	Degree findByCode(String code);

	void delete(Degree degree);

	<S extends Degree> S save(S degree);
}
