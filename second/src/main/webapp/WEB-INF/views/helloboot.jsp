<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>helloboot.jsp</title>
<script src="js/jquery-3.6.1.min.js"></script>
<script>
$(document).ready(function(){
	$('#ajaxbtn').on('click', function(){
		$.ajax({
			url: 'hellobootajax',
			type: 'get',
			dataType: 'json',
			success: function(data) {
				$('#result').html(data.result);
			}
		});
	});
});
</script>
</head>
<body>
	<h1>${dto.model}</h1>
	<input type="button" id="ajaxbtn" value="ajax요청 버튼">
	<div id="result"></div>
</body>
</html>