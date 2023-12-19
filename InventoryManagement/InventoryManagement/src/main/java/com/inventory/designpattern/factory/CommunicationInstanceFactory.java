package com.inventory.designpattern.factory;

import com.inventory.designpattern.command.Communication;

// Implementing Lazy Factory Pattern
public class CommunicationInstanceFactory extends AbstractFactoryAPI{

	private static Communication comm;
	@Override
	public Communication getObject() {
		
		if(comm == null) {
			comm = new 	Communication();
		}
		return comm;
	}

}
