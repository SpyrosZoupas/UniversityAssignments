package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import json.JSONBoolean;
import json.JSONFactory;

public class TestBoolean
{

	JSONBoolean valuetrue = JSONFactory.createBoolean(true);
	JSONBoolean valuefalse = JSONFactory.createBoolean(false);

	@Test
	void testIsBoolean()
	{
		assertFalse(valuetrue.isNull());
		assertFalse(valuetrue.isArray());
		assertTrue(valuetrue.isBoolean());
		assertFalse(valuetrue.isNumber());
		assertFalse(valuetrue.isObject());
		assertFalse(valuetrue.isString());
	}

	@Test
	void testEquals()
	{
		assertTrue(valuetrue.equals(JSONFactory.createBoolean(true)));
		assertFalse(valuetrue.equals(JSONFactory.createBoolean(false)));
	}

	@Test
	void testHashCode()
	{
		assertEquals(1231, valuetrue.hashCode());
		assertEquals(1237, valuefalse.hashCode());
	}

	@Test
	void testAsBoolean()
	{
		assertEquals(true, valuetrue.asBoolean());
		assertEquals(false, valuefalse.asBoolean());
	}

	@Test
	void testToString()
	{
		assertEquals("true", valuetrue.toString());
		assertEquals("false", valuefalse.toString());
	}

}
