package com.bridgelabz.censusanlayzer.dto;

import com.opencsv.bean.CsvBindByName;

public class CsvStateCensus {

	public CsvStateCensus() {
		super();
	}

	public CsvStateCensus(String state, Long population, Double areaInSqKm, Double densityPerSqKm) {
		super();
		State = state;
		Population = population;
		AreaInSqKm = areaInSqKm;
		DensityPerSqKm = densityPerSqKm;
	}

	@CsvBindByName(column = "State")
	private String State;

	@CsvBindByName(column = "Population")
	private Long Population;

	@CsvBindByName(column = "AreaInSqKm")
	private Double AreaInSqKm;

	@CsvBindByName(column = "DensityPerSqKm")
	private Double DensityPerSqKm;

	@Override
	public String toString() {
		return "CsvStateCensus [State=" + State + ", Population=" + Population + ", AreaInSqKm=" + AreaInSqKm
				+ ", DensityPerSqKm=" + DensityPerSqKm + "]";
	}

}
