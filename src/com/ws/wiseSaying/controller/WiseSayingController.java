package com.ws.wiseSaying.controller;

import java.util.ArrayList;
import java.util.List;

import com.ws.Container;
import com.ws.wiseSaying.entity.WiseSaying;

public class WiseSayingController {

	private int lastId;
	private List<WiseSaying> wiseSayings;

	// 생성자
	public WiseSayingController() {
		lastId = 0;
		wiseSayings = new ArrayList<>();
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

	public void remove() {
		//내가 스스로 한것, 마지막 번호삭제시 오류나옴
		//Map을 안쓰고 번호로 해결하려고 했음.
//		if (wiseSayings.size() == 0) {
//			System.out.println("삭제할 명언이 없음");
//		} else {
//			System.out.print("삭제할 명언의 번호를 입력하세요: ");
//			String num = Container.getScanner().nextLine().trim();
//			int i_num = Integer.parseInt(num);
//			wiseSayings.remove(i_num-1);
//			lastId -= 1;
//			System.out.printf("%d명언이 삭제되었습니다.\n", i_num);
//		}
	}

}
