package com.ws.wiseSaying.controller;

import java.util.ArrayList;
import java.util.List;

import com.ws.Container;
import com.ws.Rq;
import com.ws.wiseSaying.entity.WiseSaying;

public class WiseSayingController {

	private int lastId;
	private List<WiseSaying> wiseSayings;

	// 생성자
	public WiseSayingController() {
		lastId = 0;
		wiseSayings = new ArrayList<>();
	}

	private WiseSaying findById(int id) {
		// 향상된 for문
		// wiseSayings 에 있는지 둘러보기.
		for (WiseSaying wiseSaying : wiseSayings) {
			if (wiseSaying.getId() == id) {
				return wiseSaying;
			}
		}
		// 없을시 null을 remove의 wiseSaying로 전달 바로 밑 if문의 null과
		// 같다고 해서 출력문이 출력된다.
		return null;
	}

	public void write() {
		int id = lastId + 1;
		System.out.print("명언 : ");
		String content = Container.getScanner().nextLine().trim();
		System.out.print("작가 : ");
		String author = Container.getScanner().nextLine().trim();

		WiseSaying wiseSaying = new WiseSaying(id, content, author);
		wiseSayings.add(wiseSaying);

		System.out.printf("%d번 명언이 등록되었습니다.\n", id);
		lastId++;

	}

	public void list() {
		if (wiseSayings.size() == 0) {
			System.out.println("등록 된 명언이 없어");
		} else {
			System.out.println("번호  /  작가  /  명언  ");
			System.out.println("=".repeat(30)); // =를 30번 반복하겠다는 의미.
			// 역순으로 출력하기 위해 최대값에서 -1을 해줘야한다.
			// -1을 안하면 인덱스의 마지막번호는 크기-1 이기 때문이다.
			for (int i = wiseSayings.size() - 1; i >= 0; i--) {
				WiseSaying ws = wiseSayings.get(i); // 리모콘 이해 중요함!!!!

				System.out.printf("%d  /  %s  /  %s\n", ws.getId(), ws.getAuthor(), ws.getContent());
			}

		}

	}

	// 삭제
	public void remove(Rq rq) {
		int id = rq.getIntParam("id", -1);

		if (id == -1) {
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;
		}

		WiseSaying wiseSaying = findById(id);

		// 밑에 wiseSayings에 존재하지 않을경우 null이 전달됨.
		if (wiseSaying == null) {
			System.out.printf("%d 명언은 존재하지 않습니다.\n", id);
		}

		System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
//		System.out.printf("%d번 명언이 삭제되었습니다.\n", wiseSaying.getId());

	}

	// 수정
	public void modify(Rq rq) {
		int id = rq.getIntParam("id", -1);
		if (id == -1) {
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;
		}

		WiseSaying wiseSaying = findById(id);
		if (wiseSaying == null) {
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}
		// 찾은 명언 객체를 object기반으로 수정
		System.out.println("명언(기존) :" + wiseSaying.getContent());
		System.out.println("작가(기존) :" + wiseSaying.getAuthor());

		System.out.print("명언 : ");
		String content = Container.getScanner().nextLine().trim();
		System.out.print("작가 : ");
		String author = Container.getScanner().nextLine().trim();

		wiseSaying.setContent(content);
		wiseSaying.setAuthor(author);

		System.out.printf("%d번 명언이 수정되었습니다.\n", id);

//		//제한시간안에 내가한것.
//		System.out.printf("명언(기존) : %s\n", wisesaying.getContent());
//		System.out.printf("작가(기존) : %s\n", wisesaying.getAuthor());
//		// System.out.printf("(새)명언 : %s", ws.setContent());
//		System.out.printf("(새)명언 : ");
//		String str = Container.getScanner().nextLine().trim();
//		wisesaying.setContent(str);
//		System.out.printf("(새)작가 : ");
//		String str2 = Container.getScanner().nextLine().trim();
//		wisesaying.setAuthor(str2);
//		System.out.printf("%d번 명언이 수정되었습니다.\n", id);
	}

}
