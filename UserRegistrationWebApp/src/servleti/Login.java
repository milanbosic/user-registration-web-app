package servleti;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Korisnik;

@SuppressWarnings("serial")
public class Login extends HttpServlet{
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		HttpSession sesija = request.getSession();
		String poruka = "";
		String username = (String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		Korisnik korisnik = new Korisnik();
		korisnik.setUsername(username);
		korisnik.setPassword(password);
		sesija.setAttribute("korisnik", korisnik);
		if(username.isEmpty() || password.isEmpty()){
			poruka = "Niste popunili sva polja!";
			request.setAttribute("poruka", poruka);
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);			
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekat", "root", "root");
			stmt = con.createStatement();
			String upit = "select * from KorisnikInfo where username = '" + username + "' and password = '"  + password + "';";
			rs = stmt.executeQuery(upit);
			if(rs.next()){
				String email = rs.getString("email");
				String ime = rs.getString("Ime");
				String prezime = rs.getString("Prezime");
				String telefon = rs.getString("phone");
				korisnik.setEmail(email);
				korisnik.setIme(ime);
				korisnik.setPrezime(prezime);
				korisnik.setTelefon(telefon);
				stmt.close();
				con.close();				
			}
			else{
				poruka="Neispravno korisnciko ime ili lozinka! Pokusajte ponovo.";
				request.setAttribute("poruka", poruka);
				korisnik.setPassword("");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				stmt.close();
				con.close();
				rd.forward(request, response);				
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
		
	request.setAttribute("poruka", "Vasi podaci");
	RequestDispatcher rd = request.getRequestDispatcher("/prikaz.jsp");
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
