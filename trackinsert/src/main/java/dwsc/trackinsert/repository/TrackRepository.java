package dwsc.trackinsert.repository;

import org.springframework.data.repository.CrudRepository;

import dwsc.trackinsert.model.Track;

public interface TrackRepository extends CrudRepository<Track, Long> {

	<S extends Track> S save(S track);

}
