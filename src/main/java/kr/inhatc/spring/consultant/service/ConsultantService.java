package kr.inhatc.spring.consultant.service;

import java.util.List;

import kr.inhatc.spring.consultant.entity.Consultant;
public interface ConsultantService {

	List<Consultant> consultantList();

	void saveConsultant(Consultant user);

	Consultant consultantDetail(int id);

	void consultantDelete(int id);

}
