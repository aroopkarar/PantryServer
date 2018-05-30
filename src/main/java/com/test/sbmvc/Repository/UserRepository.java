package com.test.sbmvc.Repository;

import com.test.sbmvc.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends  CrudRepository<User,Integer>{

    User findByUsernameAndPassword(String uid, String pwd);

    User findByUsername(String userName);
}
