package net.soderquist.mark.weather;

import java.util.ArrayList;
import java.util.List;

public class FlightCondition {

	enum Summary {
		FANTASTIC,
		GOOD,
		FAIR,
		POOR,
		HORRIBLE
	}

	enum Reason {
		HOT,
		WARM,
		COOL,
		COLD,
		BREEZY,
		WINDY,
		GUSTY,
		RAINY,
		TWILIGHT,
		DARK
	}

	private Summary summary = Summary.FANTASTIC;

	private List<Reason> reasons = new ArrayList<>();

	public Summary getSummary() {
		return summary;
	}

	public void setSummary( Summary summary ) {
		this.summary = summary;
	}

	public List<Reason> getReasons() {
		return reasons;
	}

	public void reset() {
		reasons.clear();
		summary = Summary.FANTASTIC;
	}

}
