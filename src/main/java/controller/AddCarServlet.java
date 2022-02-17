package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ElectricCar;

/**
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/addCarServlet")
public class AddCarServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCarServlet() 
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
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		int year = Integer.parseInt(request.getParameter("year"));
		int range = Integer.parseInt(request.getParameter("range"));
		int topspeed = Integer.parseInt(request.getParameter("topspeed"));
		double zerosixty = Double.parseDouble(request.getParameter("zerosixty"));
		int chargepower = Integer.parseInt(request.getParameter("chargepower"));
		double price = Double.parseDouble(request.getParameter("price"));
		
		ElectricCar toAdd = new ElectricCar(make, model, year, price, range, topspeed, zerosixty, chargepower);
		ElectricCarHelper ech = new ElectricCarHelper();
		ech.insertCar(toAdd);
		
		getServletContext().getRequestDispatcher("/addcar.html").forward(request, response);
	}

}
