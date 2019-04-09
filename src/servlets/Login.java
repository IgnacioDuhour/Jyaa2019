package servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns = "/Login", initParams = {@WebInitParam(name = "admin", value = "admin"),
		@WebInitParam(name = "usuarioBanco", value = "usuarioBanco"), @WebInitParam(name = "usuarioDonante", value = "usuarioDonante") })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// tabla con los nombre de usuario y contraseña
	private Hashtable<String, String> logins = new Hashtable<String, String>();

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		Enumeration<String> params = getInitParameterNames();
		while (params.hasMoreElements()) {
			String param = (String) params.nextElement();
			logins.put(param, getInitParameter(param));
		}
	}

		/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		if (pass.equals(logins.get(user))) {
			HttpSession session = request.getSession(true);
			session.setAttribute("usuario", user);
			session.setAttribute("password", pass);
			switch (user) {
			case "admin":
				response.sendRedirect("html/admin.html");
				break;
			case "usuarioBanco":
				response.sendRedirect("html/usuarioBanco.html");
				break;
			case "usuarioDonante":
				response.sendRedirect("html/usuarioDonante.html");
				break;
			default:
				response.sendRedirect("index.html");
			}
		} else {
			response.sendRedirect("index.html");
		}
	}

}
