package dwsc.commentdelete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dwsc.commentdelete.model.Comment;
import dwsc.commentdelete.repository.CommentRepository;

@RestController
public class CommentController {

	@Autowired
	CommentRepository commentRepo;
	
	@DeleteMapping("/comments")
	public ResponseEntity<Comment> deleteComment(@RequestBody Comment comment) {
		commentRepo.delete(comment);
		return ResponseEntity.ok(comment);
	}
}
