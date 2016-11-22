package org.honqun.controllers;

import org.honqun.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/spring_demo")
public class SpringDemoController {
  
  @RequestMapping("/create_user")
  @ResponseBody
  public User createUser(@ModelAttribute("username") String username, @ModelAttribute("id")Long id) {
    User user = new User();
    user.setUsername(username);
    user.setId(id);
    return user;
  }
}
