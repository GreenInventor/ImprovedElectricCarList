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
 * Servlet implementation class EditDealershipServlet
 */
@WebServlet("/editDealershipServlet")
public class EditDealershipServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDealershipServlet() 
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
		ElectricCarHelper ech = new ElectricCarHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Dealership dc = dsh.searchForDealershipById(tempId);
		
		String name = request.getParameter("dealershipName");
		
		try
		{
			String[] selectedCars = request.getParameterValues("carsToAdd");
			List<ElectricCar> selectedCarsList = new ArrayList<ElectricCar>();
			
			for(int i = 0; i < selectedCars.length; i++)
			{
				ElectricCar ec = ech.searchForElectricCarById(Integer.parseInt(selectedCars[i]));
				selectedCarsList.add(ec);
			}
			dc.setCars(selectedCarsList);
		}
		catch(NullPointerException ex)
		{
			List<ElectricCar> selectedCarsList = new ArrayList<ElectricCar>();
			dc.setCars(selectedCarsList);
		}
		
		dc.setDealershipName(name);
		dsh.updateDealership(dc);
		
		getServletContext().getRequestDispatcher("/viewAllDealersServlet").forward(request, response);
	}

}
