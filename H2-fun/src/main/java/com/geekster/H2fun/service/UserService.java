package com.geekster.H2fun.service;

import com.geekster.H2fun.model.Users;
import com.geekster.H2fun.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;
    public Iterable<Users> getAllUsers() {
        Iterable<Users> allUsers = userRepository.findAll();
        return allUsers;
    }
    
    public List<Users> getAllUsersSorted(){
        return userRepository.findUsersOrderedByAge();
    }

    public List<Users> getAllUsersWhere(String age){

        Integer userAge = Integer.parseInt(age);
        return userRepository.findUsersOrderedByAgeWithWhere(userAge);
    }

    public String addUsers(List<Users> userList) {
        Iterable<Users> addUsers =  userRepository.saveAll(userList);
        if(addUsers != null)
            return "Yes";
        else
            return "No";
    }

    public void removeUserById(Integer id) {

        userRepository.deleteById(id);

    }

    public List<Users> fetchUsersByName(String name) {
        return userRepository.findByName(name);
    }

    public List<Users> fetchUsersByAgeFactor(String age) {

        Integer userAge = Integer.parseInt(age);
        return userRepository.findByAgeGreaterThan(userAge);
    }

    public List<Users> getUsersByNameOrAgeFactor(String name,String age) {

        Integer userAge = Integer.parseInt(age);
        return userRepository.findByNameOrAgeGreaterThan(name,userAge);
    }

    public List<Users> getUsersByNameAndAgeFactor(String name, String age) {
        Integer userAge = Integer.parseInt(age);
        return userRepository.findByNameAndAgeGreaterThan(name,userAge);
    }

}
