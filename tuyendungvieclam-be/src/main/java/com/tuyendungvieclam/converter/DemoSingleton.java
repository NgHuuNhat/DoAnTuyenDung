package com.tuyendungvieclam.converter;

public final class DemoSingleton {

	private static final DemoSingleton INSTANCE = new DemoSingleton();

    private DemoSingleton() {
         
    }
 
    public static DemoSingleton getInstance() {
        return INSTANCE;
    }
    
    public static void main(String[] args) {
		DemoSingleton demoSingleton = getInstance();
	}
}
