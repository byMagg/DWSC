package dwsc.trackcomment.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dwsc.trackcomment.model.Comment;
import dwsc.trackcomment.repository.CommentRepository;

@RestController
public class CommentController {
	
	@Autowired
	CommentRepository commentRepo;
	
	@PostMapping("/comment")
	public ResponseEntity<Comment> insertComment(@RequestBody Comment comment) {
		comment.setDate(new Date());
		try {
			commentRepo.save(comment);
			return new ResponseEntity<>(comment, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping("/tracks/{trackid}/comments")
	public ResponseEntity<List<Comment>> getCommentsByTrack(@PathVariable int trackid) {
	    List<Comment> comments = commentRepo.findByTrackid(trackid);
	    if (comments.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(comments, HttpStatus.OK);
	}
	
	@GetMapping("/tracks/comments")
	public ResponseEntity<List<Comment>> getComments() {
	    List<Comment> comments = commentRepo.findAll();
	    if (comments.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(comments, HttpStatus.OK);
	}
	
	@GetMapping("/tracks/{trackid}/score")
	public ResponseEntity<Double> getCommentsScore(@PathVariable int trackid) {
	    List<Comment> comments = commentRepo.findByTrackid(trackid);
	    if (comments.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    double mean = 0;
	    for (Comment comment : comments) {
			mean += comment.getScore();
		}
	    mean = mean / comments.size();
	    return new ResponseEntity<>(mean, HttpStatus.OK);
	}
}
