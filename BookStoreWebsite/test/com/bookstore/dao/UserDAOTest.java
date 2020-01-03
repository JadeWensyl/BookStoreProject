package com.bookstore.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void setupClass() {
		 entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		 entityManager  = entityManagerFactory.createEntityManager();
	     userDAO = new UserDAO(entityManager);
	}
	
	
	
	//TEST FOR CREATING NEW USER 
	@Test
	public void testCreateUsers() {
		Users user = new Users("caingcoy@gmail.com", "bebe ko", "abcdefghijk");		 
		user = userDAO.create(user); 		
		assertTrue(user.getUserId() > 0);
	}
	
	@Test(expected = PersistenceException.class)
	public  void testCreateUsersFieldsNotSet() {
		Users user1 = new Users();
		user1 = userDAO.create(user1);
		
	}

	
	@Test
	public void testUpdateUsers() {
		Users user = new Users(1, "bagonggawa@gmail.com", "bobo", "mysecret");
		user = userDAO.update(user);
		String expected = "mysecret";
		String actual   = user.getPassword();
		assertEquals(expected, actual); 
	}
	
	@Test
	public void testGetUsersFound() {
		Integer userId = 1;
		Users  user = userDAO.get(userId);
		if(user != null) {
			System.out.print(user.getEmail());
		}
		assertNotNull(user);
	}
	
	@Test
	public void testGetUsersNotFound(){
		Integer userId = 99;
		Users user = userDAO.get(userId);
		assertNull(user);
	}
	
	@Test
	public void testDeleteUsers(){
		Integer userId = 5;
		userDAO.delete(userId);
		Users user = userDAO.get(userId);
		assertNull(user);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNoneExistUsers(){
		Integer userId = 55;
		userDAO.delete(userId);
	}
	
	@AfterClass
	public static void tearDownClass() {
		entityManager.close();
		entityManagerFactory.close();
	}
	
}
