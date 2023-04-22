package dwsc.trackcomment.repository;

import org.springframework.data.repository.CrudRepository;

import dwsc.trackcomment.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

	<S extends Comment> S save(S comment);

}