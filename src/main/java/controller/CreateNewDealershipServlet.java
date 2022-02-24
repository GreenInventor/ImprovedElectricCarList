package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dealership;
import model.ElectricCar;

/**
 * Servlet implementation class CreateNewDealershipServlet
 */
@WebServlet("/createNewDealershipServlet")
public class CreateNewDealershipServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewDealershipServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ElectricCarHelper ech = new ElectricCarHelper();
		String dealershipName = request.getParameter("dealershipName");
		
		String[] selectedCars = request.getParameterValues("carsToAdd");
		List<ElectricCar> selectedCarsInList = new ArrayList<ElectricCar>();
		
		if(selectedCars != null && selectedCars.length > 0)
		{
			for(int i = 0; i < selectedCars.length; i++)
			{
				ElectricCar ec = ech.searchForElectricCarById(Integer.parseInt(selectedCars[i]));
				selectedCarsInList.add(ec);
			}
		}
		
		Dealership ds = new Dealership(dealershipName, selectedCarsInList);
		DealershipHelper dsh = new DealershipHelper();
		dsh.insertNewDealership(ds);
		
		getServletContext().getRequestDispatcher("/viewAllDealersServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
