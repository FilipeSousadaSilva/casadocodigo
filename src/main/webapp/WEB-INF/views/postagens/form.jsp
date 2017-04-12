<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Livros de Java, Android, iphone, Ruby, Php e muito mais - casa do código</title>
	</head>
	
	<body>
		<form:form action="${s:mvcUrl('PC#gravar').build() }" method="post" commandName="postagem">
			<div>
				<label>
					Titulo
				</label>
				<input type="text" name="titulo"> 
				<!-- o name serve para enviar os dados que o usuário preencheu para dentro do controller --> 
				<form:errors path="titulo"></form:errors>
			</div>
			<div>
				<label>Descrição</label>
				<textarea rows="20" cols="20" name="descricao"></textarea>
				<form:errors path="descricao"></form:errors>
			</div>
			<div>
				<label>Páginas</label>
				<input type="text" name="paginas">
				<form:errors path="paginas"></form:errors>
			</div>
			<c:forEach items="${tipos}" var="tipoPreco" varStatus="status"> 
			<!-- A principal vantagem de usar o forEach é que adicionando qualquer outro tipo de preço no enum, automaticamente 
			a nossa JSP vai estar preparada para trabalhar com ele. -->
		        <div>
		            <label>${tipoPreco}</label>
		            <input type="text" name="precos[${status.index}].valor" />
		            <input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}" />
		        </div>
		    </c:forEach>
			<button type="submit">Cadastrar</button>
		</form:form>
	</body>
</html>