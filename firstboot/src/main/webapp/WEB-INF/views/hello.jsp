<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello boot</title>
<script src="/js/jquery-3.6.4.min.js"></script>
<script>
$(document).ready(function() {
	$("#ajax-btn").on("click", function() {
		$.ajax({
			url: "helloajax",
			//data: , // 전송 데이터 없음
			type: "get",
			dataType: "JSON",
			success: function(server) {
				$("#result").text(server.model);
			},
			error: function(error) {
				alert(error)
			},
		}); // ajax
	}); // on
	
	
})// ready
</script>
</head>
<body>
<h1>hello.jsp 파일입니다.</h1>
<h1>${model}</h1>

<img src="/images/html5.jpg" />
<img src="/upload/drinks.jpg" />

<input id="ajax-btn" type="button" value="ajax 요청버튼" />
<h1>ajax 결과출력</h1>
<h1 id="result"></h1>
</body>
</html>