package com.ws.wiseSaying.service;

import java.util.List;

import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.repository.WiseSayingRepository;

public class WiseSayingService {

	private WiseSayingRepository wiseSayingRepository;

	public WiseSayingService() {

		wiseSayingRepository = new WiseSayingRepository(); // 생성자, 서비스객체 실행시 동시에 접근하기위한 리포지터리 객체 생성,
	}

	public List<WiseSaying> findAll() {
		return wiseSayingRepository.findAll(); // WiseSaying타입이고 Arraylist인 객체를 리포지터리로부터 받아 넘겨준다.
	}

	public int write(String content, String author) {

		return wiseSayingRepository.write(content, author); // 컨트롤러에서 보낸 데이터를 리포지터리로 보내고
	} 														// 리포지터리로부터 받은 값을 컨트롤러로 반환.

	public WiseSaying findById(int id) { //매개변수 id로 받은 데이터를 리포지터리로 전달하고.
		return wiseSayingRepository.findById(id); // 리포지터리로부터 받은 값을 컨트롤러로 반환
	}

	public void remove(WiseSaying wiseSaying) {	//컨트롤러에서 wiseSaying이 가리키는 주소?를 매개변수로 
		wiseSayingRepository.remove(wiseSaying);	//받아서 리포지터리의 remove메소드로 전달
	}

	public void modify(WiseSaying wiseSaying, String content, String author) {
		wiseSayingRepository.modify(wiseSaying, content, author);
		//컨트롤러에서 wiseSaying이 가리키는 주소? 와 String타입의 인자를 매개변수로 받아서 리포지터리로 전달한다.
	}

}