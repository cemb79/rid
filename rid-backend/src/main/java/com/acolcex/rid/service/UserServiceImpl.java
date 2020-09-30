package com.acolcex.rid.service;

import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.acolcex.rid.model.User;
import com.acolcex.rid.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public Set<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(String id) throws ServiceException {
		Optional<User> result = userRepository.findById(id);
		try {
			User user = result.get();
			user.setPassword(null);
			logger.info("User found");
			return user;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public void delete(User object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}

}
