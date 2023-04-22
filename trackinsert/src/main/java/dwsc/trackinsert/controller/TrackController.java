package dwsc.trackinsert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dwsc.trackinsert.dao.TrackCheck;
import dwsc.trackinsert.model.Track;
import dwsc.trackinsert.repository.TrackRepository;

@RestController
public class TrackController {

	@Autowired
	TrackRepository trackRepo;
	
	@Autowired
	TrackCheck trackCheckClient;

	@PostMapping("/tracks")
	public ResponseEntity<Track> insertTrack(@RequestBody Track track) {
		String name = track.getName();
		try {
			boolean exists = trackCheckClient.checkTrackExists(name);
			System.out.println(exists);
			if(!exists) return new ResponseEntity<>(track, HttpStatus.NOT_FOUND);
			trackRepo.save(track);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(track, HttpStatus.OK);
	}
}
