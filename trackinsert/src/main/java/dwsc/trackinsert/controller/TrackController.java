package dwsc.trackinsert.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import dwsc.trackinsert.dao.TrackCheck;
import dwsc.trackinsert.model.Track;
import dwsc.trackinsert.repository.TrackRepository;

@RestController
public class TrackController {
	
	private static String trackCommentURL ="http://localhost:8082";

	@Autowired
	TrackRepository trackRepo;
	
	@Autowired
	TrackCheck trackCheckClient;

	@PostMapping("/tracks")
	public ResponseEntity<Track> insertTrack(@RequestBody Track track) {
		String name = track.getName();
		Track savedTrack = null;
		try {
			System.out.println(name);
			boolean exists = trackCheckClient.checkTrackExists(name);
			System.out.println(exists);
			if(!exists) return new ResponseEntity<>(track, HttpStatus.NOT_FOUND);
			savedTrack = trackRepo.save(track);

		} catch (DataIntegrityViolationException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: Faltan parámetros");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(savedTrack, HttpStatus.OK);
	}
	
	@GetMapping("/tracks/{id}/score")
	public ResponseEntity<Track> updateScore(@PathVariable Long id) {
		double mean = 0;
		Track track = null;
		try {
	        Optional<Track> optionalTrack = trackRepo.findById(id);
	        if (optionalTrack.isPresent()) {
	        	track = optionalTrack.get();
				mean = new RestTemplate().getForEntity(trackCommentURL + "/tracks/" + id + "/score", Double.class).getBody();
	            track.setScore(Double.toString(mean));
	            trackRepo.save(track);
	            System.out.println(mean);
	        }

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(track, HttpStatus.OK);
	}
}
