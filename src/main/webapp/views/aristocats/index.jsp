<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h1>All of our Cats</h1>

<c:forEach items="${requestScope.aristocatsJspVariable}" var="individualCat" >
  <h2><c:out value="${individualCat.getFirstName()} ${individualCat.getLastName()}" /></h2>
  <img src=<c:out value="${individualCat.getPhotoUrl()}" /> />
</c:forEach>
