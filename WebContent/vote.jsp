<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>好きな曲アンケート</title>
<link rel="stylesheet" type="text/css" href="vote_stylesheet.css">
</head>
<body>
<h1>好きな曲を選んでください</h1>
  <form action="<%=request.getContextPath()%>/VoteServlet" method="post"  class="left">
    <table border="1">
	  <c:forEach var="songName" items="${songNames}" varStatus="status">
	    <tr>
		  <td height="40"><c:out value="${status.count}" /></td>
		  <td width="300" height="40"><c:out value="${songName}" /></td>
		  <td height="40"><input type="radio" name="songNumber" value="${status.count-1}"></td>
		</tr>
	  </c:forEach>
    </table><br>
  <input type="submit" value="投票！" style="width:150px; height:50px;"><br><br>
  </form>


  <table class="left">
    <c:forEach var="songName" items="${songNames}">
	  <tr>
		<td height="42"><c:out value="${votesList[songName]}票" /></td>
	  </tr>
    </c:forEach>
  </table>

  <table>
	<c:forEach var="songName" items="${songNames}">
	  <tr>
		<td height="42"><hr width="${votesList[songName]*10}" size="10" color="red" align="left" /></td>
	  </tr>
	</c:forEach>
  </table>
  <br>
  <form action="<%=request.getContextPath()%>/VoteSort" method="post">
    <input type="submit" value="ソートする">
  </form><br><br>
  <form action="<%=request.getContextPath()%>/AddSongServlet" method="post" class="left">
    <input type="text" name="songName">
    <input type="submit" value="曲を追加">
  </form>
</body>
</html>