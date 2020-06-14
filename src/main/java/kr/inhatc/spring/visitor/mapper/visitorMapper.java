package kr.inhatc.spring.visitor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.inhatc.spring.visitor.dto.visitorDTO;

@Mapper
public interface visitorMapper {

	List<visitorDTO> visitorList();


}
