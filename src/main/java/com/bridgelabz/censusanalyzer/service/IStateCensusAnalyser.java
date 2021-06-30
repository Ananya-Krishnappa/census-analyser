package com.bridgelabz.censusanalyzer.service;

import java.util.List;

import com.bridgelabz.censusanalyzer.exception.CsvCustomException;

public interface IStateCensusAnalyser {
	public <T> List<T> loadCensusData(String filePathName, T className) throws CsvCustomException;

	public <T> int count(String filePathName, T className) throws CsvCustomException;
}
