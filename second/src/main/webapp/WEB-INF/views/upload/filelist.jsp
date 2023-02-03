<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>filelist.jsp</title>
</head>
<body>
<h1>다운로드 목록을 보여드립니다.</h1>
<%
	String[] fileList = (String[]) request.getAttribute("filelist");
	for(String fileName: fileList) {
		out.println("<h3><a href='filedownload?onefile="+ fileName + "'>" + fileName + "</a></h3>");
	}
%>
</body>
</html>