package penweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * receives post from search form and sends it on to the results page
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String params = "/penweb/results.jsp";
		String lang = request.getParameter("lang");
		if (!lang.isEmpty()) {
			if (params == "/penweb/results.jsp") {
				params += "?lang=" + java.net.URLEncoder.encode(lang, "UTF-8");
			}
			else {
				params += "&lang=" + java.net.URLEncoder.encode(lang, "UTF-8");
			}
		}
		response.sendRedirect(params);
	}

}
