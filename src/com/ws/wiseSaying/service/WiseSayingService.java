package com.ws.wiseSaying.service;

import java.util.List;

import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.repository.WiseSayingRepository;

public class WiseSayingService {

	private WiseSayingRepository wiseSayingRepository;

	public WiseSayingService() {

		wiseSayingRepository = new WiseSayingRepository();
	}

	public List<WiseSaying> findAll() {
		return wiseSayingRepository.findAll();
	}

	public int write(String content, String author) {

		return wiseSayingRepository.write(content, author);
	}

	public WiseSaying findById(int id) {
		return wiseSayingRepository.findById(id);
	}

	public void remove(WiseSaying wiseSaying) {
		wiseSayingRepository.remove(wiseSaying);
	}

	public void modify(WiseSaying wiseSaying, String content, String author) {
		wiseSayingRepository.modify(wiseSaying, content, author);

	}

}