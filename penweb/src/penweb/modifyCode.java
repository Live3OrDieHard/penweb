package penweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataStructure.*;
import exceptions.DuplicateException;

/**
 * Servlet implementation class modifyCode
 */
@WebServlet("/modifyCode")
public class modifyCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebController webcon = new WebController();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String language = request.getParameter("language");
		Long id = Long.parseLong(request.getParameter("id"));
		String[] cids = request.getParameterValues("cids");
		
		IExample ex = webcon.getExampleById(id);
		ex.setTitle(title);
		ex.setCode(content);
		ex.setLanguage(language);
		// Note: Not going to implement modifying author, our field will soon
		// be replaced by the new login system
		for (String s : cids) {
			ICategory cat = webcon.getCategoryById(Long.parseLong(s));
			try {
				cat.addCodeExample(ex);
			}
			catch (DuplicateException e){
				// Do nothing for now
			}
			webcon.store(cat);
		}
		webcon.store(ex);
		webcon.close();
	}

}
