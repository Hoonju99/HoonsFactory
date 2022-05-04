package com.yedam.exam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired	OrdersDAO dao;
	
	@Override
	public ResultVO insertOrders(List<Orders> list) {
		
		ResultVO result = new ResultVO();
		List<String> errList = new ArrayList<String>();
		for (Orders vo : list) {
			if (vo.getOrd_price() <= 1000)
				dao.insertOrders(vo);
			else {
				errList.add(vo.getCustomer());
			}
		}
		result.setTotal(list.size());
		result.setSuccess(list.size()-errList.size());
		result.setErrList(errList);
		return result;
	}

}
