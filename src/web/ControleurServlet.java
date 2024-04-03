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
import dao.BijouxDaoImpl;
import metier.entities.Bijoux;

@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
	IBijouxDao metier;
	
	@Override
	public void init() throws ServletException {
		metier = new BijouxDaoImpl();
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
			request.getRequestDispatcher("saisieBijoux.jsp").forward(request,response);
		}
		else if (path.equals("/save.do") && request.getMethod().equals("POST"))
		{
			String nom=request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Bijoux b = metier.save(new Bijoux(nom,prix));
			request.setAttribute("Bijoux", b);
			request.getRequestDispatcher("confirmation.jsp").forward(request,response);
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
			request.getRequestDispatcher("editerBijoux.jsp").forward(request,response);
		}
		else if (path.equals("/update.do") )
		{
			Long id = Long.parseLong(request.getParameter("id"));
			String nom=request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Bijoux b = new Bijoux();
			b.setIdBijoux(id);
			b.setNomBijoux(nom);
			b.setPrix(prix);
			metier.updateBijoux(b);
			request.setAttribute("Bijoux", b);
			request.getRequestDispatcher("confirmatione.jsp").forward(request,response);
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