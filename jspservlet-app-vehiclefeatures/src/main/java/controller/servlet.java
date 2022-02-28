package controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.VehicleDao;
import model.Vehicle;

@WebServlet("/")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VehicleDao vehicleDao;
	
	public void init() {
		vehicleDao = new VehicleDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

			try {
				switch (action) {
				case "/new":
					showNewForm(request, response);
					break;
				case "/insert":
					addVehicle(request, response);
					break;
				case "/delete":
					deleteVehicle(request, response);
					break;
				case "/edit":
					showEditForm(request, response);
					break;
				case "/update":
					updateVehicle(request, response);
					break;
				case "/list":
					System.out.println("HEllo");
					selectAllUsers(request,response);
					break;
				default:
					selectAllUsers(request, response);
					break;
				}
			} catch (SQLException ex) {
				throw new ServletException(ex);
			}
		}

	private void selectAllUsers(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Vehicle> listUser = vehicleDao.selectAllUsers();
		//Vehicle[] listUser = users.toArray(new Vehicle[users.size()]);
		request.setAttribute("listUser", listUser);
		System.out.println(listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Vehicle existingUser = vehicleDao.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void addVehicle(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
				String name = request.getParameter("name");
				String model = request.getParameter("model");
				int cc = Integer.parseInt(request.getParameter("cc"));
				String description = request.getParameter("description");
				int price =Integer.parseInt( request.getParameter("price"));
		Vehicle newUser = new Vehicle( name, model, cc,description,price);
		vehicleDao.addVehicle(newUser);
		response.sendRedirect("list");
	}
   

	private void updateVehicle(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
                int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String model = request.getParameter("model");
				int cc = Integer.parseInt(request.getParameter("cc"));
				String description = request.getParameter("description");
				int price =Integer.parseInt( request.getParameter("price"));

		Vehicle book = new Vehicle(id, name, model, cc,description,price);
		vehicleDao.updateVehicle(book);
		response.sendRedirect("list");
	}

	private void deleteVehicle(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		vehicleDao.deleteVehicle(id);
		response.sendRedirect("list");

	}

}
