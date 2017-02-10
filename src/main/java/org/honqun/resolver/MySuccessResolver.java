package org.honqun.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.catstiger.mvc.config.ApiResource;
import com.github.catstiger.mvc.resolver.JsonSuccessResolver;

public class MySuccessResolver extends JsonSuccessResolver {

  @Override
  public void resolve(HttpServletRequest arg0, HttpServletResponse arg1, ApiResource arg2, Object arg3) {
    super.resolve(arg0, arg1, arg2, arg3);
    logger.debug("使用缺省模板解析器！");
  }

}
