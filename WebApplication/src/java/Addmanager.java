
import com.webapp.ejb.managerSessionBeanRemote;
import com.webapp.entity.manager;
import java.io.IOException;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Addmanager",urlPatterns = {"/add_manager"})
public class Addmanager extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            InitialContext ic = new InitialContext();
            managerSessionBeanRemote tsbr = (managerSessionBeanRemote) ic.lookup("com.webapp.ejb.managerSessionBeanRemote");
            
            String username = request.getParameter("username");
            String password = request.getParameter("Password");
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String email = request.getParameter("email");
            String contactNumber = request.getParameter("contact");
            String address = request.getParameter("address");
            String course = request.getParameter("course");
            
            manager manager = new manager();
            manager.setUsername(username);
            manager.setPassword(password);
            manager.setFirstname(firstName);
            manager.setLastname(lastName);
            manager.setEmail(email);
            manager.setContactnumber(contactNumber);
            manager.setAddress(address);
            manager.setCourse(course);
            
            tsbr.save(manager);
            
            response.sendRedirect("manager_register.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
