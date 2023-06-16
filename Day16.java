public class Day16 {

  public static void main(String[] args){
	  int[] arr ={1,15,25,45,42,21,17,12,11};
	  int n = arr.length;
          int ans = new Solution().findMaximum(arr, n);
          System.out.println(ans);
      }
  }

class Solution {
  int findMaximum(int[] arr, int n) {
      // code here
	  
	  //if there is only one element
      if(n==1){
          return arr[0];
      }
      //if the first element is greater than second
      else if(arr[0]>=arr[1]){
          return arr[0];
      }
    //if the last element is greater than second last element
      else if(arr[n-1]>=arr[n-2]){
          return arr[n-1];
      }
     //else search PEEK element one by one
  for(int i=1; i<n-1; i++){
      if((arr[i]>=arr[i+1])&&(arr[i]>=arr[i-1])){
          return arr[i];
      }
    }
  //if no found , then first element is peek element
   return arr[0];
  }
}