package penweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataStructure.ICategory;
import dataStructure.IExample;
import exceptions.DuplicateException;

/**
 * Servlet implementation class duplicateCode
 */
@WebServlet("/duplicateCode")
public class duplicateCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public duplicateCode() {
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
		IExample ex = webcon.getExampleById(Long.parseLong(eid));
		Long nid = webcon.addCode(ex.getTitle(), ex.getCode(), ex.getLanguage(), ex.getAuthorsNames());
		IExample nex = webcon.getExampleById(nid);
		for (String s : cids) {
			ICategory cat = webcon.getCategoryById(Long.parseLong(s));
			try {
				cat.addCodeExample(nex);
			}
			catch (DuplicateException e){
				// Do nothing for now
			}
			webcon.store(cat);
		}
		webcon.store(nex);
		webcon.close();
		response.sendRedirect("/penweb");
	}

}
