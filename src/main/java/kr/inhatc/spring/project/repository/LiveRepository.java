package kr.inhatc.spring.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.project.entity.Live;

@Repository
public interface LiveRepository extends CrudRepository<Live, String>{

	List<Live> findAllByOrderByIdxDesc();
}
