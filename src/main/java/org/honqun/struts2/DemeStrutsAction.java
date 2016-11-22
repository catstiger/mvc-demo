package org.honqun.struts2;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.honqun.User;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/struts/demo_struts")
public class DemeStrutsAction extends ActionSupport implements ModelDriven<User>{
  private User model = new User();
  
  @Action("create")
  public void create() {
   render(getResponse(), JSON.toJSONString(model), "application/json");
  }
  
  @Action("view")
  public String view() {
     return "/struts/demo_struts/view.jsp";
  }

  @Override
  public User getModel() {
    return model;
  }
  
  public static void render(HttpServletResponse response, String text,
      String contentType) {
    try {
      response.setContentType(contentType);
      response.setCharacterEncoding("UTF-8");
      response.getWriter().write(text);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * 获得当前Http Servlet Request.
   * 如果在单元测试环境下，则每次调用都返回一个新的MockHttpServletRequest的实例
   */
  protected final HttpServletRequest getRequest() {
    HttpServletRequest request = null;
    if (getActionContext() != null) { // 从Struts2中取得Request
      request = (HttpServletRequest) getActionContext().get(
          StrutsStatics.HTTP_REQUEST);
    }

    return request;
  }

  /**
   * 获得当前HttpServletResponse.
   * 如果在单元测试环境下，则每次调用都返回一个新的MockHttpServletResponse的实例
   */
  protected final HttpServletResponse getResponse() {
    HttpServletResponse response = null;
    if (getActionContext() != null) { // 从Struts2中取得Response
      response = (HttpServletResponse) getActionContext().get(
          StrutsStatics.HTTP_RESPONSE);
    }

    return response;
  }
  
  /**
   * 获得struts2的ActionContext
   */
  protected final ActionContext getActionContext() {
    return ActionContext.getContext();
  }
}
