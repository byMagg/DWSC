package dwsc.activity4.service;

import dwsc.activity4.model.User;
import dwsc.activity4.model.Users;
public interface UserService {

 public Users getUsersFromDB();
 public User getUserFromDb(String username);
 public int postUserToDb(User user);
 
}

