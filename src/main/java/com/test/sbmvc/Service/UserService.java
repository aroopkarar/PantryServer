package com.test.sbmvc.Service;

import com.test.sbmvc.CO.ChangePasswordCO;
import com.test.sbmvc.Model.Orders;
import com.test.sbmvc.Model.User;
import com.test.sbmvc.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public User getUser(String uid, String pwd){
        return userRepository.findByUsernameAndPassword(uid, pwd);
    }

    public List<User> getUsers(){
        List<User> users= new LinkedList<User>();
       userRepository.findAll().forEach(users::add);
       return users;
    }

    public List<Orders> getUserOrders(int userId)
    {
        List<Orders> orders= new LinkedList<>();
//        orders=userRepository.findById(userId).get()
//                .getOrders().stream().sorted(Comparator.comparing(Order::getDateAdded)).collect(Collectors.toList());
        return orders;
    }

    public User getUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(int userId) {
        Optional<User> user=userRepository.findById(userId);
        if(user.isPresent())
        {
            return user.get();
        }
        return null;
    }

    public Boolean changeUserPassword(ChangePasswordCO changePasswordCO) {
        User user=userRepository.findByUsername(changePasswordCO.getUsername());
        if(user!=null)
        {
            user.setPassword(changePasswordCO.getPassword());
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
