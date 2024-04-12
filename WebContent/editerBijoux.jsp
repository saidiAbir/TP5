<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
<div class="card-header">
Modification des Bijoux
</div>
<div class="card-body">
<form action="update.do" method="post">
<div style="display:none;" class="form-group">
    <label class="control-label">ID Bijoux :</label>
    <input type="text" name="id" class="form-control" value="${Bijoux.idS}"/>
</div>

<div class="form-group">
<label class="control-label">Nom Bijoux :</label>
<input type="text" name="nom" class="form-control"
value="${Bijoux.nom_Bijoux}"/>
</div>
<div class="form-group">
<label class="control-label">Prix </label>
<input type="text" name="prix" class="form-control" value="${Bijoux.prix}"/>
</div>
<div class="form-group"> 
 <select name="Marque" class="form-control">
 <option value="${bijoux.Marque.idMar}"
selected>${bijoux.Marque.nomMar}</option>
 <c:forEach items="${MarModel.Marques}" var="Mar"> 
 <c:if test="${Mar.idMar != bijoux.Marque.idMar}"> 
 <option value="${Mar.idMar}">${Mar.nomMar}</option>
 </c:if>
 </c:forEach>
 </select>
</div>
<div>
<button type="submit" class="btn btn-primary">Modifier</button>
</div>
</form>
</div>
</div>
</div>
</body>
</html>