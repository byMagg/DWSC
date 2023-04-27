package dwsc.tracksearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dwsc.tracksearch.model.Track;
import dwsc.tracksearch.repository.TrackRepository;

@RestController
public class TrackController {

	@Autowired
	TrackRepository trackRepo;

	@GetMapping("/tracks")
	public ResponseEntity<List<Track>> getTracks() {
		List<Track> tracks = trackRepo.findAll();
		if (tracks != null) {
			return ResponseEntity.ok(tracks);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/tracks/{id}")
	public ResponseEntity<Track> getTrackById(@PathVariable String id) {
		Track track = trackRepo.findById(id);
		if (track != null) {
			return ResponseEntity.ok(track);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/search")
	public ResponseEntity<List<Track>> getTrackByField(@RequestParam String field, @RequestParam String q) {
		List<Track> tracks = null;

		if (field.equals("name")) {
			tracks = trackRepo.findByNameContainsIgnoreCase(q);
		} else if (field.equals("artist")) {
			tracks = trackRepo.findByArtistContainsIgnoreCase(q);
		} else if (field.equals("year")) {
			tracks = trackRepo.findByYearContainsIgnoreCase(q);
		}
		
		if (tracks != null) {
			return ResponseEntity.ok(tracks);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
