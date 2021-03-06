package org.honqun;

import java.util.Date;
import java.util.Random;

import com.github.catstiger.mvc.annotation.API;
import com.github.catstiger.mvc.annotation.Domain;
import com.github.catstiger.mvc.annotation.Param;
import com.github.catstiger.mvc.exception.Exceptions;

@Domain
public class DemoService {
  @API
  public User create(@Param("name") String name, @Param("password") String password) {
    User user = new User();
    
    user.setBirth(new Date());
    user.setUsername(name);
    user.setId(new Random().nextLong());
    user.setScore(new Random().nextDouble() * 100);
    return user;
  }
  
  @API
  public User update(@Param("id") Long id) {
    User user = new User();
    user.setId(id);
    return user;
  }
  
  @API
  public User viewUser (@Param("name") String name, @Param("id") Long id) {
    User user = new User();
    
    user.setBirth(new Date());
    user.setUsername(name);
    user.setId(id);
    user.setScore(new Random().nextDouble() * 100);
    return user;
  }
  
  @API(resolver = IBeetlResolver.class)
  public User ibeetlTest (@Param("name") String name, @Param("id") Long id) {
    User user = new User();
    
    user.setBirth(new Date());
    user.setUsername(name);
    user.setId(id);
    user.setScore(new Random().nextDouble() * 100);
    return user;
  }
  
  @API
  public User exTest(@Param("num") long num) {
    if(num < 0L) {
      throw Exceptions.readable("可读异常！");
    } else if (num < 100L){
      return new User();
    } else {
      throw new RuntimeException("不可读异常");
    }
  }
}
