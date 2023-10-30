package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.MongoModel.User;

import java.util.List;

public interface UserRepo extends MongoRepository<User, String> {
    @Query("{email:'?0'}")
    User findUserByEmail(String email);

    @Query(value = "{username:'?0'}")
    List<User> findAll(String username);


}
