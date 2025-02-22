package vn.com.t3h.book.dao.impl;

import vn.com.t3h.book.dao.UserDao;
import vn.com.t3h.book.model.ProductModel;
import vn.com.t3h.book.model.UserModel;
import vn.com.t3h.book.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<UserModel> getAllUsers() {
        List<UserModel> list = new ArrayList<>();
        String sql = "select * from user";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                UserModel userModel = new UserModel();
                userModel.setId(resultSet.getInt("id"));
                userModel.setUsername(resultSet.getString("username"));
                userModel.setFullname(resultSet.getString("fullname"));
                userModel.setPassword(resultSet.getString("password"));
                userModel.setEmail(resultSet.getString("email"));
                userModel.setPhoneNumber(resultSet.getString("phoneNumber"));
                userModel.setGender(resultSet.getInt("gender"));
                userModel.setAddress(resultSet.getString("address"));
                userModel.setRole(resultSet.getString("role"));

                list.add(userModel);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public UserModel findUserByUserNameAndPassword(String username, String password) {
        UserModel userModel = null;
        String sql = "SELECT * from user as u " +
                "WHERE u.username = ? AND u.password = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username); // Set tên đăng nhập
            preparedStatement.setString(2, password); // Set mật khẩu
            // tuong tu connection
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Lấy dữ liệu từ kết quả truy vấn và gán vào đối tượng UserModel
                    Integer id = resultSet.getInt("id");
                    String fullname = resultSet.getString("fullname");
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("phoneNumber");
                    Integer gender = resultSet.getInt("gender");
                    String address = resultSet.getString("address");
                    String role = resultSet.getString("role");
                    System.out.println(id + " " + fullname + " " + email + " " + phoneNumber + " " + gender + " " + address + " " + role);

                    // Tạo đối tượng UserModel từ dữ liệu truy vấn
                    userModel = new UserModel(id, username, password, fullname, email, phoneNumber, gender, address, role);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(userModel != null){
            System.out.println("Tim duoc user!!!");
        }
        return userModel;
    }

    @Override
    public UserModel findUserById(Integer userId) {
        UserModel user = null;
        String sql = "SELECT * FROM user WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer id = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String fullname = resultSet.getString("fullname");
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("phoneNumber");
                    Integer gender = resultSet.getInt("gender");
                    String address = resultSet.getString("address");
                    String role = resultSet.getString("role");

                    user = new UserModel(id, username, password, fullname, email, phoneNumber, gender, address, role);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int deleteUserById(Integer userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        int rowsDeleted = 0;
        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);

            String sql = "DELETE FROM user WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);

            rowsDeleted = statement.executeUpdate();
            System.out.println("Delete User ID: " + rowsDeleted);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return rowsDeleted;
    }

    @Override
    public int updateUser(UserModel userModel) {
        Connection connection = null;
        PreparedStatement statement = null;
        int rowsUpdated = 0;
        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);

            String sql = "UPDATE user SET username = ?, fullname = ?, email = ?, phoneNumber = ?, address = ?, role = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, userModel.getUsername());
            statement.setString(2, userModel.getFullname());
            statement.setString(3, userModel.getEmail());
            statement.setString(4, userModel.getPhoneNumber());
            statement.setString(5, userModel.getAddress());
            statement.setString(6, userModel.getRole());
            statement.setInt(7, userModel.getId());

            rowsUpdated = statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return rowsUpdated;
    }

    @Override
    public int addUser(UserModel userModel) {
        Connection connection = null;
        PreparedStatement statement = null;
        int rowsInserted = 0;
        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);
            // Thêm mới nhân viên
            String sql = "INSERT INTO user (username, password, fullname, email, phoneNumber, gender, address, role)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, userModel.getUsername());
            statement.setString(2, userModel.getPassword());
            statement.setString(3, userModel.getFullname());
            statement.setString(4, userModel.getEmail());
            statement.setString(5, userModel.getPhoneNumber());
            statement.setInt(6, userModel.getGender());
            statement.setString(7, userModel.getAddress());
            statement.setString(8, userModel.getRole());

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
