package com.ws;

import com.ws.export.controller.ExportController;
import com.ws.system.controller.SystemController;
import com.ws.wiseSaying.controller.WiseSayingController;

public class App {

	private byte system_status = 1;

	public App() {

	}

	public void run() {
		System.out.println("== 명언 앱 실행 ==");

		SystemController systemController = new SystemController();
		WiseSayingController wiseSayingController = new WiseSayingController();
		ExportController exportController = new ExportController();

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
			case "수정":
				wiseSayingController.modify(rq);
				break;
			case "추출":
				exportController.makeHtml(rq);
				break;
			default:
				System.out.println("존재하지 않는 명령어입니다");
				break;
			}
		}

	}
}