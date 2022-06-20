package com.ty.hospitalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.UserDao;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.dto.User;
import com.ty.hospitalapi.exception.NoIdFoundException;
import com.ty.hospitalapi.exception.NoUsersFoundException;
import com.ty.hospitalapi.exception.NotValidException;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public ResponseStructure<User> saveUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(userDao.saveUser(user));
		return responseStructure;

	}

	public ResponseStructure<User> getUserById(int id) {
		User user = userDao.getUserById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if (user != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(user);
		} else {
			throw new NoIdFoundException("User id " + id + " does not Exists");
		}
		return responseStructure;

	}

	public ResponseStructure<List<User>> getAllUser() {
		ResponseStructure<List<User>> responseStructure = new ResponseStructure<List<User>>();
		List<User> users = userDao.getAllUser();
		if (users.size() > 0) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(users);
		} else {
			throw new NoUsersFoundException("No Users Exists");
		}

		return responseStructure;

	}

	public ResponseStructure<User> updateUser(User user, int id) {
		User user1 = userDao.updateUser(user, id);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();

		if (user1 != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(user1);
		} else {
			throw new NoIdFoundException("User id " + id + " does not Exists");
		}
		return responseStructure;

	}

	public ResponseStructure<User> validateUser(String email, String password) {
		User user = userDao.validateUser(email, password);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();

		if (user != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(user);
		} else {
			throw new NotValidException("User Not Valid");
		}
		return responseStructure;

	}

	public ResponseStructure<String> deleteUser(int id) {
		boolean res = userDao.deleteUser(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (res) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData("Deleted");
		} else {
			throw new NoIdFoundException("User id " + id + " does not Exists");
		}
		return responseStructure;

	}

}
