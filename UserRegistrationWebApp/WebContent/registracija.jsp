<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<h3>${(poruka != null ? poruka : "Registracija korisnika")}</h3> <br/><br/>
		<form action="registracija" method="POST">
				<table>
					<tr><td>Korisničko ime</td>
					<td><input type="text" name="username" value="${korisnik.username}" width = "20"/>
					</td></tr>
					<tr><td>Lozinka:</td>
					<td><input type = "password" name = "password" value = "${korisnik.password }" width="20"/>
					</td></tr>
					<tr><td>E-mail:</td>
					<td><input type = "text" name = "email" value = "${korisnik.email }" width="20"/>
					</td></tr>
					<tr><td>Telefon:</td>
					<td><input type = "text" name = "telefon" value = "${korisnik.telefon }" width="20"/>
					</td></tr>
					<tr><td>Ime:</td>
					<td><input type = "text" name = "ime" value = "${korisnik.ime }" width="20"/>
					</td></tr>
					<tr><td>Prezime:</td>
					<td><input type = "text" name = "prezime" value = "${korisnik.prezime }" width="20"/>
					</td></tr>
					<tr><td><input type = "submit" value="Registrujte se"/></td>
					<td><input type = "reset" value ="Poništite"/></td></tr>								
				</table>
		</form>

	</body>
</html>