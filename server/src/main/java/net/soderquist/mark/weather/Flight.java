package net.soderquist.mark.weather;

import java.util.ArrayList;
import java.util.List;

public class Flight {

	enum Condition {
		GREAT,
		GOOD,
		FAIR,
		POOR,
		BAD
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

	private Condition condition = Condition.GREAT;

	private List<Reason> reasons = new ArrayList<>();

	public Condition getCondition() {
		return condition;
	}

	public void setCondition( Condition condition ) {
		this.condition = condition;
	}

	public List<Reason> getReasons() {
		return reasons;
	}

	public void reset() {
		condition = Flight.Condition.GREAT;
		reasons.clear();
	}

}
