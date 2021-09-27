package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	User findByLoginAndProvider(String login, String provider);

	boolean existsByLoginAndProvider(String login, String provider);
}