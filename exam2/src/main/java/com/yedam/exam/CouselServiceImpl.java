package com.yedam.exam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouselServiceImpl implements CounselService {

	@Autowired CounselDAO dao;
	
	@Override
	public ResultVO insert(List<Counsel> list) {
		
		ResultVO result = new ResultVO();
		List<String> errList = new ArrayList<String>();
		for (Counsel vo : list) {
			if(vo.getDttm() <= 100)
				dao.insert(vo);
			else {
				errList.add(vo.getEmployee_id());
			}
		}
		result.setTotal(list.size());
		result.setSuccess(list.size()-errList.size());
		result.setErrList(errList);
		return result;
	}
	
}
