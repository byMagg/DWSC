package dwsc.commentdelete.repository;

import org.springframework.data.repository.CrudRepository;

import dwsc.commentdelete.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

	void deleteById(Long id);
}
