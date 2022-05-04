package com.edu;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.dao.TestDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = "[{\"do_id\":\"1\", \"do_content\":20}]";
		TestDAO dao = new TestDAO();
		List<Map<String, String>> map = dao.to_do_List();
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(map));
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String di = request.getParameter("do_id");
		String dc = request.getParameter("do_content");
		
		TestDAO dao = new TestDAO();
		dao.insertTest(di, dc);
		
		response.getWriter().print("{\"do_id\":\"" + di + "\",\"do_content\":" + dc + "}");
	}

}
