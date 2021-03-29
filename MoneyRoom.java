import java.lang.Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MoneyRoom {
	
	static int maxSub(int[] arr, int left, int right) {
		
		
		if (left == right) {
			if (arr[left] > 0) return arr[left];
			return 0;
		}
		
		int middle = (int) Math.floor((left + right) / 2);
		
		
		
		int leftAll = 0;
		int maxLeftAll = 0;
		for (int i = middle; i > left - 1; i --) {
			leftAll += arr[i];
			if (leftAll > maxLeftAll) {
				maxLeftAll = leftAll;
			}
		}
		
		int rightAll = 0;
		int maxRightAll = 0;
		for (int i = middle + 1; i < right + 1; i ++) {
			rightAll += arr[i];
			if (rightAll > maxRightAll) {
				maxRightAll = rightAll;
			}
		}
		

		int maxLeft = maxSub(arr, left, middle);
		int maxRight = maxSub(arr, middle + 1, right);
		
		return Math.max(maxLeft, Math.max(maxRight, maxLeftAll + maxRightAll));
		
	}
	
	

	public static void main(String[] args) {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			int i = 0;
			int[] arr;
			int size = Integer.parseInt(bf.readLine());
			arr = new int[size];
			
			
			while (i < size) {
				arr[i] = Integer.parseInt(bf.readLine());
				i ++;
				
			}

			System.out.println(maxSub(arr, 0, size - 1));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}
