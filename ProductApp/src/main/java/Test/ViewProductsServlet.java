package Test;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet("/view")
public class ViewProductsServlet extends GenericServlet {
	public void init() throws ServletException {
		// NoCode
	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		ArrayList<ProductBean> al = new RetrieveDAO().retrieve();
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		if (al.size() == 0) {
			pw.println("Products Not Available...<br>");
		} else {
			Iterator<ProductBean> it = al.iterator();
			while (it.hasNext()) {
				ProductBean pb = (ProductBean) it.next();
				pw.println(pb.getCode() + "&nbsp&nbsp" + pb.getName() + "&nbsp&nbsp" + pb.getPrice() + "&nbsp&nbsp"
						+ pb.getQty() + "<br>");
			} // end of loop
		} // end of else
		RequestDispatcher rd = req.getRequestDispatcher("choice.html");
		rd.include(req, res);
	}

	public void destroy() {
		// NoCode
	}
}
