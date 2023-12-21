package com.ws;

import java.util.HashMap;
import java.util.Map;

// Rq == Request(요청)
public class Rq {
	private String actionCode;
	private Map<String, String> params;

	public Rq(String cmd) {
		String[] cmdBits = cmd.split("\\?", 2);

		actionCode = cmdBits[0];

		params = new HashMap<>();
		
		//잘못된 입력시 cmdBits는 쪼개지지않으니 1이면 리턴해준다.
		if (cmdBits.length == 1) {
			return;
		}
		
		String[] paramBits = cmdBits[1].split("&");

		for (String paramStr : paramBits) {
			String[] paramStrBits = paramStr.split("=", 2);
			
			//삭제?id= 이렇게 값(value)없을경우 대비.
			if (paramBits.length == 1) {
				continue;
			}
			
			String key = paramStrBits[0];
			String value = paramStrBits[1];
			params.put(key, value);
		}
	}

	public String getActionCode() {
		return actionCode;
	}

	public String getParam(String name) {
		return params.get(name);
	}

}