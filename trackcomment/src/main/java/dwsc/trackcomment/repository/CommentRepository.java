package dwsc.trackcomment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dwsc.trackcomment.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

	<S extends Comment> S save(S comment);

	List<Comment> findAll();

	List<Comment> findByTrackId(int trackId);

}
