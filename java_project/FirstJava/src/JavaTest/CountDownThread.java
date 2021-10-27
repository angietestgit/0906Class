package JavaTest;

public class CountDownThread extends Thread {
	
	@Override
	public void run() {
		for(int i=30; i>=0; i--) {
			
			if(HighRowGame.inputCheck) {
				System.out.println("$$$$미션 성공!$$$$ 축하합니다.");
				System.out.println("게임을 종료합니다.");
			
				return; //리턴 종료
			}
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("$$$$미션 실패!$$$$\n30초가 지나 게임을 종료합니다.");
		System.exit(0);
		
	}

}
