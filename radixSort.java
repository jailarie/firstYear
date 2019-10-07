import java.util.Arrays;

public class radixSort {

	
	public static void sort(int[] arr) { 
		int n = arr.length;
		
		radix(arr,n);

	}
	
	static void radix(int[] arr, int n) {
		int m;
		int digit;
		m = maxValue(arr, n);
		
		for (digit=1; m/digit > 0; digit*=10) {
			countSort(arr, n, digit);
			}
	}
		
	
	static int maxValue(int[]arr, int n) {
		int max = arr[0];
		for (int i=1; i<n;i++) {
			if (max<arr[i]) {
				max = arr[i];
			}
		}
		return max;
		
	}
	
	 static void countSort(int arr[], int n, int digit) {
		int outcome[] = new int[n];
		int current;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		
		for (current=0; current<n; current++) { //bucket
			count[(arr[current]/digit)%10]++;
		}
		
		for (current=n-1; current<10; current++) {
			count[current]+=count[current-1];
		}
			
		for(current=n-1; current>=0; current--) { //builds final array
			outcome[count[(arr[current]/digit)%10]-1]=arr[current];
			count[(arr[current]/digit)%10]--;
		}
		
		for (current=0; current<n;current++) { //contains sorted numbers
			arr[current] = outcome[current];
		}
		
		
	}
	
}
