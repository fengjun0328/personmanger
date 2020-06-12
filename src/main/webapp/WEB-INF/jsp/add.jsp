<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/11
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="/statics/js/jquery-1.12.4.js"></script>
</head>
<body>
<h3>添加人员</h3>
<form method="post" action="/person/add.html" id="myform">
   <div> 姓名：<input type="text" name="name" id="name" ><span id="nameError"></span></div>
    <div> 性别：<select id="gender" name="gender">
        <option value="-1">请选择</option>
        <option value="0">女</option>
        <option value="1">男</option>
    </select></div>
    <div> 年龄：<input type="number" name="age" id="age" min="0" max="120"></div>
    <div> 等级：<select id="rank" name="rank">
        <option value="-1">请选择</option>
        <option value="1">1级</option>
        <option value="2">2级</option>
        <option value="3">3级</option>
        <option value="4">4级</option>
        <option value="5">5级</option>
    </select></div>
    <div> 部门：<select id="did" name="did">
        <option value="-1">请选择</option>
        <c:forEach items="${depts}" var="dept">
            <option value="${dept.id}">${dept.deptName}</option>
        </c:forEach>
    </select></div>
    <div> 出生日期：<input name="bithday" id="bithday"/></div>
    <div><input type="submit" value="提交"></div>
</form>
<script>
    $(function () {
        $("#myform").submit(function () {
            var isTrue=true;
            if(!checkName())isTrue=false;
            return isTrue;
        });

        $("#name").onblur(checkName);
    })

    function checkName() {
        var name=$("#name").val();
        $("#nameError").html("");
        if(name==null||name==''){
            alert("用户名不能为空");
            $("#nameError").html("用户名不能为空");
            return false;
        }
        return true;
    }

</script>
</body>
</html>
