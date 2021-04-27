package com.spring.repository;




import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.domain.Comments;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Integer>{

}

