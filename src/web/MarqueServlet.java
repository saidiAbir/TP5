package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import dao.MarqueDaoImpl;
import dao.IMarqueDao;
import metier.entities.Marque;

@WebServlet(name = "marServ", urlPatterns = { "/Marques", "/saisieMarque",
    "/saveMarque", "/supprimerMar", "/editerMar", "/updateMar" })
public class MarqueServlet extends HttpServlet {
  private static final Object mar = null;
IMarqueDao metier;

  @Override
  public void init() throws ServletException {
    metier = new MarqueDaoImpl();
  }

@Override
protected void doGet(HttpServletRequest request,
 HttpServletResponse response) 
 throws ServletException, IOException {
String path=request.getServletPath();
System.out.println("PATH "+path);
if (path.equals("/Marques"))
{
MarqueModele model= new MarqueModele();
List<Marque> Marqs = metier.getAllMarques();
model.setMarques(Marqs);
request.setAttribute("model", model);
request.getRequestDispatcher("Marques.jsp").forward(request,response);
}
else if (path.equals("/saisieMarque") )
{
request.getRequestDispatcher("saisieMarque.jsp").forward(request,response
);
}
else if (path.equals("/saveMarque") && 
request.getMethod().equals("POST"))
{
Date dateCat= new Date();
 String nom=request.getParameter("nom");
 String pattern = "yyyy-MM-dd";
 SimpleDateFormat simpleDateFormat = new
SimpleDateFormat(pattern);
 try {
dateCat = simpleDateFormat.parse(request.getParameter("dateCat"));
} catch (ParseException e) {
e.printStackTrace();
}
 
Marque cat = metier.save(new Marque(nom,dateCat));
request.setAttribute("Marque", mar);
response.sendRedirect("Marques");
}
else if (path.equals("/supprimerMar"))
{
 Long id= Long.parseLong(request.getParameter("id"));
 metier.deleteMarque(id);
 response.sendRedirect("Marques");
}
else if (path.equals("/editerMar") )
{
Long id= Long.parseLong(request.getParameter("id"));
 Marque cat = metier.getMarque(id);
 request.setAttribute("Marque", mar);
request.getRequestDispatcher("editerMarque.jsp").forward(request,response
);
}
else if (path.equals("/updateMar") )
{
Date dateCat= new Date();
Long id = Long.parseLong(request.getParameter("id"));
String nom=request.getParameter("nom");
Marque cat = new Marque();
cat.setidMar(id);
cat.setnomMar(nom);
String pattern = "yyyy-MM-dd";
SimpleDateFormat simpleDateFormat = new
SimpleDateFormat(pattern);
 try {
dateCat = 
simpleDateFormat.parse(request.getParameter("dateCreation"));
} catch (ParseException e) {
e.printStackTrace();
}
cat.setDateCreation(dateCat);
 metier.updateMarque(cat);
response.sendRedirect("Marques");
}
else
{
response.sendError(Response.SC_NOT_FOUND);
}
}

  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
