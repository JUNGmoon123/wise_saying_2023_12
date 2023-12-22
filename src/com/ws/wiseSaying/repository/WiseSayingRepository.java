package com.ws.wiseSaying.repository;

import java.util.ArrayList;
import java.util.List;

import com.ws.wiseSaying.entity.WiseSaying;

public class WiseSayingRepository {

	private int lastWiseSayingId;			//저장될 객체들을 구분하기 위한 번호
	private List<WiseSaying> wiseSayings;	//WiseSaying타입 ArrayList 선언, 데이터베이스 역할을 한다.

	public WiseSayingRepository() {			//생성자, 

		lastWiseSayingId = 0;				//번호 초기화
		wiseSayings = new ArrayList<>();	//리스트 객체 생성.
	}

	public void remove(WiseSaying wiseSaying) {	//서비스에서 id값을 받아 wiseSayings의 DB에 같은 id값(번호)이 있다면 삭제한다.
		wiseSayings.remove(wiseSaying);
	}

	public WiseSaying findById(int id) {		
		for (WiseSaying wiseSaying : wiseSayings) {	//향상된 for문 wiseSayings리스트크기? 갯수? 만큼 반복한다.
			if (wiseSaying.getId() == id) {		//매개변수로 받은 id값과 wiseSaying리모콘이 가리키는 id값이 같은지 판단한다.
				return wiseSaying;			//true면 그 값을 서비스로 반환한다
			}
		}

		return null;	//for문을 실행하고도 조건을 만족못할시 null값을 서비스로 반환.
	}

	public void modify(WiseSaying wiseSaying, String content, String author) {
		wiseSaying.setContent(content);		//wiseSaying이 가리키는 데이터에 덮어쓰기
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