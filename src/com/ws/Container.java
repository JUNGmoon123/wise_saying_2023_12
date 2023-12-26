package com.ws;

import java.util.Scanner;

import com.ws.wiseSaying.service.WiseSayingService;

public class Container {

	public static WiseSayingService wiseSayingService;

	static {
		wiseSayingService = new WiseSayingService();
	}

	private static Scanner sc;

	// 공통적으로 사용되는 자원들을 모아두는 공간 초기화
	public static void init() {
		sc = new Scanner(System.in);
	}

	// 공통적으로 사용되는 자원들을 모아두는 공간 자원 해제
	public static void close() {
		sc.close();
	}

	public static Scanner getScanner() {
		return sc;
	}
}