import java.io.IOException;
import java.util.Random;

public class Driver{
	public static void main(String[] args) throws IOException {
		Random random = new Random();
		int[] arr = new int[100000];
		
		for (int i=0; i<arr.length; i++) { //original array
		arr[i] = random.nextInt(500000);}
	
		int[] arr2 = new int[arr.length]; //creates copy two of original array
		for (int j = 0; j < arr2.length; j++) {
			arr2[j] = arr[j];}
		
		int[] arr3 = new int[arr.length]; //creates copy three of original array
		for (int k = 0; k < arr3.length; k++) {
			arr3[k] = arr[k];}
		
		//StopWatch timer = new StopWatch();
		//bubbleSort.sort(arr);
		//System.out.println("bubbleSort elapsed time = " + timer.elapsedTime());
		
		StopWatch timer2 = new StopWatch();
		radixSort.sort(arr2);
		System.out.println("radixSort elapsed time = " + timer2.elapsedTime());
		
		//StopWatch timer3 = new StopWatch();
		//cocktailSort.sort(arr3);
		//System.out.println("cocktailSort elapsed time = " + timer3.elapsedTime());
		
		for(int l = 0; l<50; l++) {
			System.out.println(arr2[l]);
		}
	}


	
	
	
}