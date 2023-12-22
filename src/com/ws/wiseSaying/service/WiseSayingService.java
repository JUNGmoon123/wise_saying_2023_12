package com.ws.wiseSaying.service;

import java.util.ArrayList;
import java.util.List;

import com.ws.wiseSaying.entity.WiseSaying;

public class WiseSayingService {
	private int lastWiseSayingId;
	private List<WiseSaying> wiseSayings;

	public WiseSayingService() {

		lastWiseSayingId = 0;
		wiseSayings = new ArrayList<>();
	}

	public List<WiseSaying> findAll() {
		return wiseSayings;
	}

	public WiseSaying findById(int id) {
		for (WiseSaying wiseSaying : wiseSayings) {
			if (wiseSaying.getId() == id) {
				return wiseSaying;
			}
		}

		return null;
	}

	public int write(String content, String author) {
		int id = lastWiseSayingId + 1;

		WiseSaying wiseSaying = new WiseSaying(id, content, author);
		wiseSayings.add(wiseSaying);

		lastWiseSayingId = id; // 방금 전에 새 명언이 생겼으니, lastWiseSayingId의 값을 갱신

		return id;
	}

	public void remove(WiseSaying wiseSaying) {
		wiseSayings.remove(wiseSaying);
	}

	public void modify(WiseSaying wiseSaying, String content, String author) {
		wiseSaying.setContent(content);
		wiseSaying.setAuthor(author);

	}

}