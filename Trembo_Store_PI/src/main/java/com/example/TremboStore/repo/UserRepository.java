package com.example.TremboStore.repo;

import com.example.TremboStore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    ArrayList <User> findByName(String name);

}
