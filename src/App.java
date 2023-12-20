import java.util.Scanner;

public class App {
	private Scanner sc;

	public App(Scanner sc) {
		this.sc = sc;
	}

	public void run() {
		System.out.println("== 명언 앱 실행 ==");
		// trim() : 혹시 있을지 모르는 좌우 공백 제거
		while(true) {
			System.out.print("명령어 ) ");
			String cmd = sc.nextLine().trim();
			
			if(cmd.equals("종료")) {
				break;
			}
		}

	}
}