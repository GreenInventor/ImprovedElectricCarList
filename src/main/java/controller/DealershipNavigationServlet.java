package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dealership;

/**
 * Servlet implementation class DealershipNavigationServlet
 */
@WebServlet("/dealershipnavigationServlet")
public class DealershipNavigationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealershipNavigationServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DealershipHelper dsh = new DealershipHelper();
		String act = request.getParameter("doThisToDealers");
		
		if(act == null)
		{
			getServletContext().getRequestDispatcher("/viewAllDealersServlet").forward(request, response);
		}
		else if(act.equals("Delete Dealership"))
		{
			try
			{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Dealership dealerToDelete = dsh.searchForDealershipById(tempId);
				dsh.deleteDealership(dealerToDelete);
			}
			catch(NumberFormatException e)
			{
				System.out.println("Forgot to select a dealership");
			}
			finally
			{
				getServletContext().getRequestDispatcher("/viewAllDealersServlet").forward(request, response);
			}
		}
		else if(act.equals("Edit Dealership"))
		{
			try
			{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Dealership dealerToEdit = dsh.searchForDealershipById(tempId);
				request.setAttribute("dealerToEdit", dealerToEdit);
				
				ElectricCarHelper ech = new ElectricCarHelper();
				
				request.setAttribute("allCars", ech.showAllCars());
				
				if(ech.showAllCars().isEmpty())
				{
					request.setAttribute("allCars", " ");
					System.out.println("No cars found!");
				}
				getServletContext().getRequestDispatcher("/editdealership.jsp").forward(request, response);
			}
			catch(NumberFormatException e)
			{
				getServletContext().getRequestDispatcher("/viewAllDealersServlet").forward(request, response);
			}
		}
		else if(act.equals("Add Dealership"))
		{
			getServletContext().getRequestDispatcher("/addDealershipServlet").forward(request, response);
		}
	}

}
