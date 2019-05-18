<%@ page language="java" import="Function.Function" pageEncoding="UTF-8"%>
<%@ page import="Entity.Lists" %>

<html>
<head>

    <title>错题检查</title>
    <link charset="UTF-8" type="text/css" rel="stylesheet" href="css/At.css"/>
</head>

<body class="txt">
<div class="Title">
    <h1>错题集</h1>
</div>
<%--获取到生成的链表--%>

    <div style="float: left;">
        <img src="img/cdf82212957e1e1db3674c1308464d62.jpg" height="400" width="500" align="left"/>
    </div>
    <div>
        <%
            int[] QuesNum = new int[1000];
            String[] wrongAns = new String[1000];
            int wrongNum = 0;
            int problemNum = Integer.parseInt(request.getParameter("QNum"));

            out.print("一共"+ problemNum +"题,错题如下：");

            for (int i=0;i<problemNum;i++) {
        %>
    </div>
    <div>
    <table>
                <%
                        String[] myAnswer = request.getParameterValues("myAnswer");
                        String answer = Lists.resArr.get(i);
                        if (myAnswer[i].equals(answer)){
                            continue;
                        }else{
                            QuesNum[wrongNum] = i ;
                            wrongAns[wrongNum] = myAnswer[i] ;
                            wrongNum++;
                        }
                    }
                %>
    </table>

        <table>
                <%
                Lists list = new Lists();
                int qNum;
                for (int i=0;i<wrongNum;i++) {
                 qNum = QuesNum[i]+1;
                 %>
            <tr>
                <td>
                    <%
                        out.println("第" +qNum+ "题:");
                    %>
                </td>
                <td>
                    <%
                        out.println(list.getExpArr().get(QuesNum[i]));

                    %>
                </td>
                <td>
                    =<input type="text" value="<%=Lists.resArr.get(QuesNum[i])%>">
                </td>
                <td>
                    <%out.println("你的答案 ： " + wrongAns[i]);%>
                </td>
            </tr>
            <%
        }
    %>
    </div>
    <div>
        <table>
            <tr>
                <%out.println("错"+ wrongNum +"题;");out.println("对"+ (problemNum - wrongNum) +"题.");%>
            </tr>
            <tr>
                <a href="homePage.jsp" style="text-decoration: none"><input class="button"  type="button" value="返回首页"></a></td>
             </tr>
        </table>

    </div>

</body>
</html>
