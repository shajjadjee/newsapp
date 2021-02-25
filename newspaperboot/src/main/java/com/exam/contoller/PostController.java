package com.exam.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.PostModel;
import com.exam.model.UserModel;
import com.exam.repo.PostDao;

@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	PostDao postDao;
	@PostMapping("/add")
	public PostModel addpost(@RequestBody PostModel post) {
		System.out.println(post.toString());
		PostModel pm = postDao.saveAndFlush(post);
		return pm;
	}
	@GetMapping("/list")
	public List<PostModel> getAll(){
		List<PostModel> pm = postDao.findAll();
		return pm;
	}
	@GetMapping("/one/{id}")
	public PostModel getById(@PathVariable("id") long id) {
		PostModel pm = postDao.findById(id).get();
		return pm;
	}
	@GetMapping("/delete/{id}")
	public PostModel deleteById(@PathVariable("id") long id) {
		postDao.deleteById(id);
		return new PostModel();
	}

}
