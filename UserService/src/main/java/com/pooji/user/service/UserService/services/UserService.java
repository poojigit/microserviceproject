package com.pooji.user.service.UserService.services;

import com.pooji.user.service.UserService.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    //user operations

    //create

    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //get single user of given userId

    User getUser(String userId);


    void deleteUser(String userId);
}
