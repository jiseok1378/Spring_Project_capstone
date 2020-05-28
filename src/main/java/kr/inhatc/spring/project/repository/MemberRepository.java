package kr.inhatc.spring.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.project.entity.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, String>{

	List<Member> findAllByOrderByIdDesc();

}
