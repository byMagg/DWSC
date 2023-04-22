package dwsc.tracksearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dwsc.tracksearch.model.Track;
import dwsc.tracksearch.repository.TrackRepository;

@RestController
public class TrackController {

	@Autowired
	TrackRepository trackRepo;

	@GetMapping("/tracks/{name}")
	public ResponseEntity<List<Track>> getTrackByName(@PathVariable String name) {
		List<Track> tracks = trackRepo.findByName(name);
		if (tracks != null) {
			return ResponseEntity.ok(tracks);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
