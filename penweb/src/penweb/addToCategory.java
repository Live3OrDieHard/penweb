package penweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class addToCategory
 */
@WebServlet("/addToCategory")
public class addToCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebController webcon = new WebController();
		String[] cids = request.getParameterValues("cids");
		String eid = request.getParameter("eid");
		for (String s : cids) {
			webcon.getCategoryById(Long.parseLong(s)).addCodeExample(webcon.getExampleById(Long.parseLong(eid)));
		}
		webcon.close();
		response.sendRedirect("penweb");
	}

}
