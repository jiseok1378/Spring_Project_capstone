package kr.inhatc.spring.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.project.entity.Location;

@Repository
public interface NormalRepository extends CrudRepository<Location, String>{

	List<Location> findAllByOrderByIdDesc();

	List<Location> findByNameLike(String area);

}
