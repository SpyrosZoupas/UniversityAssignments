package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import json.JSONException;
import json.JSONObject;
import json.JSONParser;
import json.JSONValue;

public class TestParser
{

	@Test
	void testParser() throws JSONException, IOException
	{
		JSONValue value = JSONParser.parse("{ \"flag\" : true }");

		assertNotNull(value);

		assertTrue(value.isObject());
		assertFalse(value.isArray());
		assertFalse(value.isNumber());
		assertFalse(value.isBoolean());
		assertFalse(value.isString());
	}

	//tests getMember method
	@Test
	void testParseFile() throws FileNotFoundException, IOException, JSONException
	{
		JSONValue value = JSONParser.parseFile("example.json");

		assertTrue(value.isObject());
		JSONObject jsonObj = value.asObject();

		JSONValue assocVal = jsonObj.getMember("prop0");
		assertTrue(assocVal.isNumber());

		assocVal = jsonObj.getMember("prop1");
		assertTrue(assocVal.isString());

		assocVal = jsonObj.getMember("prop3");
		assertTrue(assocVal.isNumber());
		float floatVal = assocVal.asFloat();
		assertEquals(3.142f, floatVal);

		assocVal = jsonObj.getMember("prop4");
		assertTrue(assocVal.isBoolean());

		assocVal = jsonObj.getMember("prop6");
		assertTrue(assocVal.isNull());

		assocVal = jsonObj.getMember("prop7");
		assertTrue(assocVal.isObject());

		assocVal = jsonObj.getMember("array1");
		assertTrue(assocVal.isArray());
	}

	//Tests parseValue values exceptions
	@ParameterizedTest
	@ValueSource(strings =
	{ "", "{", "{\"error\"}", "{\"error\" : \"x\",}", "{\"error\" : \"x\"", "{\"error\" : x}", "{\"error\":}",
			"{\"error\" : noll}", "{\"error\": falze}", "{\"error\" : truq}", "{\"error\" : -}",
			"{\"error\" : [\"test\"}", "{\"error\" : [\"a\",\"b\",\"c\",]}", "{\"errorUnicode\" : \"\\g\"}",
			"{\"errorEndInput\" : false}]", "{\"UnicodeError\" : \"\\u5\"}", "{\"UnicodeError2\" : \"\\u555\"}" })
	void testParserException(String json) throws JSONException
	{
		assertThrows(JSONException.class, () -> JSONParser.parse(json));
	}
}
