package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dealership;

/**
 * Servlet implementation class ViewAllDealersServlet
 */
@WebServlet("/viewAllDealersServlet")
public class ViewAllDealersServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllDealersServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DealershipHelper dsh = new DealershipHelper();
		List<Dealership> ds = dsh.getDealerships();
		request.setAttribute("allDealers", ds);
		
		if(ds.isEmpty())
		{
			request.setAttribute("allDealers", " ");
			System.out.println("No dealerships found!");
		}
		
		getServletContext().getRequestDispatcher("/dealershiplist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
