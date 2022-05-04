package co.edu.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.product.service.ProductService;
import co.edu.product.serviceImpl.ProductServiceImpl;

public class ForeignBook implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ProductService Dao = new ProductServiceImpl();		
		request.setAttribute("bookList", Dao.selectList());
		
		return "main/foreignbook.tiles";
	}

}
