package com.ws;

public class Main {
	public static void main(String[] args) {

		Container.init();

		new App().run();

		Container.getScanner().close();
	}
}
