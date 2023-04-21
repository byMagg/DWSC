package dwsc.trackinsert.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dwsc.trackinsert.model.Track;

@RestController
public class TrackController {

	@PostMapping("/tracks")
	public ResponseEntity<String> insertTrack(@RequestBody Track track) {
		return new ResponseEntity<>("OMDB: ", HttpStatus.OK);
	}
}
