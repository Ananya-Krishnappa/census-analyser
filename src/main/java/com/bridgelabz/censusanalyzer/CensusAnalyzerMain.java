package com.bridgelabz.censusanalyzer;

import com.bridgelabz.censusanalyzer.dto.CsvStateCensus;
import com.bridgelabz.censusanalyzer.exception.CsvCustomException;
import com.bridgelabz.censusanalyzer.service.IStateCensusAnalyser;
import com.bridgelabz.censusanalyzer.service.impl.StateCensusAnalyser;

public class CensusAnalyzerMain {
	private final static String CSV_LOCATION = "src/main/resources/StateCensusData.csv";

	public static void main(String[] args) throws CsvCustomException {
		IStateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
		censusAnalyser.loadCensusData(CSV_LOCATION, CsvStateCensus.class);
		censusAnalyser.count(CSV_LOCATION, CsvStateCensus.class);
	}
}
