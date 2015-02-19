package com.sivalabs.sgdemo.web.controllers

import com.sivalabs.sgdemo.entities.User
import com.sivalabs.sgdemo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by skatam on 18-12-2014.
 */
@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    UserRepository userRepository

    @RequestMapping("/")
    List<User> findAll(){
        userRepository.findAll()
    }

    @RequestMapping("/{id}")
    User findById(@PathVariable int id){
        userRepository.findOne(id)
    }

}
