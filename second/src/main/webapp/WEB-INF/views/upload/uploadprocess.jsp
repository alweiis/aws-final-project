<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadprocess.jsp</title>
</head>
<body>
<h1>파일 업로드 결과</h1>
<h3>작성자 : ${dto.name}</h3>
<h3>설명 : ${dto.description}</h3>
<h3>업로드 파일명1 : ${dto.file1.originalFilename}</h3>
<h3>업로드 파일명2 : ${dto.file2.originalFilename}</h3>
</body>
</html>