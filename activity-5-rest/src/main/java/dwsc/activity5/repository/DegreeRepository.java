package dwsc.activity5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestBody;

import dwsc.activity5.model.Degree;

@RestResource(path="degrees", rel="degrees")
public interface DegreeRepository extends CrudRepository<Degree, Long> {
	
	Degree findByCode(@Param("code") String code);
	void delete(@RequestBody Degree degree);
	<S extends Degree> S save(@RequestBody S degree);
}
