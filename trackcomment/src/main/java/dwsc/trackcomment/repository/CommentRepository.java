package dwsc.trackinsert.repository;

import org.springframework.data.repository.CrudRepository;

import dwsc.trackinsert.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

	<S extends Comment> S save(S comment);

}
