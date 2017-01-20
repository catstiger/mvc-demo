package org.honqun.others;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;
import org.honqun.User;

import com.github.catstiger.mvc.annotation.API;
import com.github.catstiger.mvc.annotation.Domain;
import com.github.catstiger.mvc.annotation.Param;
import com.github.catstiger.mvc.config.ApiResource;
import com.github.catstiger.mvc.converter.ValueConverter;
import com.github.catstiger.mvc.resolver.ResponseResolver;
import com.github.catstiger.utils.WebUtils;

@Domain
public class OtherDemoService {
  ///other_demo_service/create?username=a&birth=2001-09-11
  @API
  public User create(User user) {
    return user;
  }
  ///other_demo_service/update?user.username=a&user.birth=2001-09-11
  ///other_demo_service/update?username=a&birth=2001-09-11
  @API
  public User update(@Param("user") User user) {
    return user;
  }
  ///other_demo_service/edit?user.username=a&user.score=0.345&birth=143994878730 
  @API("edit")
  public User view(@Param("user") User user, @Param(value = "birth", converter = LongDateConverter.class)Date birth) {
    if(user != null) {
      user.setBirth(birth);
    }
    
    return user;
  }
  ///other_demo_service/get?id=666
  @API(resolver = TextResolver.class)
  public User get(@Param("id") Long id) {
    User user = new User();
    user.setId(id);
    
    return user;
  }
  ///other_demo_service/no_param?long0=99&string1=abc
  @API
  public User noParam(Long id, String username) {
    User user = new User();
    user.setId(id);
    user.setUsername(username);
    return user;
  }
  
  public static class TextResolver implements ResponseResolver {

    @Override
    public void resolve(HttpServletRequest request, HttpServletResponse response, ApiResource apiResource, Object value) {
      if(value != null && value instanceof User) {
        User user = (User) value;
        WebUtils.render(response, user.getId().toString(), "text/plain");
      }
    }
    
  }
  
  public static class LongDateConverter implements ValueConverter<Date> {

    @Override
    public Date convert(Object value) {
      if(value != null && NumberUtils.isNumber(value.toString())) {
        return new Date(Long.valueOf(value.toString()));
      }
      return null;
    }
    
  }
}
