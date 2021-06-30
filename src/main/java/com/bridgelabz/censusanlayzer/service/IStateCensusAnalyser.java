package com.bridgelabz.censusanlayzer.service;

import java.util.List;

import com.bridgelabz.censusanlayzer.exception.CsvCustomException;

public interface IStateCensusAnalyser {
	public <T> List<T> loadCensusData(String filePathName, T className) throws CsvCustomException;

	public <T> int count(String filePathName, T className) throws CsvCustomException;
}
