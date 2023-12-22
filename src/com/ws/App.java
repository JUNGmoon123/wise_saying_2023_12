package com.ws;

import com.ws.system.controller.SystemController;
import com.ws.wiseSaying.controller.WiseSayingController;

public class App {
	byte system_status = 1;		// while문 빠져나오기 위함.
	
	public App() {
	}

	public void run() {
		System.out.println("== 명언 앱 실행 ==");

		SystemController systemController = new SystemController();					//Controller에 접근하기위한 리모콘생성
		WiseSayingController wiseSayingController = new WiseSayingController();		//wiseSayingController에 접근하기위한 리모콘생성


		while (system_status == 1) {			// 반복문 무한루프 설정.
			System.out.print("명령어 ) ");
			String cmd = Container.getScanner().nextLine().trim();		//사용자가 원하는 정보입력하면 container에 저장하고 cmd가 가리킨다.		
			Rq rq = new Rq(cmd);			// Rq에 cmd가 가리키는 정보주소를 넘겨주고 Rq에서 정보를 가공한다.
											//Rq타입형의 rq가 cmd객체주소를 가리킨다.
			
			switch (rq.getActionCode()) {		
			case "종료":
				systemController.exit();
				system_status = 0;			//'종료' 입력시 반복문 무한루프 빠져나오기.
				break;
			case "등록":
				wiseSayingController.write();		//'등록' 입력시 controller의 write()메소드가 실행된다.
				break;
			case "목록":
				wiseSayingController.list();		//'목록' 입력시 controller의 lsit()메소드가 실행된다.
				break;
			case "삭제":
				wiseSayingController.remove(rq);		//'삭제' 입력시 controller의 remove()메소드가 실행된다.
				break;
			case "수정":
				wiseSayingController.modify(rq);		//'수정' 입력시 controller의 modify()메소드가 실행된다.
				break;
			default:
				System.out.println("존재하지 않는 명령어입니다");		//스위치문에 없는 명령어 입력시 출력.
				break;
			}
		}

	}
}