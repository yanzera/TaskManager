<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://fonts.googleapis.com/css2?family=Risque&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/glyphicon.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
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
  
<title>Login</title>
</head>
<body>

		<form method ="post" class="form-signin" action = "ConectarLogin.do" >		
    		<h1>Conectar Login</h1>    
  		    <%
  		    	if (request.getAttribute("mensagem")!=null){
  		    		out.println(request.getAttribute("mensagem"));
  		    	}  		    	
  		    %>
  			<div>	
					E-mail  <input type = "email" class="form-control" name = "email"></br>
								 
					Senha <input type ="password" class="form-control" name = "senha"></br>
					
					<input type = "submit" class="btn btn-outline-primary" value = "Conectar">
			</div>
		</form>
</body>
</html>
