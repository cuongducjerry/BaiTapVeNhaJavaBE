package vn.com.t3h.book.dao.impl;

import vn.com.t3h.book.dao.ProductDao;
import vn.com.t3h.book.model.ProductModel;
import vn.com.t3h.book.model.UserModel;
import vn.com.t3h.book.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public List<ProductModel> getAllProducts() {
        List<ProductModel> list = new ArrayList<>();
        String sql = "select * from product";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                ProductModel productModel = new ProductModel();
                productModel.setId(resultSet.getInt("id"));
                productModel.setName(resultSet.getString("name"));
                productModel.setPrice(resultSet.getDouble("price"));
                productModel.setDiscount(resultSet.getDouble("discount"));
                productModel.setQuantity(resultSet.getInt("quantity"));
                productModel.setTotalBuy(resultSet.getInt("totalBuy"));
                productModel.setAuthor(resultSet.getString("author"));
                productModel.setPages(resultSet.getInt("pages"));
                productModel.setPublisher(resultSet.getString("publisher"));
                productModel.setYearPublishing(resultSet.getString("yearPublishing"));
                productModel.setDescription(resultSet.getString("description"));
                productModel.setImageName(resultSet.getString("imageName"));
                productModel.setShop(resultSet.getInt("shop"));
                productModel.setCreatedAt(resultSet.getString("createdAt"));
                productModel.setStartsAt(resultSet.getString("startsAt"));
                productModel.setEndsAt(resultSet.getString("endsAt"));
                productModel.setCreated_by(resultSet.getString("created_by"));

                list.add(productModel);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int addProduct(ProductModel product) {
        System.out.println("--------------- ADD PRODUCT ---------------");
        Connection connection = null;
        PreparedStatement statement = null;
        int rowsInserted = 0;
        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);
            // Thêm mới nhân viên
            String sql = "INSERT INTO product (name, price, discount, quantity, totalBuy, author, pages, publisher, yearPublishing, description, imageName, shop," +
                    " createdAt,updatedAt, startsAt, endsAt, created_by) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setDouble(3, product.getDiscount());
            statement.setInt(4, product.getQuantity());
            statement.setInt(5, product.getTotalBuy());
            statement.setString(6, product.getAuthor());
            statement.setInt(7, product.getPages());
            statement.setString(8, product.getPublisher());
            statement.setString(9, product.getYearPublishing());
            statement.setString(10, product.getDescription());
            statement.setString(11, product.getImageName());
            statement.setInt(12, product.getShop());
            statement.setString(13, product.getCreatedAt());
            statement.setString(14, product.getUpdatedAt());
            statement.setString(15, product.getStartsAt());
            statement.setString(16, product.getEndsAt());
            statement.setString(17, product.getCreated_by());

            // Thực thi câu lệnh
            rowsInserted = statement.executeUpdate();
            System.out.println("--------------- ADD PRODUCT SUCESSFULL ---------------");
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return rowsInserted;
    }

    @Override
    public int deleteProduct(int productId) {
        Connection connection = null;
        PreparedStatement statement1 = null;
        int rowsDeleted = 0;
        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);

            String sql1 = "DELETE FROM product WHERE id = ?";
            statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, productId);
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
    public int updateProduct(ProductModel product) {
        Connection connection = null;
        PreparedStatement statement = null;
        int rowsUpdated = 0;
        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);

            String sql = "UPDATE product SET name = ?, price = ?, discount = ?, quantity = ?, totalBuy = ?, author = ?, pages = ?, publisher = ?, yearPublishing = ?, description = ?, imageName = ?, shop = ?, createdAt = ?, updatedAt = ?, startsAt = ?, endsAt = ?, created_by = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setDouble(3, product.getDiscount());
            statement.setInt(4, product.getQuantity());
            statement.setInt(5, product.getTotalBuy());
            statement.setString(6, product.getAuthor());
            statement.setInt(7, product.getPages());
            statement.setString(8, product.getPublisher());
            statement.setString(9, product.getYearPublishing());
            statement.setString(10, product.getDescription());
            statement.setString(11, product.getImageName());
            statement.setInt(12, product.getShop());
            statement.setString(13, product.getCreatedAt());
            statement.setString(14, product.getUpdatedAt());
            statement.setString(15, product.getStartsAt());
            statement.setString(16, product.getEndsAt());
            statement.setString(17, product.getCreated_by());
            statement.setInt(18, product.getId());

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
    public ProductModel findProductById(Integer productId) {
        ProductModel productModel = null;
        String sql = "SELECT * FROM product WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, productId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    Double price = resultSet.getDouble("price");
                    Double discount = resultSet.getDouble("discount");
                    Integer quantity = resultSet.getInt("quantity");
                    Integer totalBuy = resultSet.getInt("totalBuy");
                    String author = resultSet.getString("author");
                    Integer pages = resultSet.getInt("pages");
                    String publisher = resultSet.getString("publisher");
                    String yearPublishing = resultSet.getString("yearPublishing");
                    String description = resultSet.getString("description");
                    String imageName = resultSet.getString("imageName");
                    Integer shop = resultSet.getInt("shop");
                    String createdAt = resultSet.getString("createdAt");
                    String updatedAt = resultSet.getString("updatedAt");
                    String startsAt = resultSet.getString("startsAt");
                    String endsAt = resultSet.getString("endsAt");
                    String created_by = resultSet.getString("created_by");

                    productModel = new ProductModel(id, name, price, discount, quantity,
                            totalBuy, author, pages, publisher, yearPublishing,
                            description, imageName, shop, createdAt, updatedAt,
                            startsAt, endsAt, created_by);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productModel;
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
