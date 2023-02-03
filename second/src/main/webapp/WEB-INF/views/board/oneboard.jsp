<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>oneboard.jsp</title>
</head>
<body>
<h2>- 게시글 조회 -</h2>
<form action="">
	<table border=3>
		<tr>
			<td>글번호</td><td><input value="${dto.seq}" readonly></td>
		</tr>
		<tr>
			<td>조회수</td><td><input value="${dto.viewcount}" readonly></td>
		</tr>
		<tr>
			<td>작성일</td><td><input value="${dto.writingtime}" readonly></td>
		</tr>
		<tr>
			<td>작성자</td><td><input value="${dto.writer}" readonly></td>
		</tr>
		<tr>
			<td>제목</td><td><input value="${dto.title}" ></td>
		</tr>
		<tr>
			<td>내용</td><td><textarea rows="5" cols="50" >${dto.contents}</textarea></td>
		</tr>
		<tr>
			<td><input type="submit" value="수정버튼" ></td>
			<td><input type="submit" value="삭제버튼" ></td>
		<tr>
	</table>

</form>

</body>
</html>