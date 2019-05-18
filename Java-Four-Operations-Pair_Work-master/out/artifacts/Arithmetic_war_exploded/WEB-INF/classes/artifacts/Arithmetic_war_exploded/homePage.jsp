<!DOCTYPE html>
<%@ page language="java" import="java.util.*,Function.*" pageEncoding="UTF-8"%>
<html>
<head>
  <meta charset="utf-8" />
  <title>四则运算出题系统</title>
  <link charset="UTF-8" type="text/css" rel="stylesheet" href="css/At.css"/>
  <script type="text/javascript" src="js/Timer.js" ></script>
</head>
<body class="txt">

<div class="Title">
  <center><h1>四则运算出题系统</h1></center>
</div>

<br/><br/><br/>

<div style="float: left;">
  <img src="img/cdf82212957e1e1db3674c1308464d62.jpg" height="400" width="500" align="left"/>
</div>

<b><br/>
  <form action="doYourAnswer.jsp" method="get">
    <table id="tb" style="padding: 20px">
      <tr>
        <td>
          <span style="color: #6495ED;font-size: 20px;">请输入以下信息：</span>
        </td>
        <td></td>
      </tr>
      <tr >
        <td>题目数量 ：</td>
        <td><input type="text" name="problemNum"/></td>
      </tr>
      <tr>
        <td>
          运算符个数限制：
        </td>
        <td>
          <input type="text" name="symbolNum"/>
        </td>
      </tr>
      <tr>
        <td>
          算式数值范围：
        </td>
        <td>
          0
          ~
          <input type="text" name="max">
        </td>
      </tr>
      <tr>

        <td>包含的特殊运算:</td>
        <td>
          乘除法<input name="multi" type="radio" value="true" id="multi1"/>是
          <input name="multi" type="radio" value="false" id="multi2" checked="checked"/>否
        </td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" class="button" value="提交要求"></td>
      </tr>
    </table>
  </form>
</b>
</body>
</html>
