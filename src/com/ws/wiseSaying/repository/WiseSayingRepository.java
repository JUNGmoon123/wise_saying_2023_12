package com.ws.wiseSaying.repository;

import java.util.ArrayList;
import java.util.List;

import com.ws.wiseSaying.entity.WiseSaying;

public class WiseSayingRepository {

	private int lastWiseSayingId;
	private List<WiseSaying> wiseSayings;

	public WiseSayingRepository() {

		lastWiseSayingId = 0;
		wiseSayings = new ArrayList<>();
	}

	public void remove(WiseSaying wiseSaying) {
		wiseSayings.remove(wiseSaying);
	}

	public WiseSaying findById(int id) {
		for (WiseSaying wiseSaying : wiseSayings) {
			if (wiseSaying.getId() == id) {
				return wiseSaying;
			}
		}

		return null;
	}

	public void modify(WiseSaying wiseSaying, String content, String author) {
		wiseSaying.setContent(content);
		wiseSaying.setAuthor(author);
	}

	public int write(String content, String author) {
		int id = lastWiseSayingId + 1;

		WiseSaying wiseSaying = new WiseSaying(id, content, author);
		wiseSayings.add(wiseSaying);

		lastWiseSayingId = id; // 방금 전에 새 명언이 생겼으니, lastWiseSayingId의 값을 갱신

		return id;
	}

	public List<WiseSaying> findAll() {
		return wiseSayings;
	}

}