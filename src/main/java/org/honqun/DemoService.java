package org.honqun;

import com.github.catstiger.mvc.annotation.Api;

@Api
public class DemoService {
  @Api
  public User create(String name, String password) {
    return new User();
  }
}
