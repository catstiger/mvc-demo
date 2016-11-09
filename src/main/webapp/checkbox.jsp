<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form method="post" id="frm">
       <input type="checkbox" name="a" value="1">
       <input type="checkbox" name="a" value="1">
       <input type="checkbox" name="a" value="1">
       <input type="checkbox" name="a" value="1">
       
       <input type=text name="b" value="T">
       
       <button type="submit">submit</button>
   </form>
   <button type="button" id="ajaxSubmit">AJAX</button>
   <%
   try {
     String a = request.getParameter("a");
     String[] as = request.getParameterValues("a");
     out.println(request.getParameterValues("b")[0]);
     out.println(as.length);
     
     out.println(request.getParameterMap());
   } catch (Exception e) {
     
   }
   %>
   <script type="text/javascript" src="js/jquery.js"></script>
   <script type="text/javascript" src="js/jquery.form.js"></script>
   <script>
   $(function() {
     
     $('#ajaxSubmit').click(function() {
       $('#frm').ajaxSubmit({
         success:function() {
           console.log(arguments);
         }
       });
     });
   });
   </script>
</body>
</html>