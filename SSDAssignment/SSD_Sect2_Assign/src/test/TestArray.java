package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import json.JSONArray;
import json.JSONException;
import json.JSONFactory;
import json.JSONNumber;

public class TestArray
{
	JSONArray array = JSONFactory.createArray();

	@Test
	void testIsArray()
	{
		assertFalse(array.isNull());
		assertTrue(array.isArray());
		assertFalse(array.isBoolean());
		assertFalse(array.isNumber());
		assertFalse(array.isObject());
		assertFalse(array.isString());
	}

	@Test
	void testArrayEquals()
	{
		assertTrue(array.equals(JSONFactory.createArray()));
		assertFalse(array.equals(null));
		assertFalse(array.equals(JSONFactory.createNumber(1)));

	}

	@Test
	void testArrayCopy() throws JSONException
	{
		assertEquals(array, array.copy());
		assertEquals(array, array.asArray());
	}

	@Test
	void testAddValue()
	{
		array.addValue(1);
		array.addValue(JSONFactory.createObject());
		array.addValue(JSONFactory.createArray());
		array.addValue("test");
		array.addValue(10.10d);
		array.addValue(20.20f);
		array.addValue(10);
		array.addValue(2147483648L);
		array.addValue(true);
		array.addValue(false);
		array.addValue();

		JSONArray arrayCopy = JSONFactory.createArray(array);
		assertEquals(array, arrayCopy);
	}

	@Test
	void testArrayIterator()
	{
		array.addValue("firstValue");
		assertTrue(array.iterator().hasNext());
		JSONArray emptyArray = JSONFactory.createArray();
		assertFalse(emptyArray.iterator().hasNext());
	}

	@Test
	void testToString()
	{
		array.addValue(5);
		array.addValue(6);
		assertEquals(array.toString(), "[5,6]");

		JSONNumber number = JSONFactory.createNumber(5);
		assertEquals(array.get(0), number);
	}

	@Test
	void testArrayInitialSize()
	{
		JSONArray arrayInitialSize = JSONFactory.createArray(1);
	}
}
