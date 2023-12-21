package com.ws;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

				String[] cmdBits = cmd.split("\\?", 2);

				String actionCode = cmdBits[0];
				Map<String, String> params = new HashMap<>();

				String[] paramBits = cmdBits[1].split("&");

				for (String paramStr : paramBits) {
					String[] paramStrBits = paramStr.split("=", 2);
					String key = paramStrBits[0];
					String value = paramStrBits[1];
					System.out.println("key : " + key);
					System.out.println("value : " + value);
					params.put(key, value);
				}

				System.out.println(Arrays.toString(cmdBits));
				System.out.println("actionCode : " + actionCode);
				System.out.println("params : " + params);
				// parsing

				wiseSayingController.remove();
			} else {
				System.out.println("존재하지 않는 명령어입니다");
			}
		}

	}
}