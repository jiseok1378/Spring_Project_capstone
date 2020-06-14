package kr.inhatc.spring.consultant.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.inhatc.spring.consultant.entity.Consultant;

@Repository
public interface ConsultantRepository extends CrudRepository<Consultant, String>{

	List<Consultant> findAllByOrderByIdDesc();
	
	Optional<Consultant> findAllByConId(int ConId);
	@Transactional
	void deleteAllByConId(int id);

	Optional<Consultant> findByCId(String username);
}
