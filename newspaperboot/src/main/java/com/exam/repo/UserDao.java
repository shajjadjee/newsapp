package com.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exam.model.UserModel;
@Repository
@Transactional
public interface UserDao extends JpaRepository<UserModel, Long> {
	@Query("From UserModel where username=:username")
	public UserModel getByUsername(@Param(value = "username") String username);

}
