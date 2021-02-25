package com.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exam.model.PostModel;

public interface PostDao extends JpaRepository<PostModel, Long>{
	@Query("From PostModel where id=:id")
	public PostModel getById(@Param(value = "id") Long id);

}
