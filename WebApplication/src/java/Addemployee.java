
import com.webapp.ejb.employeeSessionBeanRemote;
import com.webapp.entity.employee;
import java.io.IOException;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Addemployee", urlPatterns = {"/add_employee"})
public class Addemployee extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            InitialContext ic = new InitialContext();
            employeeSessionBeanRemote ssbr = (employeeSessionBeanRemote) ic.lookup("com.webapp.ejb.employeeSessionBeanRemote");
            
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String email = request.getParameter("email");
            String contactNumber = request.getParameter("contact");
            String address = request.getParameter("address");
            String course = request.getParameter("course");
            
            employee employee = new employee();
            employee.setFirstname(firstName);
            employee.setLastname(lastName);
            employee.setEmail(email);
            employee.setContactnumber(contactNumber);
            employee.setAddress(address);
            employee.setCourse(course);
            
            ssbr.save(employee);
            
            response.sendRedirect("employee_register.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
