package dwsc.trackinsert.repository;

import org.springframework.data.repository.CrudRepository;

import dwsc.trackinsert.model.Track;

public interface TrackRepository extends CrudRepository<Track, Long> {

	Track findByName(String name);

}
