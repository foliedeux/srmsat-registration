package com.springboot.regis.repository;

import com.springboot.regis.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByRegno(String regno);
}
