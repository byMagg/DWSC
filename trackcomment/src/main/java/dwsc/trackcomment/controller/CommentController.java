package dwsc.trackcomment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dwsc.trackcomment.model.Comment;
import dwsc.trackcomment.repository.CommentRepository;

@RestController
public class CommentController {

	@Autowired
	CommentRepository commentRepo;
	
	@PostMapping("/comment")
	public ResponseEntity<Comment> insertComment(@RequestBody Comment comment) {
		commentRepo.save(comment);
		return new ResponseEntity<>(comment, HttpStatus.OK);
	}
	
	@GetMapping("/tracks/{trackId}/comments")
	public ResponseEntity<List<Comment>> getCommentsByTrack(@PathVariable Long trackId) {
	    List<Comment> comments = commentRepo.findByTrackId(trackId);
	    return new ResponseEntity<>(comments, HttpStatus.OK);
	}
}
