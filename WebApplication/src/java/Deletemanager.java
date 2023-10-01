
import com.webapp.ejb.managerSessionBeanRemote;
import com.webapp.entity.manager;
import java.io.IOException;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Deletemanager",urlPatterns = {"/delete_manager"})
public class Deletemanager extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tid = request.getParameter("id");
        
        try {
            InitialContext ic = new InitialContext();
            managerSessionBeanRemote tsbr = (managerSessionBeanRemote) ic.lookup("com.webapp.ejb.managerSessionBeanRemote");
            
            manager t = tsbr.findById(Integer.valueOf(tid));
            tsbr.delete(t);
            response.sendRedirect("manager_register.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
