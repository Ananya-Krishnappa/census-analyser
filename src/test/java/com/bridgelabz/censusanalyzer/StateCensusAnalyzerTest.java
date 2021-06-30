package com.bridgelabz.censusanalyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bridgelabz.censusanalyzer.dto.CsvStateCensus;
import com.bridgelabz.censusanalyzer.exception.CsvCustomException;
import com.bridgelabz.censusanalyzer.service.IStateCensusAnalyser;
import com.bridgelabz.censusanalyzer.service.impl.StateCensusAnalyser;

public class StateCensusAnalyzerTest {

	private final static String CSV_LOCATION = "src/main/resources/StateCensusData.csv";
	private final static String CSV_WRONG_LOCATION = "src/test/resources/StateCensusData1.csv";
	private final static String WRONG_FILE_TYPE = "src/test/resources/StateCensusData.json";
	private final static String INCORRECT_DELIMITER = "src/test/resources/StateCensusData_incorrectDelimiter.csv";
	private final static String INCORRECT_HEADER = "src/test/resources/StateCensusData_incorrectHeader.csv";
	private static IStateCensusAnalyser censusAnalyser;

	@BeforeAll
	public static void initialize() {
		censusAnalyser = new StateCensusAnalyser();
	}

	@Test
	public void givenNumberOfRecords_ChecksWhetherMatchesOrNot() throws CsvCustomException {
		int checkNumberOfRecords = censusAnalyser.count(CSV_LOCATION, CsvStateCensus.class);
		assertEquals(29, checkNumberOfRecords);
	}

	@Test
	public void givenWrongFileName_ShouldThrowNoSuchFileException() {
		Exception exception = assertThrows(CsvCustomException.class, () -> {
			censusAnalyser.loadCensusData(CSV_WRONG_LOCATION, CsvStateCensus.class);
		});
		String expectedMessage = "File not found in the specified path";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void givenWrongFileType_ShouldThrowRunTimeException() {
		Exception exception = assertThrows(CsvCustomException.class, () -> {
			censusAnalyser.loadCensusData(WRONG_FILE_TYPE, CsvStateCensus.class);
		});
		String expectedMessage = "Number of data fields does not match number of headers";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void givenWrongDelimer_ShouldThrowRunTimeException() {
		Exception exception = assertThrows(CsvCustomException.class, () -> {
			censusAnalyser.loadCensusData(INCORRECT_DELIMITER, CsvStateCensus.class);
		});
		String expectedMessage = "Number of data fields does not match number of headers";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void givenWrongheaders_ShouldThrowRunTimeException() {
		Exception exception = assertThrows(CsvCustomException.class, () -> {
			censusAnalyser.loadCensusData(INCORRECT_HEADER, CsvStateCensus.class);
		});
		String expectedMessage = "Number of data fields does not match number of headers";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
}
