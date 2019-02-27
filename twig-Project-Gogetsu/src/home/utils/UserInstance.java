package home.utils;

import home.utils.entity.user;
import home.utils.service.userService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserInstance {

    /**
     * @param args the command line arguments
     */
    private static user user1;
    private static UserInstance couser;

    public UserInstance(String mail,String password)
    {
        userService userService = new userService();
        user1 = userService.getsingle(mail,password);
       // System.out.println(user1.getId());

    }
    public static UserInstance getInstance(String mail,String password){
        if (couser==null)
            couser= new UserInstance(mail,password);
        return couser;
    }

    public static user getUser1() {
        return user1;
    }

}
