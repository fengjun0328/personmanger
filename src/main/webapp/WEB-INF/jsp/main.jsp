<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/11
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<div style="width: 80%">
    <table width="100%" >
        <tr>
            <td colspan="7">人员列表</td>
        </tr>
        <tr>
            <td colspan="7">
                姓名：<input type="text" name="name" id="name" value="${name}"><button onclick="seacher()">查询</button>
            </td>
        </tr>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>等级</td>
            <td>部门</td>
            <td>操作</td>
        </tr>
        <c:if test="${size==0}">
            <tr>
                <td colspan="7">没有符合条件数据</td>
            </tr>
        </c:if>
        <c:if test="${size>0}">
            <c:forEach items="${persons}" var="person" varStatus="status">
                 <tr <c:if test="${status.count%2==1}">style="background: red" </c:if> >
                    <td>${person.id}</td>
                    <td>${person.name}</td>
                    <td>
                        <c:if test="${person.gender==0}">女</c:if>
                        <c:if test="${person.gender==1}">男</c:if>
                    </td>
                    <td>${person.age}</td>
                    <td>${person.rank}级</td>
                    <td>${person.dName}</td>
                    <td><a href="#">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="7">
                    <c:if test="${currNo!=1}">
                        <a href="/person/main.html?currNo=1&name=${name}" >首页</a>&nbsp;&nbsp;&nbsp;
                        <a href="/person/main.html?currNo=${currNo-1}&name=${name}" >上一页</a>&nbsp;&nbsp;&nbsp;
                    </c:if>
                    <c:if test="${currNo!=total}">
                        <a href="/person/main.html?currNo=${currNo+1}&name=${name}" >下一页</a>&nbsp;&nbsp;&nbsp;
                        <a href="/person/main.html?currNo=${total}&name=${name}" >未页</a>
                    </c:if>
                    &nbsp;&nbsp;&nbsp;第${currNo}/${total}页
                </td>
            </tr>
        </c:if>
    </table>
    <div style="text-align: center"><input type="button" value="添加人员" onclick="add();"/></div>
</div>
</body>
<script src="/statics/js/jquery-1.12.4.js"></script>
<script>
    function seacher() {
        var name=$("#name").val();
        window.location.href="/person/main.html?name="+name;
    }
    function add() {
        window.location.href="/person/add.html";
    }
</script>
</html>
