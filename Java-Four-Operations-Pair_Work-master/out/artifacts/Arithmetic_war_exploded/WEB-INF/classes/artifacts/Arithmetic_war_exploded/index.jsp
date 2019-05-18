<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*,Function.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>登录/注册</title>
    <link rel="stylesheet" type="text/css" href="css/At.css"/>


  </head>
  
  <body>

   <div class="Title">
       <center><h1>四则运算出题系统</h1></center>
   </div>
   <center>
       <form action="/Z_NewDemo/WebRoot/login.jsp" method="post">
           <table>
               <tr>
                   <td>账号</td>
                   <td><input type="text" name="username"/></td>
               </tr>
               <tr>
                   <td>密码</td>
                   <td><input type="password" name="password"/></td>
               </tr>
               <tr>
                   <td><input type="button"  value="登录" /></td>
                   <td><a href="add.jsp" style="text-decoration: none"><input type="button" value="新用户注册" id="reg"/></a></td>
               </tr>
           </table>
       </form>
   </center>
   <hr>
  </body>
</html>
