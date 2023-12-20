import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	private Scanner sc;

	public App(Scanner sc) {
		this.sc = sc;
	}

	public void run() {
		System.out.println("== 명언 앱 실행 ==");

		int lastId = 0;
		List<WiseSaying> wiseSayings = new ArrayList<>();

		while (true) {
			System.out.print("명령어 ) ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("종료")) {
				break;
			} else if (cmd.equals("등록")) {
				int id = lastId + 1;
				System.out.print("명언 : ");
				String content = sc.nextLine().trim();
				System.out.print("작가 : ");
				String author = sc.nextLine().trim();

				WiseSaying wiseSaying = new WiseSaying(id, content, author);
				wiseSayings.add(wiseSaying);

				System.out.printf("%d번 명언이 등록되었습니다.\n", id);
				lastId++;

			} else if (cmd.equals("목록")) {
				if (wiseSayings.size() == 0) {
					System.out.println("등록 된 명언이 없어");
				} else {
					System.out.println("번호  /  작가  /  명언  ");
					System.out.println("=".repeat(30));
					//역순으로 출력하기 위해 최대값에서 -1을 해줘야한다.
					//-1을 안하면 인덱스의 마지막번호는 크기-1 이기 때문이다.
					for (int i = wiseSayings.size() - 1; i >= 0; i--) {
						WiseSaying ws = wiseSayings.get(i);			//리모콘 이해 중요함!!!!

						System.out.printf("%d  /  %s  /  %s\n", ws.getId(), ws.getAuthor(), ws.getContent());
					}

				}
			} else {
				System.out.println("존재하지 않는 명령어입니다");
			}
		}

	}
}