package com.chentao.aselab.user.repository;

import com.chentao.aselab.user.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findUserById(Long id);
    User findUserByUsername(String username);
    User findUserByEmail(String email);
    User findUserByUsernameAndPassword(String username,String password);
}
