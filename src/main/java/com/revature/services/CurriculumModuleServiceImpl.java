package com.revature.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.CurriculumModule;
import com.revature.repositories.CurriculumModuleRepository;
import com.revature.util.LogException;

@Service
public class CurriculumModuleServiceImpl implements CurriculumModuleService  {

	@Autowired
	CurriculumModuleRepository curriculumModuleRepository;
	
	@Override
	@LogException
	public CurriculumModule createCurriculumModule(CurriculumModule curriculumModule) {
		return curriculumModuleRepository.save(curriculumModule);
	}

	@Override
	@LogException
	public Set<CurriculumModule> getAllCurriculumModules() {
		Set<CurriculumModule> curriculumModules = new HashSet<>();
		curriculumModuleRepository.findAll().forEach(curriculumModules::add);
		return curriculumModules;
	}

	@Override
	public CurriculumModule getCurriculumModuleById(int id) {
		CurriculumModule curriculumModule = curriculumModuleRepository.findById(id);
		return curriculumModule;
	}


	@Override
	public Iterable<CurriculumModule> updateCurriculumModule(Set<CurriculumModule> curriculumModule) {
		return curriculumModuleRepository.saveAll(curriculumModule);
	}

	@Override
	public void deleteCurriculumModule(CurriculumModule curriculumModule) {
		if(curriculumModule != null) {
			curriculumModuleRepository.delete(curriculumModule);
		}
	}

	
}
