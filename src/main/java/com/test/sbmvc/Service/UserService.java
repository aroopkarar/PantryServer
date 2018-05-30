package com.test.sbmvc.Service;

import com.test.sbmvc.Model.Orders;
import com.test.sbmvc.Model.User;
import com.test.sbmvc.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public User getUser(String uid, String pwd){
        return userRepository.findByUsernameAndPassword(uid, pwd);
    }

    public List<User> getUsers(){
        List<User> users= Collections.emptyList();
       userRepository.findAll().forEach(users::add);
       return users;
    }

    public List<Orders> getUserOrders(int userId)
    {
        List<Orders> orders= new LinkedList<>();
        orders=userRepository.findById(userId).get()
                .getOrders().stream().sorted(Comparator.comparing(Orders::getDateAdded)).collect(Collectors.toList());
        return orders;
    }

    public User getUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
