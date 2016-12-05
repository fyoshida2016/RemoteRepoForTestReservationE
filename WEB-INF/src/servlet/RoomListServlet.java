package servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.RoominfoManager;
import db.UserManager;
import model.Roominfo;
import model.User;

@WebServlet(name = "RoomListServlet", urlPatterns = { "/RoomListServlet" })
public class RoomListServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doMain(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doMain(req, res);
	}

	public void doMain(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		HttpSession session=req.getSession();

		RoominfoManager rm=new RoominfoManager();
		List<Roominfo>rooms=rm.getRoominfoList();


		req.setAttribute("Rooms", rooms);
		req.getRequestDispatcher("RoomList.jsp").forward(req, res);
	}
}
