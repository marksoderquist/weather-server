package net.soderquist.mark.weather;

import java.util.HashSet;
import java.util.Set;

public class Flying {

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
		DARK
	}

	private Condition condition = Condition.GREAT;

	private Set<Reason> reasons = new HashSet<>();

	public Condition getCondition() {
		return condition;
	}

	public void setCondition( Condition condition ) {
		this.condition = condition;
	}

	public Set<Reason> getReasons() {
		return reasons;
	}

	public void setReasons( Set<Reason> reasons ) {
		this.reasons = reasons;
	}

}
