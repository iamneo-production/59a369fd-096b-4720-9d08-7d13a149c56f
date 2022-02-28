package service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Vehicle;
import utility.ConnectionManager;

public class VehicleDao extends ConnectionManager{
	
private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, model, cc,description,price) VALUES "
			+ " (?, ?,?,?,?);";

	private static final String SELECT_USER_BY_ID = "select id, name, model, cc,description,price from users where id =?";
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set id=?, name=?, model=?, cc=?,description=?,price=? where id=?;";

	public void addVehicle(Vehicle user) throws SQLException {
		try {
			Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, user.getVehicleName());
			preparedStatement.setString(2, user. getVehicleModel());
			preparedStatement.setInt(3, user.getVehicleCC());
			preparedStatement.setString(4, user.getVehicleDescription());
			preparedStatement.setInt(5, user. getVehiclePrice());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public Vehicle selectUser(int id) {
		Vehicle user = null;
		try {
			Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()){
				String name= rs.getString("name");
				String model = rs.getString("model");
				int cc = rs.getInt("cc");
				String description = rs.getString("description");
				int price = rs.getInt("price");
				user = new Vehicle(id, name, model, cc,description,price);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		System.out.println(user.getVehicleId());
		return user;
	}

	public List<Vehicle> selectAllUsers() {
		List<Vehicle> users = new ArrayList<>();
		try {
		Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String model = rs.getString("model");
				int cc = rs.getInt("cc");
				String description = rs.getString("description");
				int price = rs.getInt("price");
				users.add(new Vehicle(id, name, model, cc,description,price));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteVehicle(int id) throws SQLException {
		boolean rowDeleted;
		try {
			Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		finally{

		}
		return rowDeleted;
	}

	public boolean updateVehicle(Vehicle user) throws SQLException {
		boolean rowUpdated;
		try {
			Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
			System.out.println("updated USer:"+preparedStatement);
			preparedStatement.setString(1, user.getVehicleName());
			preparedStatement.setString(2, user. getVehicleModel());
			preparedStatement.setInt(3, user.getVehicleCC());
			preparedStatement.setString(4, user.getVehicleDescription());
			preparedStatement.setInt(5, user. getVehiclePrice());

			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		finally{

		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}

