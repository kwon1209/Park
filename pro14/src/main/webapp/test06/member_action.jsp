<%@ page language="java" contentType="text/html; charset=UTF-8"
     import=" java.util.*,sec02.ex01.*"
    pageEncoding="UTF-8"
    isELIgnored="false"
   %>  <%-- EL 태크 여부 ${자바변수}를 사용하기 위함  --%>
    
  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  request.setCharacterEncoding("UTF-8");
%>    
<html>
<head>
<meta charset="UTF-8">
<jsp:useBean  id="m" class="sec02.ex01.MemberBean"/>
<jsp:setProperty name="m" property="*"  />
<%
   MemberDAO memDAO=new MemberDAO();
   memDAO.addMember(m); /* 호출해서 회원 정보가 저장된 memberBean 'm'을 전달한다. */
   List membersList =memDAO.listMembers(); /*memDAO.listMember를 호출해서 List membersList를 조회한다.   */
   request.setAttribute("membersList1", membersList); /* "membersList"로 <- membersList를 바인딩 한다.  */
%> 
</head>
<body>
<jsp:forward  page="membersList.jsp" />  <!-- 포워딩 한다. ??무슨 뜻?? -->
</body>
</html>
