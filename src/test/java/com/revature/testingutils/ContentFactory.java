package com.revature.testingutils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.revature.entities.Content;

/**
 * This is a utility class meant to reduce the repetition caused by
 * creating Content instances throughout unit testing. This class 
 * provides a basic Content instance and it's relationship with a
 * Link object instance.
 */
public class ContentFactory {
/*
	//content field values
	public static final String title = "TestTitle",
							    format = "TestFormat",
							    description = "Test description",
							    url = "http://test.com";
	public static final Integer id = 117,
								moduleId = 1,
								linkId = 1;
	
	/**
	 * Returns a new instance of a content object with the default
	 * constant values provided in this class
	 * @return - new instance of a content object
	 */
	/*
	public static Content getContent () {
<<<<<<< HEAD
//		//generate link set
//		Set<Link> links = new HashSet<Link> ();
//		Link link = new Link (linkId, id, moduleId,"link-affiliation");
//		links.add(link);
//		
//		//generate content object
//		return new Content (id, title, format, description, url, links, 1L, 1L);
		return null;
=======
		//generate link set
		Set<Link> links = new HashSet<Link> ();
		Link link = new Link (linkId, id, moduleId);
		links.add(link);
		
		//generate content object
		return new Content (id, title, format, description, url, links, 1L, 1L);
>>>>>>> a98e74d42e3346aa3ad9d535465a61e396077418
	}
	*/
	
	/**
	 * Returns a list of modules meant to be related to the default link
	 * data.
	 * @return - List of module ids related to the sample content
	 */
	/*
	public static List<Integer> getModules () {
		List<Integer> modules = new ArrayList<Integer> ();
		modules.add(moduleId);
		return modules;
	}
	*/
}
