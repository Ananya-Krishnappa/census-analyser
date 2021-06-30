/**
 * Purpose:Indian states census analyser problem
 * @author Ananya K
 * @version 1.0
 * @since 30/06/2021
 * 
 */
package com.bridgelabz.censusanlayzer.service.impl;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bridgelabz.censusanlayzer.exception.CsvCustomException;
import com.bridgelabz.censusanlayzer.service.IStateCensusAnalyser;
import com.bridgelabz.censusanlayzer.type.ExceptionType;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser implements IStateCensusAnalyser {
	private static final Logger LOG = LogManager.getLogger(StateCensusAnalyser.class);

	public StateCensusAnalyser() {

	}

	/**
	 * Function to load the census data from the path
	 */
	@Override
	public <T> List<T> loadCensusData(String filePathName, T className) throws CsvCustomException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(filePathName));
			CsvToBean<T> csvToBean = new CsvToBeanBuilder(reader).withType((Class) className)
					.withIgnoreLeadingWhiteSpace(true).build();
			Iterator<T> iterator = csvToBean.iterator();
			List<T> censusList = new ArrayList<T>();
			while (iterator.hasNext()) {
				censusList.add(iterator.next());
			}
			for (T e : censusList) {
				LOG.debug(e);
			}
			return censusList;
		} catch (NoSuchFileException e) {
			LOG.debug("File not found in the specified path");
			throw new CsvCustomException(ExceptionType.FILE_NOT_FOUND, "File not found in the specified path");
		} catch (IOException e) {
			throw new CsvCustomException(e.getMessage());
		} catch (RuntimeException e) {
			if (e.getCause().getMessage().contains("Number of data fields does not match number of headers")) {
				throw new CsvCustomException(ExceptionType.FILE_FORMAT_NOT_SUPPORTED,
						"Number of data fields does not match number of headers", e.getCause());
			}
			LOG.debug(e.getCause().getMessage());
			throw new CsvCustomException(ExceptionType.NULL_DATA_FOUND,
					"Delimiter not correct or file type not supported or header not found or binding data issue",
					e.getCause());
		} catch (Exception e) {
			throw new CsvCustomException(e.getMessage());
		}
	}

	/**
	 * Function to count the number of records
	 */
	@Override
	public <T> int count(String filePathName, T className) throws CsvCustomException {
		List<T> censusList = loadCensusData(filePathName, className);
		LOG.debug("Number of records " + censusList.size());
		return censusList.size();
	}
}
