package vn.com.t3h.book.dao.impl;

import vn.com.t3h.book.dao.OrderedListDao;
import vn.com.t3h.book.model.OrderTemp;
import vn.com.t3h.book.model.OrderedModel;
import vn.com.t3h.book.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderedListDaoImpl implements OrderedListDao {

    @Override
    public List<OrderedModel> listOrderedList() {
        List<OrderedModel> list = new ArrayList<>();
        String sql = "select * from ordered_list";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()){

            while (resultSet.next()) {
                OrderedModel model = new OrderedModel();
                model.setIdOrdered(resultSet.getInt("id_ordered"));
                model.setDatePurchase(resultSet.getString("date_purchase"));
                model.setNameProduct(resultSet.getString("name_product"));
                model.setPrice(resultSet.getDouble("price"));
                model.setStatus("Đang xử lý");
                model.setCustomerId(resultSet.getInt("customer_id"));

                list.add(model);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int addOrderedList(OrderedModel orderedModel) {
        Connection connection = null;
        PreparedStatement statement = null;
        int rowsInserted = 0;
        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);
            // Thêm mới nhân viên
            String sql = "INSERT INTO ordered_list (date_purchase, name_product, price, status, customer_id) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, orderedModel.getDatePurchase());
            statement.setString(2, orderedModel.getNameProduct());
            statement.setDouble(3, orderedModel.getPrice());
            statement.setString(4, orderedModel.getStatus());
            statement.setInt(5, orderedModel.getCustomerId());

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
