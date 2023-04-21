package dwsc.trackinsert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dwsc.trackinsert.model.Track;
import dwsc.trackinsert.repository.TrackRepository;

@RestController
public class TrackController {

	@Autowired
	TrackRepository trackRepo;

	@PostMapping("/tracks")
	public ResponseEntity<Track> insertTrack(@RequestBody Track track) {
		trackRepo.save(track);
		return new ResponseEntity<>(track, HttpStatus.OK);

	}
}
