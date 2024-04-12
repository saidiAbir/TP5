package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;

import dao.IBijouxDao;
import dao.IMarqueDao;
import dao.MarqueDaoImpl;
import dao.BijouxDaoImpl;
import metier.entities.Bijoux;
import metier.entities.Marque;

@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
	IBijouxDao metier;
	IMarqueDao metierMar;

	
	@Override
	public void init() throws ServletException {
		metier = new BijouxDaoImpl();
		metierMar = new MarqueDaoImpl();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/index.do"))
		{
			request.getRequestDispatcher("Bijoux.jsp").forward(request,response);
		}
		else if (path.equals("/chercher.do"))
		{
			String motCle=request.getParameter("motCle");
			BijouxModele model= new BijouxModele();
			model.setMotCle(motCle);
			List<Bijoux> Bijouxs = metier.BijouxParMC(motCle);
			model.setBijoux(Bijouxs);
			request.setAttribute("model", model);
			request.getRequestDispatcher("Bijoux.jsp").forward(request,response);
		}
		else if (path.equals("/saisie.do") )
		{
			
			List<Marque> mars = metierMar.getAllMarques();
			MarqueModele model= new MarqueModele();
			model.setMarques(mars);
			request.setAttribute("marModel", model);
			
			request.getRequestDispatcher("saisieBijoux.jsp").forward(request,response);
		}
		else if (path.equals("/save.do") && request.getMethod().equals("POST"))
		{
			String nom=request.getParameter("nom");
			Long MarqueId=Long.parseLong(request.getParameter("Marque"));
			double prix = Double.parseDouble(request.getParameter("prix"));
			Marque Mar = metierMar.getMarque(MarqueId); 
			Bijoux b = metier.save(new Bijoux(nom,prix,Mar));
			request.setAttribute("Bijoux", b);
			response.sendRedirect("chercher.do?motCle="); 
		}
		else if (path.equals("/supprimer.do"))
		{
			Long id= Long.parseLong(request.getParameter("id"));
			metier.deleteBijoux(id);
			response.sendRedirect("chercher.do?motCle=");
		}
		else if (path.equals("/editer.do") )
		{
			Long id= Long.parseLong(request.getParameter("id"));
			 Bijoux b = metier.getBijoux(id);
			 request.setAttribute("Bijoux", b);
			 
			 List<Marque> mars = metierMar.getAllMarques();
			 MarqueModele model= new MarqueModele();
			 model.setMarques(mars);
			 request.setAttribute("marModel", model);

			request.getRequestDispatcher("editerBijoux.jsp").forward(request,response);
		}
		else if (path.equals("/update.do") )
		{
			Long id = Long.parseLong(request.getParameter("id"));
			String nom=request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Long MarqueId=Long.parseLong(request.getParameter("Marque"));
			Bijoux b = new Bijoux();
			b.setIdBijoux(id);
			b.setNomBijoux(nom);
			b.setPrix(prix);
			Marque mar = metierMar.getMarque(MarqueId);
			b.setMarque(mar);
			metier.updateBijoux(b);
			response.sendRedirect("chercher.do?motCle=");

		}

		else
		{
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}