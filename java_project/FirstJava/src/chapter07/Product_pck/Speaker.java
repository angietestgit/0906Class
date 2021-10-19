package chapter07.Product_pck;

public class Speaker {
	
	private int volumeRate;
	
	public void showCurrentState() {
		System.out.println("볼륨크기 "+volumeRate);
	}
	
	public void setVolume(int vol) {
		volumeRate = vol;
	}

}
