<%@ page language="java" import="Function.Function" pageEncoding="UTF-8"%>
<%@ page import="Entity.Lists" %>

<html>
  <head>
    
    <title>做题页面</title>
      <link charset="UTF-8" type="text/css" rel="stylesheet" href="css/At.css"/>
  </head>
  
  <body class="txt">
  <div class="Title">
      <h1>下面就来做题目吧</h1>
  </div>

    <%--获取到生成的链表--%>
    <div style="float: left;">
        <img src="img/cdf82212957e1e1db3674c1308464d62.jpg" height="400" width="500" align="left"/>
    </div>

    <%
        Function func = new Function();
    /* 1.把获得的题目数提交给后台 */
        String problemNum = request.getParameter("problemNum");

        int pN = Integer.parseInt(problemNum);
        /* 2.包含多少个运算符 */
        String symbolNum = request.getParameter("symbolNum");

        int Sn = Integer.parseInt(symbolNum);

        /* 3.算式数值范围*/
        String max = request.getParameter("max");
        func.setMax(Integer.parseInt(max));

        /* 4.是否包含乘除法*/
        String multi = request.getParameter("multi");
        if(multi=="true"){
            func.isMulDiv(true);}
        else{
            func.isMulDiv(false);}

%>
    <form action="checkAnswer.jsp?QNum=<%=problemNum%>" method="post">
        <table>

    <%
        Lists list = new Lists();
        func.createList(pN,Sn);
        int qNum;
        for (int i=0;i<Integer.parseInt(problemNum);i++) {
        qNum = i+ 1;
    %>
            <tr>
                <td>第<%=qNum%>题:</td>
                <td><%=list.getExpArr().get(i)%></td>
                <td >=&nbsp;&nbsp;<input type="text" name="myAnswer" width="30px" /></td>
            </tr>
            <%}%>
            <tr>
                <td><input type="submit" value = "提交" class="button" ></td>
            </tr>
            </table>
        </form>
  </body>
</html>
