package kr.inhatc.spring.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.project.entity.Live;
import kr.inhatc.spring.project.repository.LiveRepository;

@Service
public class LiveServiceImpl implements LiveService{

	@Autowired
	LiveRepository liveRepository;

	@Override
	public List<Live> liveList() {
		List<Live> list = liveRepository.findAllByOrderByIdxDesc();
		return list;
	}
}
