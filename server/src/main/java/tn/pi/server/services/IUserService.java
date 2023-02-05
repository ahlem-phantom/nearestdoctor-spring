package tn.pi.server.services;
import java.util.List;

import tn.pi.server.models.User;

public interface IUserService {
    List<User> retrieveAllUsers();

	User addUser(User u);

	void deleteUser(Long id);

	User updateUser(User u);

	User retrieveUser(Long id);

}
