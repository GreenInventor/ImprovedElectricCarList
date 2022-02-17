package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ElectricCar;

/**
 * Servlet implementation class EditCarServlet
 */
@WebServlet("/editCarServlet")
public class EditCarServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCarServlet() 
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
		
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		int year = Integer.parseInt(request.getParameter("year"));
		int range = Integer.parseInt(request.getParameter("range"));
		int topspeed = Integer.parseInt(request.getParameter("topspeed"));
		double zerosixty = Double.parseDouble(request.getParameter("zerosixty"));
		int chargepower = Integer.parseInt(request.getParameter("chargepower"));
		double price = Double.parseDouble(request.getParameter("price"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		ElectricCar carToUpdate = ech.searchForElectricCarById(tempId);
		carToUpdate.setMake(make);
		carToUpdate.setModel(model);
		carToUpdate.setYear(year);
		carToUpdate.setMaxmiles(range);
		carToUpdate.setTopspeed(topspeed);
		carToUpdate.setZerosixtyacceleration(zerosixty);
		carToUpdate.setChargepower(chargepower);
		carToUpdate.setPrice(price);
		
		ech.updateCar(carToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
	}

}
