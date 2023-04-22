package dwsc.tracksearch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dwsc.tracksearch.model.Track;

public interface TrackRepository extends JpaRepository<Track, Long> {
	List<Track> findByName(String name);
}
