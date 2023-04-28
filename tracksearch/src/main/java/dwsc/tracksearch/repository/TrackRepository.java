package dwsc.tracksearch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dwsc.tracksearch.model.Track;

public interface TrackRepository extends JpaRepository<Track, Long> {
	List<Track> findByNameContainsIgnoreCase(String name);
	List<Track> findByArtistContainsIgnoreCase(String artist);
	List<Track> findByYearContainsIgnoreCase(String year);
	Optional<Track> findById(Long id);
	List<Track> findAll();
}
