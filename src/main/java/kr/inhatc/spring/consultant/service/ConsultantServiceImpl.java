package kr.inhatc.spring.consultant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.consultant.entity.Consultant;
import kr.inhatc.spring.consultant.repository.ConsultantRepository;

@Service
public class ConsultantServiceImpl implements ConsultantService{
	@Autowired
	private ConsultantRepository consultantRepository;
	@Override
	public List<Consultant> consultantList() {
		// TODO Auto-generated method stub
		List<Consultant> list = consultantRepository.findAllByOrderByIdDesc();
		return list;
	}
	@Override
	public void saveConsultant(Consultant user) {
		// TODO Auto-generated method stub
		consultantRepository.save(user);
	}
	@Override
	public Consultant consultantDetail(int ConId) {
		// TODO Auto-generated method stub
		
		Optional<Consultant> optional = consultantRepository.findAllByConId(ConId);
		if(optional.isPresent()) {
			Consultant user = optional.get();
			return user;
		}
		else {
			throw new NullPointerException();
		}
	}
	@Override
	public void consultantDelete(int id) {
		// TODO Auto-generated method stub
		consultantRepository.deleteAllByConId(id);
	}

}
