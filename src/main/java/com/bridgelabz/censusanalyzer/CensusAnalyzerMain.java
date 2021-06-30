package com.bridgelabz.censusanalyzer;

import com.bridgelabz.censusanlayzer.dto.CsvStateCensus;
import com.bridgelabz.censusanlayzer.exception.CsvCustomException;
import com.bridgelabz.censusanlayzer.service.IStateCensusAnalyser;
import com.bridgelabz.censusanlayzer.service.impl.StateCensusAnalyser;

public class CensusAnalyzerMain {
	private final static String CSV_LOCATION = "src/main/resources/StateCensusData.csv";

	public static void main(String[] args) throws CsvCustomException {
		IStateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
		censusAnalyser.loadCensusData(CSV_LOCATION, CsvStateCensus.class);
		censusAnalyser.count(CSV_LOCATION, CsvStateCensus.class);
	}
}
