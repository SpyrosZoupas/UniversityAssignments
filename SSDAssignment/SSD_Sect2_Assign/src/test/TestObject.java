package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import json.JSONBoolean;
import json.JSONException;
import json.JSONFactory;
import json.JSONObject;
import json.JSONParser;
import json.JSONValue;

class TestObject

{
	JSONObject obj = JSONFactory.createObject();

	@Test
	void testIsObject()
	{
		assertFalse(obj.isNull());
		assertFalse(obj.isArray());
		assertFalse(obj.isBoolean());
		assertFalse(obj.isNumber());
		assertTrue(obj.isObject());
		assertFalse(obj.isString());
	}

	@Test
	void testEquals()
	{
		assertTrue(obj.equals(obj));
		assertFalse(obj.equals(null));
		assertFalse(obj.equals(1));
	}

	@Test
	void testCopy()
	{
		assertEquals(obj, obj.copy());
	}

	//tests addMember, hashCode,hasBooleanMember,hasMember,iterator,values and members methods
	@Test
	void testAddMember()
	{
		JSONBoolean trueFlag = JSONFactory.createBoolean(true);
		JSONBoolean falseFlag = JSONFactory.createBoolean(false);
		obj.addMember("trueflag", trueFlag);
		obj.addMember("falseflag", falseFlag);
		obj.addMember("string", "stringTest");
		obj.addMember("greeting", "hello");
		obj.addMember("long", 1);
		obj.addMember("flagfalse", false);
		obj.addMember("flagtrue", true);
		obj.addMember("null");
		obj.addMember("emptystring", "");
		assertEquals(obj.toString(),
				"{\"trueflag\":true,\"falseflag\":false,\"string\":\"stringTest\",\"greeting\":\"hello\",\"long\":1,\"flagfalse\":false,\"flagtrue\":true,\"null\":null,\"emptystring\":\"\"\"\"}");
		obj.addMember("double", 10d);
		obj.addMember("float", 20f);
		obj.addMember("object", JSONFactory.createObject());
		obj.addMember("array", JSONFactory.createArray());

		JSONObject objCopy = JSONFactory.createObject(obj);
		assertEquals(obj, objCopy);
		assertEquals(obj.hashCode(), objCopy.hashCode());

		assertEquals(obj.size(), 13);

		assertFalse(obj.hasBooleanMember("flagfalse"));
		assertTrue(obj.hasBooleanMember("flagtrue"));
		assertFalse(obj.hasBooleanMember(null));
		assertFalse(obj.hasBooleanMember("notavalidvalue"));
		assertFalse(obj.hasBooleanMember("double"));

		assertTrue(obj.hasMember("long"));
		assertFalse(obj.hasMember("example"));

		assertTrue(obj.iterator().hasNext());
		JSONObject objempty = JSONFactory.createObject();
		assertFalse(objempty.iterator().hasNext());
		assertEquals(obj.values().size(), 13);
		assertTrue(obj.members().contains("greeting"));
	}

	@Test
	void testAsObject() throws JSONException
	{
		assertEquals(obj, obj.asObject());

	}
}
