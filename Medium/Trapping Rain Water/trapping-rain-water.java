//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends

/* three conditions 1- minimum number of bars>2
  2-if bars is arrange in both asscending and descending order then no water is trapped
  3-trapped water = (waterlevel-height of bar)*width 
  4- waterlevel = min(maxleftbar,maxrightbar)*/
class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
          long maxleftblock[]=new long[n];
     maxleftblock[0]=arr[0];
     for(int i=1;i<n;i++){
         maxleftblock[i]=Math.max(arr[i],maxleftblock[i-1]);
     }
     // create array for maxrightblock
     long maxrightblock[]=new long[n];
     maxrightblock[n-1]=arr[n-1];
     for(int i=n-2;i>=0;i--){
         maxrightblock[i]=Math.max(arr[i],maxrightblock[i+1]);
     }
     // calculate trapped water
     long trappedwater=0;
     for(int i=0;i<n;i++){
         trappedwater+=Math.min(maxleftblock[i],maxrightblock[i])-arr[i];
     }
     return trappedwater;
    } 
}





