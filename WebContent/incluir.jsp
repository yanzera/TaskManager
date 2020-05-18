<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="service.TarefasService" %>
    <%@ page import="model.Login" %>
    <%@ page import="java.util.ArrayList, model.Tarefas" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/glyphicon.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Risque&display=swap" rel="stylesheet">
<style type="text/css">
    body {  
  font-family: 'Risque', cursive;
  font-size: 22px;
  margin: 50px;
  background-color: #e6f2ff;
}

div {
  border: 1px solid gray;
  padding: 8px;
  text-align: center;
}

h1 {
  text-shadow: 2px 2px 5px blue;
  text-align: center;
}

p {
  text-indent: 50px;
  text-align: justify;
  letter-spacing: 3px;
}

a {
  text-decoration: none;
  color: #008CBA;
}

  </style>
<title>Incluir Tarefa</title>
</head>

	<%
		Login login = (Login)session.getAttribute("usuario");				
	%>
	
<body>	
		<form method = "post" action = "IncluirTarefa.do" >
		
			<h1>Inserir tarefa</h1>    
		
			<div>	
				Título <input type = "text" class="form-control" name = "titulo"></br>
				
				Descrição <textarea type = "text" class="form-control" name = "descricao"></textarea></br>
				
				E-mail	<input type = "text" class="form-control" name = "email" value ="<%=login.getEmail() %>" ></br>
				
				<input type = "submit" class="btn btn-outline-primary" value = "Inserir Tarefa">
			</div>
		</form>	
</body>
</html>