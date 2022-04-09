package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import json.JSONFactory;
import json.JSONNull;

class NullTest
{
	JSONNull value = JSONFactory.createNull();

	@Test
	void testIsNull()
	{
		assertTrue(value.isNull());
		assertFalse(value.isArray());
		assertFalse(value.isBoolean());
		assertFalse(value.isNumber());
		assertFalse(value.isObject());
		assertFalse(value.isString());
	}

	@Test
	void testEquals()
	{
		assertTrue(value.equals(JSONFactory.createNull()));
		assertFalse(value.equals(null));
	}

	@Test
	void testToString()
	{
		assertEquals("null", value.toString());
	}

	@Test
	void testHashCode()
	{
		assertEquals(953, value.hashCode());
	}

	@Test
	void testCopy()
	{
		assertEquals(value.copy(), value);

	}
}
