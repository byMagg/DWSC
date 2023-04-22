package dwsc.tracksearch.controller;

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
	public ResponseEntity<Track> getTrackByName(@PathVariable String name) {
		Track track = trackRepo.findByName(name);
		if (track != null) {
			return ResponseEntity.ok(track);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
