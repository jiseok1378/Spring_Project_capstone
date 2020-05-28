package kr.inhatc.spring.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.project.entity.Member;
import kr.inhatc.spring.project.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public List<Member> memberList() {
		List<Member> list =memberRepository.findAllByOrderByIdDesc();
		//System.out.println("================> 크기 : " + list.size());
		//System.out.println(list.get(0));
		return list;
	}

}
