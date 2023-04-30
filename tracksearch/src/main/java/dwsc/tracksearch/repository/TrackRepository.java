package dwsc.tracksearch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dwsc.tracksearch.model.Track;

public interface TrackRepository extends JpaRepository<Track, Integer> {
	List<Track> findByNameContainsIgnoreCase(String name);
	List<Track> findByArtistContainsIgnoreCase(String artist);
	List<Track> findByYear(int year);
	Optional<Track> findById(int id);
	List<Track> findAll();
}
