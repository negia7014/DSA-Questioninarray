//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countTriplets(int[] arr, int target) {
        // Code Here
        int count=0;
        for(int i=0;i<arr.length-2;i++){
            int current = target-arr[i];
            int j=i+1;
            int r = arr.length-1;
                 
            while(j<r){
                if(arr[j]+arr[r]==current){
                 count++;
                 int k=j+1;
                 while(k<r && arr[k]==arr[k-1]){
                     count++;
                     k++;
                 }
                 r--;
               
            }
                else if(arr[j]+arr[r]<current){
                    j++;
                }
                else{
                    r--;
                }
            }
        }
        return count;
    }
}

