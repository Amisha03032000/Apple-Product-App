package com.inventory.designpattern.state;

import com.inventory.designpattern.state.State;

public abstract class StateAPI {
	
	/**
	 * Performs the action of sending an alert to the server and updating
	 * @param state
	 */
	public abstract void action(State state, int stock);
	
}
