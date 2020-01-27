package com.in28minutes.mockito.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SomeBusinessMockTest {

	@Test
	void testFindTheGreatestFromAddData() {
		DataService dataServiceMock = mock(DataService.class);
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24,15,3});
		
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(24, result);
	}
	
	@Test
	void testFindTheGreatestFromAddData_ForOneValue() {
		DataService dataServiceMock = mock(DataService.class);
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
		
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(15, result);
	}

}
 