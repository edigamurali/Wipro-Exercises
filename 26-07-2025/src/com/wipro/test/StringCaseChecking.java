package com.wipro.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCaseChecking 

{
	@ParameterizedTest
	@ValueSource(strings={"murali","RAMU","Mahitha"})
	void caseChecking(String names)
	{
		assertTrue(isLowerCase(names));
	}

	private boolean isLowerCase(String names) 
	{
		return names.equals(names.toLowerCase());
		
	}
}
