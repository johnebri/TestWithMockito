package com.in28minutes.mockito.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class SomeBusinessMockAnnotationTest {
	
	@Mock
	DataService dataServiceMock;
	
	@InjectMocks
	SomeBusinessImpl businessImpl;

	@Test
	void testFindTheGreatestFromAddData() {		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24,15,3});
		assertEquals(24, businessImpl.findTheGreatestFromAllData());
	}
	
	@Test
	void testFindTheGreatestFromAddData_ForOneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
		assertEquals(15, businessImpl.findTheGreatestFromAllData());
	}
	
	@Test
	void testFindTheGreatestFromAddData_NoValues() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
		assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
	}

}
 