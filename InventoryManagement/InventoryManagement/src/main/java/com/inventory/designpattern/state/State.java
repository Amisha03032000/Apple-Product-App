package com.inventory.designpattern.state;

public class State {

	private StateAPI state;

	public State() {
		state = null;
	}	
	
	public StateAPI getState() {
		return state;
	}

	public void setState(StateAPI state) {
		this.state = state;
	}

	
}
