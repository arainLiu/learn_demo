package com.nirvana.travel.newke.minlosenum;

/**
 * 数组中缺失最小正数,时间复杂度O(N),空间复杂度O(1)
 * @author arainliu
 * @date 2021/5/12
 */
public class Solution {


  public static void main(String[] args) {
    int[] arr = new int[] {-1,8,6,3,4,2,5,1};
//    System.out.println(new LRUCache().minNumberdisappered2(arr));
  }

  int missMinNum(int arr[], int n) {
    int l = 0;
    int r = n;

    while(l < r) {
      if(arr[l] == l + 1) {//在理想的位置
        l++;
      } else if(arr[l] > r || arr[l] <= l || arr[arr[l] - 1] == arr[l]) {//不合法的数据
        arr[l] = arr[--r];
      } else {//合法但是没有在理想的位置上
        swap(arr, l, arr[l] - 1);
      }

    }

    return l + 1;

  }//missMinMun()

  /**
   * return the min number
   * @param arr int整型一维数组 the array
   * @return int整型
   */
  public int minNumberdisappered (int[] arr) {
    int n=arr.length;
    for(int i=0;i<n;i++){
      while(arr[i]>=1&&arr[i]<=n&&arr[arr[i]-1]!=arr[i]){
        swap(arr,arr[i]-1,i);
      }
    }
    for(int i=0;i<n;i++){
      if(arr[i]!=i+1){
        return i+1;
      }
    }
    return n+1;
  }
  private void swap(int[] arr,int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
  }
}
