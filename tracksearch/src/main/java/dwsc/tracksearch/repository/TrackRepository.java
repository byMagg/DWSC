package dwsc.tracksearch.repository;

import org.springframework.data.repository.CrudRepository;

import dwsc.tracksearch.model.Track;

public interface TrackRepository extends CrudRepository<Track, Long> {
	Track findByName(String name);
}
