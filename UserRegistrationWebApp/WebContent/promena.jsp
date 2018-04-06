<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Korisnička aplikacija</title>
    </head>
    <body>
       <h3>Vaši podaci koje možete menjati</h3><br/><br/>
       <form action="izmena" method="post" >
          <table width="40%" border="3">
              <tr><td width="50%">Ime:</td>
              <td><input type="text" name="ime" value="${korisnik.ime}" size="30"/></td></tr>
              <tr><td>Prezime:</td>
              <td><input type="text" name="prezime" value="${korisnik.prezime}" size="30"/></td></tr>
              <tr><td>Email:</td>
              <td><input type="text" name="email" value="${korisnik.email}" size="30"/></td></tr>
              <tr><td>Telefon:</td>
              <td><input type="text" name="telefon" value="${korisnik.telefon}" size="30" /></td></tr>
          </table><br/>
          <input type="submit" value="Prihvatite izmenu"/>
        </form>
     </body>
</html>
