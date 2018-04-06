package servleti;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.http.*;

import beans.Korisnik;

public class Registracija extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		HttpSession sesija = request.getSession();
		String poruka = "";
		String username = (String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		String email = (String)request.getParameter("email");
		String telefon = (String)request.getParameter("telefon");
		String ime = (String)request.getParameter("ime");
		String prezime = (String)request.getParameter("prezime");
		Korisnik korisnik = new Korisnik();
		korisnik.setUsername(username);
		korisnik.setPassword(password);
		korisnik.setEmail(email);
		korisnik.setTelefon(telefon);
		korisnik.setIme(ime);
		korisnik.setPrezime(prezime);
		sesija.setAttribute("korisnik", korisnik);
		if(username.isEmpty() || password.isEmpty() || email.isEmpty() || ime.isEmpty() || prezime.isEmpty() || telefon.isEmpty()){
			poruka = "Niste popunili sva polja!";
			request.setAttribute("poruka", poruka);
			RequestDispatcher rd = request.getRequestDispatcher("/registracija.jsp");
			rd.forward(request, response);			
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekat", "root", "root");
			String provera = "select * from korisnikinfo where username = '" + username + "' or email = '"  + email + "';";;			
			String upit = "insert into korisnikinfo (username, password, ime, prezime, phone, email) values"
			+ " ('"+username+"', '"+password+"', '"+ime+"', '"+prezime+"', '"+telefon+"', '"+email+"' );";
			stmt = con.createStatement();
			rs = stmt.executeQuery(provera);		
			
			if (rs.next()){
				request.setAttribute("poruka", "Korisnicko ime ili email vec postoji");
				RequestDispatcher rd = request.getRequestDispatcher("/registracija.jsp");
				rd.forward(request, response);
				stmt.close();
				con.close();
			}
			else {
				stmt.executeUpdate(upit);
			}
			
		}	catch(SQLException ex){
				sesija.invalidate();
				String errormsg = ex.getMessage();
				if(con!=null) try{
					con.close();
			}catch(Exception exc){
				errormsg = errormsg + exc.getMessage();
			}
			request.setAttribute("errormsg", errormsg);
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);		
		} catch(ClassNotFoundException cnf){}
		
	request.setAttribute("poruka", "Uspesna registracija");
	RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
	rd.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		processRequest(request, response);
	}
	public String getServletInfo(){
		return "Short description";
	}
		
	

}
