
import com.webapp.ejb.employeeSessionBeanRemote;
import com.webapp.entity.employee;
import java.io.IOException;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Deleteemployee", urlPatterns = {"/delete_employee"})
public class Deleteemployee extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stid = request.getParameter("id");

        try {
            InitialContext ic = new InitialContext();
            employeeSessionBeanRemote ssbr = (employeeSessionBeanRemote) ic.lookup("com.webapp.ejb.employeeSessionBeanRemote");

            employee s = ssbr.findById(Integer.valueOf(stid));
            ssbr.delete(s);
            response.sendRedirect("employee_register.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
