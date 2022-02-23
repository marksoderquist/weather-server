package net.soderquist.mark.weather;

import java.util.ArrayList;
import java.util.List;

public class FlightCondition {

	enum Summary {
		GREAT,
		GOOD,
		FAIR,
		POOR,
		HOLD
	}

	enum Reason {
		HOT,
		WARM,
		COOL,
		COLD,
		BREEZY,
		WINDY,
		BUMPY,
		GUSTY,
		RAINY,
		DAWN,
		DUSK,
		DARK
	}

	private Summary summary = Summary.GREAT;

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
		summary = Summary.GREAT;
	}

}
