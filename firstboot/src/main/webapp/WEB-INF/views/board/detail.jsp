<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/js/jquery-3.6.4.min.js"></script>
<script>
$(document).ready(function() {
	let dbpw = ${detaildto.pw};
	//let dbpw = $("input:hidden").val();
	$("#update-btn").on("click", function() {
		let inputpw = prompt("글 암호를 입력하세요.");
		if (inputpw == dbpw) {
			// action, method 방식 지정.
			$("form").attr("action", "boardupdate");
			$("form").attr("method", "post");
		} else {
			alert("암호가 다릅니다.");
		}
	}); // on
	
	$("#delete-btn").on("click", function() {
		let inputpw = prompt("글 암호를 입력하세요.");
		if (inputpw == dbpw) {
			location.href = "boarddelete?seq=${detaildto.seq}";
		} else {
			alert("암호가 다릅니다.");
		}
	}); // on
	
	
}); // ready
</script>
<title>board detail</title>
</head>
<body>
<form action="" method="">
	글 번호 : <input type="text" name="seq" value="${detaildto.seq}" readonly/><br/>
	글 제목 : <input type="text" name="title" value="${detaildto.title}"/><br/>
	글 내용 : <textarea rows="5" cols="50" name="contents">${detaildto.contents}</textarea><br/>
	작성자 : <input type="text" name="writer" value="${detaildto.writer}" readonly/><br/>
	조회수 : <input type="text" name="viewcount" value="${detaildto.viewcount}" readonly/><br/>
	작성시간 : <input type="text" name="writetime" value="${detaildto.writetime}" readonly/><br/>
	글 암호 : <input type="hidden" name="pw" value="${detaildto.pw}"/>
	<input id="update-btn" type="submit" value="수정" />
	<input id="delete-btn" type="button" value="삭제" />
</form>
</body>
</html>