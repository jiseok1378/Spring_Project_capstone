package kr.inhatc.spring.visitor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.inhatc.spring.visitor.dto.visitorDTO;

@Service
public interface visitorService {

	List<visitorDTO> visitorList();

}
