package org.honqun.others;

import org.honqun.User;
import org.springframework.stereotype.Component;

import com.github.catstiger.mvc.annotation.API;
import com.github.catstiger.mvc.annotation.Domain;
import com.github.catstiger.mvc.annotation.Param;

@Component
@Domain
public class SpringDemoService {
  
  @API
  public User createUser(@Param("username") String username, @Param("id")Long id) {
    User user = new User();
    user.setUsername(username);
    user.setId(id);
    return user;
  }
}
