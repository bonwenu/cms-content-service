
package com.revature.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netflix.ribbon.proxy.annotation.Content;
import com.revature.entities.Link;

@Repository
public interface LinkRepository extends CrudRepository<Link,Integer> {
	
	//Gets links for a content
	Set<Link> findByContentId(int contentId);
	
	//Gets links for a module
	Set<Link> findByModuleId(int moduleId);
	
	//sends back links for Modules given
	Set<Link> findByModuleIdIn(List<Integer> modules);
	
	Link findById(int linkId);
	

	

}