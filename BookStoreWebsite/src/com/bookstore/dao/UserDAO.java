package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO(EntityManager entityManager) {
		super(entityManager);
	}

	public Users create(Users user) {
		return super.create(user)
	}
	
	@Override
	public Users update(Users t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users get(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users delete(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
