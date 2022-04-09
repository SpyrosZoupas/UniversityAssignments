package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import json.JSONFactory;
import json.JSONString;

public class TestString
{
	JSONString string = JSONFactory.createString("test");
	JSONString emptyString = JSONFactory.createString("");
	JSONString nullString = JSONFactory.createString(null);

	@Test
	void testIsString()
	{
		System.out.print(nullString);
		assertFalse(string.isNull());
		assertFalse(string.isArray());
		assertFalse(string.isBoolean());
		assertFalse(string.isNumber());
		assertFalse(string.isObject());
		assertTrue(string.isString());
	}

	@Test
	void testEquals()
	{
		assertTrue(string.equals(JSONFactory.createString("test")));
		assertTrue(emptyString.equals(JSONFactory.createString("")));
		assertTrue(nullString.equals(emptyString));
		assertFalse(string.equals(null));
		assertFalse(string.equals(1));
		
	}

	@Test
	void testToString()
	{
		assertEquals(string.toString(), "\"test\"");
		assertEquals(emptyString.toString(), "\"\"");
	}

	@Test
	void testGetString()
	{
		assertEquals("test", string.getString());
	}

	@Test
	void encodeCharTest()
	{
		JSONString encodedCharString = JSONFactory.createString("\"\\\t\b\r\f\n/");
		assertEquals(encodedCharString.toString(), "\"\\\"\\\\\\t\\b\\r\\f\\n\\/\"");
	}
}
