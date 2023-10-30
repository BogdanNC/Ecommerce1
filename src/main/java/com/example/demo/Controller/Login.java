package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MongoModel.User;
import com.example.demo.Repository.UserRepo;

@RestController
public class Login {

    @Autowired
    UserRepo userItemRepo;

    @RequestMapping("/login")
    public Optional<String> hello(@RequestParam("itemid") Optional<String> itemId) {


        System.out.println(showAllUsers());
        return itemId;

    }
    public String showAllUsers() {
        //userItemRepo.save(new User("Bogdan", "lama2@lame.ro"));
        User user = userItemRepo.findUserByEmail("lama2@lame.ro");
        System.out.println(user.getUserId());



        return user.getName();
        //userItemRepo.findAll().forEach(item -> System.out.println(getItemDetails(item)));
    }
}
