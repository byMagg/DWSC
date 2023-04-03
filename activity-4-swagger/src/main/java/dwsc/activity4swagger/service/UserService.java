package dwsc.activity4swagger.service;

import dwsc.activity4swagger.model.User;
import dwsc.activity4swagger.model.Users;

public interface UserService {

    public Users getUsersFromDB();

    public User getUserFromDb(String username);

    public int postUserToDb(User user);

}
