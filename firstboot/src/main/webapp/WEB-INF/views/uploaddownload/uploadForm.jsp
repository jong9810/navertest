<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>upload form</title>
</head>
<body>
<h1>파일 전송 폼</h1>
<form action="fileupload" method="post" enctype="multipart/form-data">
	업로더 : <input type="text" name="name"/><br/>
	파일 설명 : <input type="text" name="desc" /><br/>
	업로드 파일1 : <input type="file" name="file1" /><br/>
	업로드 파일2 : <input type="file" name="file2" /><br/>
	<input type="submit" value="파일업로드" />
</form>
</body>
</html>