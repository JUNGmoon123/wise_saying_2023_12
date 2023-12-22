package com.ws.wiseSaying.controller;

import java.util.List;

import com.ws.Container;
import com.ws.Rq;
import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.service.WiseSayingService;

public class WiseSayingController {

	private WiseSayingService wiseSayingService;	// ?? 외부차단??, 정보변경 금지??

	public WiseSayingController() {
		wiseSayingService = new WiseSayingService();	// 생성자, APP에서 Controller실행시 자동으로 실행되어 Service의 객체 생성, 접근가능하게됨.
	}

	public void write() {				//App에서 등록키워드실행시 실행
		System.out.print("명언 : ");
		String content = Container.getScanner().nextLine().trim();	
		System.out.print("작가 : ");
		String author = Container.getScanner().nextLine().trim();

		int id = wiseSayingService.write(content, author);	//사용자로부터 입력받은 정보를 Service의 write로 넘겨준다.
															//반환값을 id변수에 저장.

		System.out.printf("%d번 명언이 등록되었습니다.\n", id);	//Service에서 리턴된 값 id출력
	}

	public void list() {			//App에서 등록키워드실행시 실행
		List<WiseSaying> wiseSayings = wiseSayingService.findAll();		//Service로 list정보를 요청하고 Service에서 정보를반환한다.
											//반환된 데이터들을 ArrayList로 만들어진 배열에 저장하고 wiseSayings리모콘이 가리킨다.
										//List타입인 이유는 리포지터리에서 만들어진 리스트를 가져오기 위함. 
										//int형을 저장하려면 int형에만 해야하는 것과 같다.

		System.out.println("번호  /  작가  /  명언  ");
		System.out.println("=".repeat(30));
			
		for (int i = wiseSayings.size() - 1; i >= 0; i--) {		// wiseSayins에 저장된 갯수-1 부터 시작해서 출력
			WiseSaying ws = wiseSayings.get(i);					// wiseSayins에 저장된 인덱스주소를 ws가 가리키게 한다.

			System.out.printf("%d  /  %s  /  %s\n", ws.getId(), ws.getAuthor(), ws.getContent());	
				// ws가 객체주소에 저장된 각각의 값을 출력문에 전달.
		}
	}

	public void remove(Rq rq) {		//App에서 등록키워드실행시 실행

		int id = rq.getIntParam("id", -1);		//getINtparam메소드에서 반환된 int값을 id변수에 저장.

		if (id == -1) {				// id값이 -1 이면 App쪽으로 다시 이동된다.
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id); //id값을 서비스의 findById메소드로 전달하고 처리된 데이터가 
																//wiseSaying리모콘이 가리키게 한다.

		if (wiseSaying == null) {		//wiseSaying이 가리키는게 null값일시 실행.
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;				//remove메소드가 종료되고 App쪽으로 이동. 
		}

		// 찾은 명언 객체를 object기반으로 삭제
		wiseSayingService.remove(wiseSaying);	 

		System.out.printf("%d번 명언이 삭제되었습니다.\n", id);		//위의 조건문에서 살아남았다면 맞는정보를 처리했으니 실행되고
																	//id값으로 알려준다.

	}

	public void modify(Rq rq) {
		int id = rq.getIntParam("id", -1);	//getINtparam메소드에서 반환된 int값을 id변수에 저장.

		if (id == -1) {		// id값이 -1 이면 App쪽으로 다시 이동된다.
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id);	//id값을 서비스의 findById메소드로 전달하고 처리된 데이터가 
																	//wiseSaying리모콘이 가리키게 한다.

		if (wiseSaying == null) {				//wiseSaying이 가리키는게 null값일시 실행.
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;					//modify메소드가 종료되고 App쪽으로 이동. 
		}

		// 찾은 명언 객체를 object기반으로 수정
		System.out.println("명언(기존) :" + wiseSaying.getContent());
		System.out.println("작가(기존) :" + wiseSaying.getAuthor());

		System.out.print("명언 : ");
		String content = Container.getScanner().nextLine().trim();
		System.out.print("작가 : ");
		String author = Container.getScanner().nextLine().trim();

		wiseSayingService.modify(wiseSaying, content, author);	//덮어쓸 정보를 서비스로 넘겨준다.

		System.out.printf("%d번 명언이 수정되었습니다.\n", id);

	}

}