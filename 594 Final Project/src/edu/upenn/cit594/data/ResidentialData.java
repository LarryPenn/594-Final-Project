package edu.upenn.cit594.data;

public class ResidentialData {
	private Double totalResidentialMarketValue;
	private Integer numberOfResidencies;
	
	private ResidentialData() {
		this.totalResidentialMarketValue = null;
		this.numberOfResidencies = null;
	}
	
	public void addResidentialMarketValue(Double marketValue) {
		totalResidentialMarketValue++;
	}
	
	public void addResidency() {
		if (numberOfResidencies == null) {
			numberOfResidencies = 1;
		} else {
			numberOfResidencies++;
		}
	}
	
	public Double getTotalResidentialMarketValue() {
		return totalResidentialMarketValue;
	}
	
	public Integer getNumberOfResidencies() {
		return numberOfResidencies;
	}
}
