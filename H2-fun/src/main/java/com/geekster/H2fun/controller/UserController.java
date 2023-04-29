package com.geekster.H2fun.controller;

import com.geekster.H2fun.model.Users;
import com.geekster.H2fun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    //Get

    @GetMapping(value = "/users")
    public Iterable<Users> getUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping(value = "users/{name}")
    public List<Users> getUsersByName(@PathVariable String name)
    {
        return userService.fetchUsersByName(name);
    }
    //get age greater than
    @GetMapping(value = "users/age/{age}")
    public List<Users> getUsersByAgeFactor(@PathVariable String age)
    {
        return userService.fetchUsersByAgeFactor(age);
    }
    // name something or get age greater than something
    @GetMapping(value = "users/{name}/greaterThan/{age}")
    public List<Users> getUsersByNameOrAgeFactor(@PathVariable String name,@PathVariable String age)
    {
        return userService.getUsersByNameOrAgeFactor(name,age);
    }

    // name something and get age greater than something
    @GetMapping(value = "users/ageGreater/combined")
    public List<Users> getUsersByNameAndAgeFactor(@RequestParam String name,@RequestParam String age)
    {
        return userService.getUsersByNameAndAgeFactor(name,age);
    }

    // custom query :
    @GetMapping(value = "/userSorted")
    public List<Users> getOrderedUsers()
    {
        return userService.getAllUsersSorted();
    }

    @GetMapping(value = "/userWhere/{age}")
    public List<Users> getUsersWhereAge(@PathVariable String age)
    {
        return userService.getAllUsersWhere(age);
    }

   // post
    @PostMapping(value ="/users")
    public String insertUsers(@RequestBody List<Users> userList)
    {
       return userService.addUsers(userList);
    }

    //delete
    @DeleteMapping(value = "/user/{id}")
    public void deleteUserById(@PathVariable Integer id)
    {
         userService.removeUserById(id);
    }

}
