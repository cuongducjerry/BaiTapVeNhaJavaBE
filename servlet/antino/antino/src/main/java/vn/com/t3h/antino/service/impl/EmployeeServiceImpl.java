package vn.com.t3h.antino.service.impl;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.com.t3h.antino.dao.DepartmentDAO;
import vn.com.t3h.antino.dao.EmployeeDAO;
import vn.com.t3h.antino.dao.impl.DepartmentDaoImpl;
import vn.com.t3h.antino.dao.impl.EmployeeDAOImpl;
import vn.com.t3h.antino.model.DepartmentModel;
import vn.com.t3h.antino.model.EmployeeModel;
import vn.com.t3h.antino.service.EmployeeService;
import vn.com.t3h.antino.util.MapClientToSeverUtil;
import vn.com.t3h.antino.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    public final DepartmentDAO departmentDAO;
    public EmployeeServiceImpl(EmployeeDAO employeeDAO, DepartmentDAO departmentDAO) {
        this.employeeDAO = employeeDAO;
        this.departmentDAO = departmentDAO;
    }

    @Override
    public List<EmployeeModel> getAllEmployees(String name, String salary, String fromDate, String toDate, String position) {

        if (StringUtils.isBlank(name)){
            name = null;
        }
        Long salaryData = StringUtils.toLong(salary);
        if (StringUtils.isBlank(fromDate)){
            fromDate = null;
        }
        if (StringUtils.isBlank(toDate)){
            toDate = null;
        }
        if (StringUtils.isBlank(position)){
            position = null;
        }

        List<EmployeeModel> employeeModels = employeeDAO.getAllEmployees2(name,salaryData,fromDate,toDate,position);
        return employeeModels;

    }

    @Override
    public int saveEmployee(HttpServletRequest request) {
        // convert data từ param sang model class EmployeeModel
        EmployeeModel model = MapClientToSeverUtil.toModel(EmployeeModel.class,request);
        int numberRowExecute = 0;
        if(request.getAttribute("employeeIdAttribute")==(null)) {
            System.out.println("Model GetEmployeeID: " + model.getEmployeeId());
            numberRowExecute = employeeDAO.addEmployee(model);
            System.out.println("---------- add-employee----------");
        }
        else if(model.getEmployeeId() != null && request.getAttribute("employeeIdAttribute")!=(null)) {
            numberRowExecute = employeeDAO.updateEmployee(model);
        }
        return numberRowExecute;
    }

    public int deletedById(Integer id){
        int numberRowDeleted = employeeDAO.deleteEmployee(id);
        return numberRowDeleted;
    }

    public EmployeeModel findById(String id){
        if (id == null || id.equals("")){
            return new EmployeeModel();
        }
        return employeeDAO.getEmployeeById(Integer.parseInt(id));
    }
}