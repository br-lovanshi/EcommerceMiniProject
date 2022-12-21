package com.masai.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class CalculatorTests {

	Calculator calculator = null;
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("It would run before all test cases");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("Would run before each test case..!");
		calculator = new Calculator();
	}
	
	@Test
	public void testAddIntegers() {
		//String msg = "Hello Hi";
		//assertEquals("Hello H", msg);
		//Calculator calculator = new Calculator();
		assertEquals(24, calculator.addIntegers(12, 12));
	}
	
	@RepeatedTest(5)
	public void testThisFiveTimes() {
		assertEquals(24, calculator.addIntegers(12, 12));
	}
	
	@Test
	@DisplayName("Just some dummy test cases")
	public void dummyTests() {
		assertEquals(12, 2*6);
		//assertFalse(null);
		//assertTrue(false);
		//assertThrows(null, null)
		//assertNotEquals(null, null);
		//assertNull(calculator);
		//assertNotNull(calculator);
	}
	
	@Test
	public void shouldThrowException() {
		Exception ex = assertThrows(ClassCastException.class, ()-> calculator.multiply(12, "A"));
		assertEquals("Please enter valid integers", ex.getMessage());
	}
	
	@Test
	public void assertAll() {
		String str1 = "abc";
		String str2 = "xyz";
		String str3 = "asd";
		
		Assertions.assertAll("nums",
				() -> assertEquals(str1, "abc"),
				() -> assertEquals(str2, "xyz")
		);
	}
	
	@Test
	public void testAssertNull() {
		String str1 = "abc";
		String str2 = null;
		assertNull(str2);
		assertNotNull(str1);
	}
	
	@Test
	@Disabled
	public void testNotRequiredAnymore() {
		//
		assertTrue(true);
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("Would run after each test case");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("Would run after all test cases");
	}
	
}
