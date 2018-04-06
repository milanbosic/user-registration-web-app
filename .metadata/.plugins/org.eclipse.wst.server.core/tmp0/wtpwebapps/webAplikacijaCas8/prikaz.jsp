<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <title>Korisnička aplikacija</title>	
    </head>
    <body>
        <h3>${poruka}</h3><br/><br/>            
        <table width="40%" border="3">
            <tr><td width="50%"> Korisničko ime:</td>
            <td>${korisnik.username} </td></tr>
            <tr><td>Ime:</td>
            <td>${korisnik.ime}</td></tr>
            <tr><td>Prezime:</td>
            <td>${korisnik.prezime}</td></tr>
            <tr><td>Email:</td>
            <td>${korisnik.email}</td></tr>
            <tr><td>Telefon:</td>
            <td>${korisnik.telefon}</td></tr>
        </table><br/>
        <a href="promena.jsp">Promenite podatke</a>
        <a href="logout">Izlogujte se</a>
    </body>
</html>
