package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}
	//This a stream of arguments that i set up to see if my method is working properly 
	public static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(
				Arguments.arguments(2,4,6,false),
				Arguments.arguments(1,7,8,false),
				Arguments.arguments(-2,-4,2,true));
				
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	//What my method will run through to see if its running correctly 
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}else {
			assertThatThrownBy(() ->

		    testDemo.addPositive(a, b))

		        .isInstanceOf(IllegalArgumentException.class);
		}
		
	}
	
	void assertThatTwoPositiveNumbersAreMultipliedCorrectly(int a, int b, int expected, boolean expectException) {
		
		if(!expectException) {
			assertThat(testDemo.multiplyPositive(a, b)).isEqualTo(expected);
		}else {
			assertThatThrownBy(() ->

		    testDemo.multiplyPositive(a, b))

		        .isInstanceOf(IllegalArgumentException.class);
		}
		
	}
	
	@Test
	void assertThatTwoPositiveNumbersAreAddedCorrectly() {
		
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);

		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
	}
	@Test
	void assertThatTwoPositiveNumbersAreMultipliedCorrectly() {
		
		assertThat(testDemo.multiplyPositive(4, 2)).isEqualTo(8);
		assertThat(testDemo.multiplyPositive(10, 3)).isEqualTo(30);

	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	
}
