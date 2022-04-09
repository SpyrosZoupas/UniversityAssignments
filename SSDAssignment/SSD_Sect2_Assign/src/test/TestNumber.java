package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import json.JSONBoolean;
import json.JSONException;
import json.JSONFactory;
import json.JSONNumber;

public class TestNumber
{
	JSONNumber value = JSONFactory.createNumber(1);
	JSONNumber valueDouble = JSONFactory.createNumber((1.7976931348623157 * Math.pow(10, 308)));
	JSONNumber valueFloat = JSONFactory.createNumber(1.1f);
	JSONNumber valueMaxLong = JSONFactory.createNumber(9223372036854775807L);
	JSONNumber valueMinLong = JSONFactory.createNumber(-9223372036854775808L);

	JSONNumber valueZero = JSONFactory.createNumber(0);
	JSONNumber valueZeroDouble = JSONFactory.createNumber(0d);
	JSONNumber valueZeroFloat = JSONFactory.createNumber(0f);
	JSONNumber valueZeroLong = JSONFactory.createNumber(0L);

	JSONBoolean valueBool = JSONFactory.createBoolean(true);

	JSONNumber[] jsonNumbers =
		{ value, valueFloat, valueMaxLong, valueDouble };
	Double[] testValues =
	{ (double) 1, (double) 1.1f, (double) 9223372036854775807L, (1.7976931348623157 * Math.pow(10, 308)) };
	
	@Test
	void testIsNumber()
	{
		assertFalse(value.isNull());
		assertFalse(value.isArray());
		assertFalse(value.isBoolean());
		assertTrue(value.isNumber());
		assertFalse(value.isObject());
		assertFalse(value.isString());
	}

	@Test
	void testEquals()
	{
		assertTrue(value.equals(JSONFactory.createNumber(1)));
		assertFalse(value.equals(null));
		assertFalse(value.equals("test"));
	}

	@Test
	void testHashCode()
	{
		assertEquals(valueZero.hashCode(), valueZeroLong.hashCode());

	}

	@Test
	void testToString()
	{
		assertEquals("1", value.toString());

	}

	@Test
	void testGetNumber()
	{
		Integer num = (Integer) value.getNumber();
		assertEquals(1, num);
	}

	@Test
	void testByteException() throws JSONException
	{
		assertEquals(value.asByte(), 1);

		JSONNumber valueMaxByte = JSONFactory.createNumber(1000);
		assertTrue(valueMaxByte.isNumber());
		assertThrows(JSONException.class, () -> valueMaxByte.asByte());

		JSONNumber valueMinByte = JSONFactory.createNumber(-1000);
		assertThrows(JSONException.class, () -> valueMinByte.asByte());

		assertThrows(JSONException.class, () -> valueFloat.asByte());

		assertThrows(JSONException.class, () -> valueBool.asByte());
	}

	@Test
	void testShortException() throws JSONException
	{
		assertEquals(value.asShort(), 1);

		JSONNumber valueMaxShort = JSONFactory.createNumber(1000000);
		assertThrows(JSONException.class, () -> valueMaxShort.asShort());

		JSONNumber valueMinShort = JSONFactory.createNumber(-1000000);
		assertThrows(JSONException.class, () -> valueMinShort.asShort());

		assertThrows(JSONException.class, () -> valueFloat.asShort());

		assertThrows(JSONException.class, () -> valueBool.asShort());
	}

	@Test
	void testIntegerException() throws JSONException
	{
		assertEquals(value.asInteger(), 1);

		assertThrows(JSONException.class, () -> valueFloat.asInteger());

		assertThrows(JSONException.class, () -> valueBool.asInteger());

	}

	@Test
	void testLongException() throws JSONException
	{
		assertEquals(valueMaxLong.asLong(), 9223372036854775807L);

		assertEquals(value.asLong(), 1);

		assertThrows(JSONException.class, () -> valueFloat.asLong());

		assertThrows(JSONException.class, () -> valueBool.asLong());
	}

	

	@RepeatedTest(value = 3)
	void testFloatExceptionR(RepetitionInfo repetitioninfo) throws JSONException
	{
		assertEquals(jsonNumbers[repetitioninfo.getCurrentRepetition() - 1].asFloat(),
				testValues[repetitioninfo.getCurrentRepetition() - 1]);

		assertThrows(JSONException.class, () -> valueBool.asFloat());

	}

	@RepeatedTest(value = 4)
	void testDoubleException(RepetitionInfo repetitioninfo) throws JSONException
	{
		assertEquals(jsonNumbers[repetitioninfo.getCurrentRepetition() - 1].asDouble(),
				testValues[repetitioninfo.getCurrentRepetition() - 1]);

		assertThrows(JSONException.class, () -> valueBool.asDouble());
	}
}
