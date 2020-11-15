package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
        if (username.length() < 3 || password.length() < 3) {
            return true;
        }
        
        if (onlyLetters(password)) {
            return true;
        }
        
        return false;
    }
    
    private boolean onlyLetters(String string) {
        Pattern patt = Pattern.compile("[^A-Za-z]");
        Matcher match = patt.matcher(string);
        
        // math.find() looks for a character not included in the pattern, if it finds one then false is returned
        return !match.find();
    }
}
