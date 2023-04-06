package com.prospecta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prospecta.model.Entries;
import com.prospecta.repo.EntriesRepo;

@Service
public class EntriesServiceImpl implements EntriesService {

	@Autowired
	private EntriesRepo eRepo;
	
	@Override
	public String saveData(Entries entries) {
		
		eRepo.save(entries);
		
		return "Data added";
	}

}
