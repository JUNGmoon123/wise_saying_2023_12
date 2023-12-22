package com.ws;

import java.util.HashMap;
import java.util.Map;

// Rq == Request(요청)
public class Rq {
	private String actionCode;
	private Map<String, String> params;

	//명령어를 알맞은 정보로 가공, app쪽에선 필요한것만 요청
	//Rq는 요청에 대한 처리
	public Rq(String cmd) {
		String[] cmdBits = cmd.split("\\?", 2);

		actionCode = cmdBits[0];

		params = new HashMap<>();

		// 잘못된 입력시 cmdBits는 쪼개지지않으니 1이면 리턴해준다.
		// 여기서 return으로 Rq는 값이 없고 Rq의 actionCode에 '삭제'가 남아있다.
		if (cmdBits.length == 1) {
			return;
		}

		String[] paramBits = cmdBits[1].split("&");

		for (String paramStr : paramBits) {
			String[] paramStrBits = paramStr.split("=", 2);

			// 삭제?id= 이렇게 값(value)없을경우 대비.
			if (paramStrBits.length == 1) {
				continue;
			}

			String key = paramStrBits[0];
			String value = paramStrBits[1];
			params.put(key, value); // 위에 new해쉬맵으로 들어간다.
		}
	}

	public String getActionCode() {
		return actionCode;
	}

	public String getParam(String name) {
		return params.get(name); // Map인 params의 get은 ()안에 키값을 받으면
								// name(key)의value값을 준다.
	}

	public int getIntParam(String name, int defaultValue) {
		try {
			return Integer.parseInt(getParam(name));
			//이부분 다시볼것.
			//name으로 들어온건(value) String타입임.
		} catch (NumberFormatException e) {

		}
		return defaultValue;
		// defaultValue는 -1을 준다.
	}

}