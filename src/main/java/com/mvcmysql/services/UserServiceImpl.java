package com.mvcmysql.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvcmysql.entity.User;
import com.mvcmysql.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public User findById(Integer id) {
        Optional<User> result = userRepository.findById(id);
		
		User user = null;
		
		if (result.isPresent()) {
			user = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + id);
		}
		
		return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}
    
}
