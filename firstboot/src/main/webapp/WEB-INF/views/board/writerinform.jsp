<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writer inform</title>
</head>
<body>
<h1>글 작성자 정보</h1>
<h3>글 번호 : ${writerdto.seq}</h3> 
<h3>글 제목 : ${writerdto.title}</h3> 
<h3>글 내용 : ${writerdto.contents}</h3> 
<h3>글 암호 : ${writerdto.pw}</h3> 
<h3>아이디 : ${writerdto.member.id}</h3> 
<h3>이름 : ${writerdto.member.name}</h3> 
<h3>암호 : ${writerdto.member.pw}</h3> 
<h3>폰번호 : ${writerdto.member.phone}</h3> 
<h3>이메일 : ${writerdto.member.email}</h3> 
<h3>가입일 : ${writerdto.member.regtime}</h3> 
</body>
</html>