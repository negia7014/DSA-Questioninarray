//{ Driver Code Starts
import java.io.*;

import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling maxSubarraySum() function
		    System.out.println(obj.maxSubarraySum(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n){
        
        // Your code here
        int maxElement = arr[0];
        for (int i = 1; i < n; i++) {
            maxElement = Math.max(maxElement, arr[i]);
        }
        
        if (maxElement <= 0) {
            return maxElement; // If all elements are negative, return the maximum element
        }
        long start=0;
        long startindex=-1;
        long endindex=-1;
        long maxsum=Integer.MIN_VALUE;
        long currentsum=0;
        long minimum=0;
        for(int i=0;i<n;i++){
        currentsum+=arr[i];
        
        if(currentsum<0){
            currentsum=0;
            minimum = Math.min(minimum, currentsum);
        }
        if(currentsum==0){
            start=i+1;
        }
        if(currentsum>maxsum){
            maxsum=currentsum;
            startindex=start;
            endindex=i;
        }
        }
        if(maxsum<0){
            return minimum;
        }
        return maxsum;
        
    }
    
}

