package com.revature.JSONEntities;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.revature.JSONEntities.JSONModule;
import com.revature.entities.Link;
import com.revature.entities.Module;
import com.revature.entities.ReqLink;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class JSONModuleTest {

	// toString Test
	@Test
	public void testToString() {
		assertTrue(new JSONModule().toString() instanceof String);
	}

	// Constructor Tests
	@Test
	public void testContent() {
		JSONModule one = new JSONModule(1, "b", 1, null, null, null, null);
		assertTrue(one instanceof JSONModule);
		JSONModule two = new JSONModule();
		assertTrue(one != two);
	}

	// Hash and Equals test with EqualsVerifier
	/**
	 * EqualsVerifier will throw an AssertionError if there are any issues with its
	 * utilization. The suppression for non final fields is for the error
	 * "Mutability: equals depends on mutable field". It is generally not
	 * recommended to use this approach but the JSONModule class itself or its
	 * fields would have to be modified with final to properly address this.
	 */
	@Test
	public void equalsTest() {
		EqualsVerifier.forClass(JSONModule.class)
				.withPrefabValues(Link.class, new Link(1, null, null, "different"),
						new Link(2, null, null, "affiliations"))
				.withPrefabValues(ReqLink.class, new ReqLink(1, null, null, "different"),
						new ReqLink(2, null, null, "affiliations"))
				.withPrefabValues(Module.class, new Module(1, "Java", 56890, null, null, null, null),
						new Module(2, "C#", 67953, null, null, null, null))
				.usingGetClass().suppress(Warning.NONFINAL_FIELDS).verify();
	}
}
