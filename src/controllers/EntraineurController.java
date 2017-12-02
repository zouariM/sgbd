package controllers;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import entities.ServiceResponse;
import services.ServiceEntraineur;

/**
 * Servlet implementation class EntraineurController
 */
@WebServlet("/entraineurs")
public class EntraineurController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntraineurController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    protected void other(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	
    }
    
    
    void  processResponse(ServiceResponse s){
    	for(int i = 0 ; i  < s.data.size(); i ++){
    		for(int j = 0; j < s.metaData.size();j++){
    			if(s.metaData.get(j).isId){
    				String bf = s.data.get(i).get(j);
    				String res = "<a href=\"entraineur/"+bf+"\"> "+bf+"</a> ";
    				s.data.get(i).set(j, res);
    			}else if(s.metaData.get(j).isReference){
    				String bf = s.data.get(i).get(j);
    				String res = "<a href=\""+s.metaData.get(j).referencedEntityName+"/"+bf+"\"> "+bf+"</a> ";
    				s.data.get(i).set(j, res);
    			}
    		}
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceEntraineur service = new ServiceEntraineur();
		ServiceResponse res = service.getEntraineurs();
		processResponse(res);
		request.setAttribute("active", "entraineurs");
		request.setAttribute("header_message", res.query);
		request.setAttribute("green_button", "Ajouter un entraineur");
		request.setAttribute("nb_results", res.data.size());
		request.setAttribute("description", res.queryDescription);
		request.setAttribute("show_actions", true);
		List<String> l = new ArrayList<>();
		l.add("action 1");
		l.add("action 2");
		request.setAttribute("actions",l);
		request.setAttribute("metadata", res.metaData);
		request.setAttribute("data", res.data);
		request.getRequestDispatcher("crud.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
