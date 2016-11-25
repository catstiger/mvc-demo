package org.honqun;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.resource.FileResourceLoader;

import com.github.catstiger.mvc.config.ApiResource;
import com.github.catstiger.mvc.config.Initializer;
import com.github.catstiger.mvc.resolver.AbstractResponseResolver;

public class IBeetlResolver extends AbstractResponseResolver {
  static Configuration cfg;
  static FileResourceLoader resourceLoader;
  static GroupTemplate gt;
  static {
    try {
      cfg = Configuration.defaultConfiguration();
      resourceLoader = new FileResourceLoader(Initializer.getInstance().getRealPath() + "/WEB-INF/views/", "utf-8");
      gt = new GroupTemplate(resourceLoader, cfg);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
 
  
  @Override
  public void resolve(HttpServletRequest request, HttpServletResponse response, ApiResource apiRes, Object value) {
    Template template = gt.getTemplate("/test_ibeetl.html");
    try {
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");
      template.binding("user", value);
      template.renderTo(response.getWriter());
    } catch (BeetlException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
