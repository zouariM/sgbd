package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Championnat;
import DAO.ChampionnatDAO;
import DAO.ChampionnatDAOImp;

/**
 * Servlet implementation class SaisonController
 */
@WebServlet("/championnats")
public class ChampionnatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChampionnatController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ChampionnatDAOImp dao = new ChampionnatDAOImp();
		List<Championnat> all = dao.findAll();
		
		request.setAttribute("active", "championnats");
		request.setAttribute("header_message",dao.SQL_CONSULTER);
		request.setAttribute("green_button", "Ajouter une championnat");
		request.setAttribute("description", "selectionner tous les championnats");
		request.setAttribute("nb_results", all.size()   );
		request.setAttribute("all", all);
		request.getRequestDispatcher("championnats.jsp").forward(request, response);
	
	}

	private ChampionnatDAO ChampionnatDAOImp() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
