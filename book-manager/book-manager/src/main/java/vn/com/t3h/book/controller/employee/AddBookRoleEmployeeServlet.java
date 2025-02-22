package vn.com.t3h.book.controller.employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.com.t3h.book.dao.ProductDao;
import vn.com.t3h.book.dao.ProductEmployeeDao;
import vn.com.t3h.book.dao.impl.ProductDaoImpl;
import vn.com.t3h.book.dao.impl.ProductEmployeeDaoImpl;
import vn.com.t3h.book.model.ProductModel;
import vn.com.t3h.book.service.ProductEmployeeService;
import vn.com.t3h.book.service.ProductService;
import vn.com.t3h.book.service.impl.ProductEmployeeServiceImpl;
import vn.com.t3h.book.service.impl.ProductServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/add-book-role-employee")
public class AddBookRoleEmployeeServlet extends HttpServlet {
    private ProductService productService;
    private ProductEmployeeService productEmployeeService;

    private ProductDao productDao = new ProductDaoImpl();
    private ProductEmployeeDao productEmployeeDao = new ProductEmployeeDaoImpl();

    public AddBookRoleEmployeeServlet() {
        productService = new ProductServiceImpl(productDao);
        productEmployeeService = new ProductEmployeeServiceImpl(productEmployeeDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add-book.jsp");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String pages = req.getParameter("pages");
        String publisher = req.getParameter("publisher");
        String yearPublishing = req.getParameter("yearPublishing");
        String price = req.getParameter("price");
        String discount = req.getParameter("discount");
        String quantity = req.getParameter("quantity");
        String description = req.getParameter("description");
        String image = req.getParameter("image");
        String timestamp = req.getParameter("timestamp");
        System.out.println(timestamp);

        ProductModel productModel = new ProductModel();
        productModel.setName(name);
        productModel.setPrice(Double.parseDouble(price));
        productModel.setDiscount(Double.parseDouble(discount));
        productModel.setQuantity(Integer.parseInt(quantity));
        productModel.setTotalBuy(100);
        productModel.setAuthor(author);
        productModel.setPages(Integer.parseInt(pages));
        productModel.setPublisher(publisher);
        productModel.setYearPublishing(yearPublishing);
        productModel.setDescription(description);
        productModel.setImageName("image");
        productModel.setShop(1);
        productModel.setCreatedAt("2019-01-01 00:00:00");
        productModel.setUpdatedAt(null);
        productModel.setStartsAt(null);
        productModel.setEndsAt(null);
        productModel.setCreated_by("user2");

        productService.addProduct(productModel);
        List<ProductModel> listProductModels = productService.getListProducts();
        ProductModel productModel1 = null;
        for(ProductModel productModel2 : listProductModels){
            if(productModel2.getName().equals(name) && productModel2.getPrice()==Double.parseDouble(price) && productModel2.getDiscount()==Double.parseDouble(discount)
            && productModel2.getQuantity()==Integer.parseInt(quantity) && productModel2.getYearPublishing().equals(yearPublishing) && productModel2.getPages()==Integer.parseInt(pages) &&
            productModel2.getPublisher().equals(publisher)){
                productModel1 = productModel2;
                break;
            }
        }
        productEmployeeService.addProductEmployee(productModel1);
        List<ProductModel> listProductEmployees = productEmployeeService.listProductEmployee();
        req.setAttribute("listProductEmployees", listProductEmployees);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/dms/books-role-employee.jsp");
        requestDispatcher.forward(req, resp);
    }
}
