package tn.pi.server.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.pi.server.models.User;
import tn.pi.server.services.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  IUserService userService;

  @PostMapping("/add-user")
  @ResponseBody
  public User addUser(@RequestBody User user) {
      userService.addUser(user);
      return user;
  }

}