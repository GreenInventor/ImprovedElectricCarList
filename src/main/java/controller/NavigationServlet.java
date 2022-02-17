package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ElectricCar;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ElectricCarHelper ech = new ElectricCarHelper();
		String act = request.getParameter("doThisToCar");
		
		String path = "/viewAllCarsServlet";
		
		if(act.equals("Delete Car"))
		{
			try
			{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ElectricCar carToDelete = ech.searchForElectricCarById(tempId);
				ech.deleteCar(carToDelete);
			}
			catch(NumberFormatException e)
			{
				System.out.println("Forgot to select an electric car");
			}
		}
		else if(act.equals("Edit Car"))
		{
			try
			{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ElectricCar carToEdit = ech.searchForElectricCarById(tempId);
				request.setAttribute("carToEdit", carToEdit);
				path = "/editcar.jsp";
			}
			catch(NumberFormatException e)
			{
				System.out.println("Forgot to select an electric car");
			}
			
		}
		else if(act.equals("Add Car"))
		{
			path = "/addcar.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
