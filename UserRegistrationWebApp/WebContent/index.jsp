<%@ page language="java" contentType="text/html; charset=charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Korisnička aplikacija</title>
	</head>
		<body>
			<h3>${(poruka != null ? poruka : "Dobrodošli")}</h3> <br/><br/>
			<form action="login" method="POST">
				<table>
					<tr><td>Korisničko ime</td>
					<td><input type="text" name="username" value="${korisnik.username}" width = "20"/>
					</td></tr>
					<tr><td>Lozinka:</td>
					<td><input type = "password" name = "password" value = "${korisnik.password }" width="20"/>
					</td></tr>
					<tr><td><input type = "submit" value="Ulogujte se"/></td>
					<td><input type = "reset" value ="Poništite"/></td></tr>								
				</table>
			</form>		
			
			 <a href="registracija.jsp">Registracija</a>
	
		</body>
</html>