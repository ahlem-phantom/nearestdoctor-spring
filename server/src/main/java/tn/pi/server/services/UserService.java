package tn.pi.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pi.server.models.User;
import tn.pi.server.repositories.UserRepository;

@Service
public class UserService implements IUserService {

    @Autowired
	UserRepository userRepository;

    @Override
    public List<User> retrieveAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User addUser(User u) {
        userRepository.save(u);
		return u;
    }

    @Override
    public void deleteUser(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public User updateUser(User u) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User retrieveUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

}
