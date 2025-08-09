package com.wipro.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
//@SelectPackages("com.wipro.test")
@SelectClasses({CheckString.class,StringNullCheck.class,StringCaseChecking.class})
public class TestingAll 
{
	
}
