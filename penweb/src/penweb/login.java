package penweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebController webcon = new WebController();
		String loginName = request.getParameter("loginname");
		String password = request.getParameter("password");
		
		boolean login = webcon.tryLogin(loginName, password);
		
		if (login) {
			HttpSession session = request.getSession(true);
			session.setAttribute("name", loginName);
			response.sendRedirect("/penweb");
			webcon.close();
			return;
		}
		else {
			response.sendRedirect("error.jps?err=2");
			webcon.close();
			return;
		}
	}

}
