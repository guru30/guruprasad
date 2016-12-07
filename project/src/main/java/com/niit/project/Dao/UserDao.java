package com.niit.project.Dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.project.model.User;

@Repository
public interface UserDao {
	
	public List<User> list();
	public User get(String email);
	public void saveorupdate(User user);
	public void delete(User user);
	public User isvalidUser(String email, String password);
	public boolean isAllReadyRegister(String email, boolean b);

}