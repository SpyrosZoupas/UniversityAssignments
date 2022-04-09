package test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses(
{ NullTest.class, TestArray.class, TestParser.class, TestString.class, TestNumber.class, TestBoolean.class,TestObject.class,TestValue.class })
public class AllTests
{

}
