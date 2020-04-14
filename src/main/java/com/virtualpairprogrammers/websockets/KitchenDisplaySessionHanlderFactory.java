package com.virtualpairprogrammers.websockets;

public class KitchenDisplaySessionHanlderFactory {

	private static KitchenDisplaySessionHandler hanlder;
	
	public static KitchenDisplaySessionHandler getHandler() {
		
	if(hanlder == null) hanlder = new KitchenDisplaySessionHandler();
	
	return hanlder;
		
	}
	
	
	
	
	
	
	
	
	
	
}
