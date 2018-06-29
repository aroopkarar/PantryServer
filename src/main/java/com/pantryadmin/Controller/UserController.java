package com.pantryadmin.Controller;

import com.pantryadmin.CO.ChangePasswordCO;
import com.pantryadmin.Entity.Address;
import com.pantryadmin.Entity.User;
import com.pantryadmin.Service.UserService;
import com.pantryadmin.Service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UtilService utilService;

    //Working
    @CrossOrigin
    @RequestMapping(value = "/loginUser",method = RequestMethod.POST)
    public User loginUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response)
    {
            User u=null;
            if(user!=null)
            u= userService.getUser(user.getUsername(),user.getPassword());
            if(u==null) {
                try {
                    response.sendError(205);
                }
                catch(Exception e )
                {
                    e.printStackTrace();
                }

            } else {
                String token=utilService.createJWT(u);
                try {
                    response.setHeader("Authorization", "Bearer " + token);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                System.out.println("Authorization###: "+response.getHeader("Authorization"));
            }
            response.addHeader("access-control-expose-headers", "Authorization");
           return u;
    }

    @RequestMapping("/getUserByUserName") //Working fine
    public Boolean getUserByUserName(@RequestParam(value="userName") String userName )
    {
        User user =userService.getUserByUserName(userName);
        if(user!=null)
            return true;
        return false;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createUser")
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }

    @RequestMapping(value = "/getUsers") //Working fine
    public List<User> getUsers()
    {
        return userService.getUsers();
    }

    @RequestMapping(value = "/getUserById") //Working fine
    public User getUserById(@RequestParam(value="userId") int userId )
    {
        return userService.getUserById(userId);
    }

    @RequestMapping(value="/changeUserPassword") //Working fine
    public Boolean changeUserPassword(@RequestBody ChangePasswordCO changePasswordCO)
    {
        return userService.changeUserPassword(changePasswordCO);
    }

    @RequestMapping(value="/getUserAddress") //Working fine
    public List<Address> getUserAddress(@RequestParam int userId)
    {
        return userService.getUserAddresses(userId);
    }

}
