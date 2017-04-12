<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

	

	<head>
		<meta charset="UTF-8">
		<title>Livros de Java, Android, iphone, Ruby, Php e muito mais - casa do código</title>
	</head>
	

	<body>
		<h1>Lista de Postagens</h1>
		<div>${sucesso}</div>
		<table>
			<tr>
				<td>Título</td>
				<td>Descrição</td>
				<td>Páginas</td>
			</tr>
			<c:forEach items="${postagens }" var="postagem">
			<tr>
				<td>${postagem.titulo } </td>
				<td>${postagem.descricao } </td>
				<td>${postagem.paginas } </td>
			</tr>
		</c:forEach>
		</table>
		
	</body>
</html>