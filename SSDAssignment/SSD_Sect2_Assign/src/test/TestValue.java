package test;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import json.JSONException;
import json.JSONFactory;
import json.JSONNumber;

public class TestValue
{
	@Test
	void testExceptions() throws JSONException
	{
		JSONNumber number = JSONFactory.createNumber(1);
		assertThrows(JSONException.class, () -> number.asString());
		assertThrows(JSONException.class, () -> number.asObject());
		assertThrows(JSONException.class, () -> number.asArray());
		assertThrows(JSONException.class, () -> number.asBoolean());
	}
}
