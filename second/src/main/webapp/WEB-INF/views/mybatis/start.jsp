<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>start.jsp</title>
</head>
<body>
<h1>나의 회원관리 프로그램입니다. (배포 테스트를 위해 수정)</h1>
<h3>
	<ul>
		<li><a href="<%= request.getContextPath()%>/login">로그인</a></li>
		<li><a href="<%= request.getContextPath()%>/logout">로그아웃</a></li>
		<li><a href="<%= request.getContextPath()%>/mybatismemberlist">회원 전체 조회(로그인 필요없음)</a></li>
		<li><a href="<%= request.getContextPath()%>/memberinsert">회원가입(로그인 필요없음)</a></li>
		<li><a href="<%= request.getContextPath()%>/memberinform">내 정보 조회</a></li>
		<li><a href="<%= request.getContextPath()%>/memberdelete">회원탈퇴</a></li>
		<li><a href="<%= request.getContextPath()%>/boardlist">게시판가기</a></li>
	</ul>
</h3>

<% 
if(session.getAttribute("loginid") != null) {
	out.println("<h1>" + session.getAttribute("loginid") + "회원님 환영합니다. </h1>");
} else {
	out.println("<h1> 로그인을 해주세요. </h1>");
}
%>

 ${!empty updateresult? updateresult: "" } 

</body>
</html>
