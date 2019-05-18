<%--
  Created by IntelliJ IDEA.
  User: 卓音
  Date: 2017/8/11
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 配置文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/UEditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/UEditor/ueditor.all.js"></script>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h1>注册</h1><hr>
  <form action="addOK.jsp" name="addUser" method="post">
      <table>
          <tr>
              <td>用户名：<input type="text" name="nickname"/></td>
              <td>密码：<input type="password" name="password"/></td>
              <td>email：<input type="email" name="email"/></td>
              <td><input type="submit" value="注册" /></td>
          </tr>
      </table>
  </form>
  
</body>
</html>
