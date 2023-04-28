package dwsc.commentdelete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dwsc.commentdelete.model.Comment;
import dwsc.commentdelete.repository.CommentRepository;

@RestController
public class CommentController {

	@Autowired
	CommentRepository commentRepo;
	
	@DeleteMapping("/tracks/comments/{id}")
	public ResponseEntity<String> deleteCommentById(@PathVariable Long id) {
	    commentRepo.deleteById(id);
	    return new ResponseEntity<>("Eliminado Correctamente", HttpStatus.OK);
	}
}
