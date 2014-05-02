package gui.src;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MediatorTest {
	

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMessage() {
		Mediator.setMessage("hello");
		assertEquals("hello",Mediator.getMessage());
	}

	@Test
	public void testGetEmail() {
		Mediator.setEmail("email");
		assertEquals("email",Mediator.getEmail());
	}

}
