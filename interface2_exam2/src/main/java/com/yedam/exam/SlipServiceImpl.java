package com.yedam.exam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SlipServiceImpl implements SlipService{

	@Autowired	SlipDAO dao;
	
	@Override
	public ResultVO insertSlip(List<Slip> list) {
		//테이블 입력
		ResultVO result = new ResultVO();
		List<String> errList = new ArrayList<String>();
		for (Slip vo : list) {
			if (vo.getSlipAmount() <= 20000) {
				errList.add(vo.getCustomer());
				vo.setSlipAmount(20000);
			}
			dao.insertSlip(vo);
		}
		result.setTotal(list.size());
		result.setSuccess(list.size()-errList.size());
		result.setErrList(errList);
		
		return result;  // 처리 건수 리턴;
	}

}
