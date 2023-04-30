package dwsc.trackinsert.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dwsc.trackinsert.model.Track;

public interface TrackRepository extends CrudRepository<Track, Integer> {

	<S extends Track> S save(S track);
	Optional<Track> findById(int id);

}
