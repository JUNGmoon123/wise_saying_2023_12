package com.ws;

import com.ws.system.controller.SystemController;
import com.ws.wiseSaying.controller.WiseSayingController;

public class App {

	public App() {

	}

	public void run() {
		System.out.println("== 명언 앱 실행 ==");

		SystemController systemController = new SystemController();
		WiseSayingController wiseSayingController = new WiseSayingController();
		// 메인에서 sc받은걸 WiseSayingController에 인자로 또 넘겨줌, 생성자에 바로 넘겨줘서
		// 생성자에 값을 채워준다.

		while (true) {
			System.out.print("명령어 ) ");
			String cmd = Container.getScanner().nextLine().trim();

			if (cmd.equals("종료")) {
				systemController.exit();
				break;
			} else if (cmd.equals("등록")) {

				wiseSayingController.write();

			} else if (cmd.equals("목록")) {
				wiseSayingController.list();

			} else if (cmd.startsWith("삭제")) {
				// parsing

				Rq rq = new Rq(cmd);
				// content도 한번 추가해봄 예)삭제?id=5&author=정다운&content=abcd
				System.out.println("actionCode : " + rq.getActionCode());
				System.out.println("params.id : " + rq.getParam("id"));
				System.out.println("params.author : " + rq.getParam("author"));
				System.out.println("params.content : " + rq.getParam("content"));
				// parsing

				wiseSayingController.remove();
			} else {
				System.out.println("존재하지 않는 명령어입니다");
			}
		}

	}
}