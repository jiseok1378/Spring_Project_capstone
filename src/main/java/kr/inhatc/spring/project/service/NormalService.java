package kr.inhatc.spring.project.service;

import java.util.List;

import kr.inhatc.spring.project.entity.Location;

public interface NormalService {

	// 지역별 리스트 select
	List<Location> confirmerList(String area);

}
