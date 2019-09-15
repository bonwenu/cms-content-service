package com.revature.controllers;

/**
 * For documentation on the controllers check out some documentation on swaggerhub:
 * https://app.swaggerhub.com/apis-docs/pacquito/CMS-Controllers/0.1
 */
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Module;
import com.revature.services.ModuleService;

@CrossOrigin(origins = "*", allowCredentials="true")
@RestController
@Transactional
@RequestMapping("/modules")
public class ModuleController {

	@Autowired
	ModuleService moduleService;
	
	@GetMapping
	public Set<Module> getAllModules() {
		return (Set<Module>) moduleService.getAllModules();
	}
	
	@GetMapping(value="{id}")
	public Module getModuleById(@PathVariable int id) {
		return moduleService.getModuleById(id);
	}
	
	@PostMapping
	public Module createModule(@RequestBody Module module) {
		return moduleService.createModule(module);
	}
	
	@DeleteMapping(value="{id}")
	public void deleteModule(@PathVariable int id) {
		Module module = moduleService.getModuleById(id);
		moduleService.deleteModule(module);
	}
	
	@GetMapping("/roots")
	public Set<Module> getAllModulesByRoot(){
		return (Set<Module>) moduleService.getAllModulesByRoot();
	}

	@GetMapping("/{id}/children")
    public Set<Module> getChildrenByModuleId(@PathVariable int id) {
        return (Set<Module>) moduleService.getChildrenByModuleId(id);
    }
	
	@DeleteMapping("/withcontent/{id}")
	public void deleteModuleWithContent(@PathVariable int id) {
		Module module = moduleService.getModuleById(id);
		moduleService.deleteModuleWithAllContent(module);
	}
	
	@DeleteMapping("/speccontent/{id}")
	public void deleteModuleWithSpecificContent(@PathVariable int id) {
		Module module = moduleService.getModuleById(id);
		moduleService.deleteModuleWithSpecificContent(module);
	}
}
