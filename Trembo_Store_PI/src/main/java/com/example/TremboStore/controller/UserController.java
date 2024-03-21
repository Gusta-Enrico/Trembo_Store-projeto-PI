package com.example.TremboStore.controller;

import com.example.TremboStore.model.User;
import com.example.TremboStore.repo.UserRepository;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/getAllUsers")
    public ResponseEntity<ArrayList<User>> getAllUsers(){
        try {
            ArrayList<User> userList = new ArrayList<>();
            userRepository.findAll().forEach(userList::add);

            if (userList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(userList, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/getUserByid")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        Optional<User> userObj = userRepository.findById(id);
        if (userObj.isPresent())
            return new ResponseEntity<>(userObj.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user/name/{name}")
    public ResponseEntity<ArrayList<User>> getUserByName(@PathVariable String name) {
        ArrayList<User> users = userRepository.findByName(name);
        if (!users.isEmpty())
            return new ResponseEntity<>(users, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        try {
            User userObj = userRepository.save(user);
            return new ResponseEntity<>(userObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user){
        try{
            Optional<User> userData = userRepository.findById(id);
            if(userData.isPresent()){
                User userUpdated = userData.get();
                userUpdated.setEmail(user.getEmail());
                userUpdated.setName(user.getName());
                userUpdated.setPassword(user.getPassword());

                User userobj = userRepository.save(userUpdated);
                return new ResponseEntity<>(userobj, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Integer id){
        try{
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
