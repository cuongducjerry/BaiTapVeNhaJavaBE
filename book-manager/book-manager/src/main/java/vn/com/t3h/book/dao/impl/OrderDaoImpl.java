package vn.com.t3h.book.dao.impl;

import vn.com.t3h.book.dao.OrderDao;
import vn.com.t3h.book.model.OrderTemp;
import vn.com.t3h.book.model.ProductModel;
import vn.com.t3h.book.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public int deleteByOrderIdTemp(int deleteOrderIdTemp) {
        Connection connection = null;
        PreparedStatement statement1 = null;
        int rowsDeleted = 0;
        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);

            String sql1 = "DELETE FROM order_temp WHERE id = ?";
            statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, deleteOrderIdTemp);
            rowsDeleted = statement1.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return rowsDeleted;
    }

    @Override
    public int addOrderIdTemp(OrderTemp addOrderIdTemp) {
        Connection connection = null;
        PreparedStatement statement = null;
        int rowsInserted = 0;
        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);
            // Thêm mới nhân viên
            String sql = "INSERT INTO order_temp (name, price, quantity, customer_id) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, addOrderIdTemp.getName());
            statement.setDouble(2, addOrderIdTemp.getPrice());
            statement.setInt(3, addOrderIdTemp.getQuantity());
            statement.setInt(4, addOrderIdTemp.getCustomerId());

            // Thực thi câu lệnh
            rowsInserted = statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return rowsInserted;
    }

    @Override
    public List<OrderTemp> listOrderTemp() {
        List<OrderTemp> list = new ArrayList<>();
        String sql = "select * from order_temp";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()){

            while (resultSet.next()) {
                OrderTemp orderTemp = new OrderTemp();
                orderTemp.setId(resultSet.getInt("id"));
                orderTemp.setName(resultSet.getString("name"));
                orderTemp.setPrice(resultSet.getDouble("price"));
                orderTemp.setQuantity(resultSet.getInt("quantity"));
                orderTemp.setCustomerId(resultSet.getInt("customer_id"));

                list.add(orderTemp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void deleteOrderTempAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);
            // Thêm mới nhân viên
            String sql = "TRUNCATE TABLE order_temp;";
            statement = connection.prepareStatement(sql);

            // Thực thi câu lệnh
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public int deleteByCustomerIdTemp(int deleteCustomerIdTemp) {
        Connection connection = null;
        PreparedStatement statement1 = null;
        int rowsDeleted = 0;
        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);

            String sql1 = "DELETE FROM order_temp WHERE customer_id = ?";
            statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, deleteCustomerIdTemp);
            rowsDeleted = statement1.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return rowsDeleted;
    }

    private static void closeConnection(Connection conn) {
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
