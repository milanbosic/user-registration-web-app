package servleti;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import beans.Korisnik;
import util.DB;

@SuppressWarnings("serial")
public class Izmena extends HttpServlet {
	
	protected void processRequest (HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		HttpSession sesija = request.getSession();
		Korisnik korisnik = (Korisnik) sesija.getAttribute("korisnik"); 	
		String ime = (String) request.getParameter("ime");
		String prezime = (String) request.getParameter("prezime");		
	    String telefon = (String) request.getParameter("telefon");
	    String email = (String) request.getParameter("email");	
	    
	    korisnik.setIme(ime);
	    korisnik.setPrezime(prezime);
	    korisnik.setTelefon(telefon);
	    korisnik.setEmail(email);
	    String upit = "update KorisnikInfo " + "set Ime='" + ime + "',Prezime='" + prezime + 
	    "', phone='" + telefon + "', email='" + email + "'" + " where username='" + korisnik.getUsername() + "';";
	    
	    Connection con = null;
	    Statement stmt = null;
	    String address = "prikaz.jsp";
	    try{
	    	Class.forName("com.mysql.jdbc.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekat", "root", "root");
	    	stmt = con.createStatement();
	    	stmt.executeUpdate(upit);
	    	stmt.close();
	    	con.close();
	    } catch (SQLException ex){
	    	sesija.invalidate();
	    	String errormsg = ex.getMessage();
	    	request.setAttribute("errormsg", errormsg);
	    	address = "error";	    	
	    } catch (ClassNotFoundException e) {
	    	e.printStackTrace();
	    } finally {
	    	DB.getInstance().putConnection(con);
	    }
	    request.setAttribute("poruka", "podaci su uspesno izmenjeni");
	    RequestDispatcher rd = request.getRequestDispatcher(address);
	    rd.forward(request, response);	    
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      processRequest(request, response);
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      processRequest(request, response);
    }
    
    public String getServletInfo() {
        return "Short description";
    }

}
