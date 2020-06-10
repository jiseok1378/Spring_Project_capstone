package kr.inhatc.spring.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.chat.entity.Room;
import kr.inhatc.spring.project.entity.Location;
import kr.inhatc.spring.project.repository.NormalRepository;

@Service
public class NormalServiceImpl implements NormalService{

	@Autowired
	NormalRepository normalRepository;

	@Override
	public List<Location> confirmerList(String area) {
		List<Location> list;
		if (area.equals("all")){
			list = normalRepository.findAllByOrderByIdDesc();
		} else {
			list = normalRepository.findByNameLike(area+"%");
		}

		//System.out.println("================> 크기 : " + list.size());
		//System.out.println(list.get(0));

		return list;
	}

	//	@Override
	//	public void saveUsers(Users user) {
	//		userRepository.save(user);
	//	}
	//
	//	@Override
	//	public Users userDetail(String id) {
	//		Optional<Users> optional = userRepository.findById(id);
	//		if(optional.isPresent()) {
	//			Users user = optional.get();
	//			return user;
	//		} else {
	//			throw new NullPointerException();
	//		}
	//	}
	//
	//	@Override
	//	public void userDelete(String id) {
	//		userRepository.deleteById(id);
	//	}
	//	
}
