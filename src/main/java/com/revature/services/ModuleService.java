package com.revature.services;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import com.revature.entities.Module;

public interface ModuleService {

	public Set<Module> getAllModules();
	
	public Module getModuleById(int id);
	
	public Module createModule(Module module);
	
	public double getAverageByModuleIds(ArrayList<Integer> ids);

	
}
