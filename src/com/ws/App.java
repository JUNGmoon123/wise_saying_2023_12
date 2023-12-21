package com.ws;

import com.ws.system.controller.SystemController;
import com.ws.wiseSaying.controller.WiseSayingController;

public class App {
	byte system_status = 1;
	//while문 빠져나오기 위함.
	public App() {

	}

	public void run() {
		System.out.println("== 명언 앱 실행 ==");

		SystemController systemController = new SystemController();
		WiseSayingController wiseSayingController = new WiseSayingController();
		// 메인에서 sc받은걸 WiseSayingController에 인자로 또 넘겨줌, 생성자에 바로 넘겨줘서
		// 생성자에 값을 채워준다.

		while (system_status == 1) {
			System.out.print("명령어 ) ");
			String cmd = Container.getScanner().nextLine().trim();
			Rq rq = new Rq(cmd);

			switch (rq.getActionCode()) {
			case "종료":
				systemController.exit();
				system_status = 0;
				break;
			case "등록":
				wiseSayingController.write();
				break;
			case "목록":
				wiseSayingController.list();
				break;
			case "삭제":
				wiseSayingController.remove(rq);
				break;
			default:
				System.out.println("존재하지 않는 명령어입니다");
				break;
			}
		}

	}
}