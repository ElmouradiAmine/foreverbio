package com.itwins.foreverbio.repository;import com.itwins.foreverbio.models.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

    Comment findById(int id);
    List<Comment> findCommentByIdProd(int idProd);


}
