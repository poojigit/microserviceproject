package com.pooji.user.service.UserService.repositories;

import com.pooji.user.service.UserService.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    //if you want to implement any custom method or query
    //write
}
