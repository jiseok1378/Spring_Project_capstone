package kr.inhatc.spring.visitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.visitor.dto.visitorDTO;
import kr.inhatc.spring.visitor.mapper.visitorMapper;

@Service
public class visitorSerivceImpl implements visitorService {

	@Autowired
	private visitorMapper visitorMapper;
	
	@Override
	public List<visitorDTO> visitorList() {
		// TODO Auto-generated method stub
		return visitorMapper.visitorList();
	}

}
