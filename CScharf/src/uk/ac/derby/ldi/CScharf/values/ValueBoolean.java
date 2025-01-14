package uk.ac.derby.ldi.CScharf.values;

import uk.ac.derby.ldi.CScharf.interpreter.ExceptionSemantic;

public class ValueBoolean extends ValueAbstract {

	private boolean internalValue;
	
	public ValueBoolean(boolean b) {
		internalValue = b;
	}
	
	public ValueBoolean(int val) {
		if (val < 0 || val > 1) throw new ExceptionSemantic("Could not cast " + val + " to a boolean.");
		internalValue = val == 1 ? true : false;
	}

	public String getName() {
		return "boolean";
	}
	
	/** Convert this to a primitive boolean. */
	public boolean booleanValue() {
		return internalValue;
	}
	
	/** Convert this to a primitive string. */
	public String stringValue() {
		return (internalValue) ? "true" : "false";
	}
	
	public Value or(Value v) {
		return new ValueBoolean(internalValue || v.booleanValue());
	}

	public Value and(Value v) {
		return new ValueBoolean(internalValue && v.booleanValue());
	}

	public Value not() {
		return new ValueBoolean(!internalValue);
	}

	public int compare(Value v) {
		if (internalValue == v.booleanValue())
			return 0;
		else if (internalValue)
			return 1;
		else
			return -1;
	}
	
	public String toString() {
		return "" + internalValue;
	}
}
