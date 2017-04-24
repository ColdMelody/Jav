package test;

import java.util.Arrays;

/**
 * Created by Bill on 2017/3/26.
 * Email androidBaoCP@163.com
 */
public class FastSort2 {
    public static int partition(int []array,int lo,int hi){
        //固定的切分方式
        int key=array[lo];
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){//从后半部分向前扫描
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }

    public static void sort(int[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        int index=partition(array,lo,hi);
        sort(array,lo,index-1);
        sort(array,index+1,hi);
    }
    public static void main(String[] args){
        int[] array = {5,8,2,3,6,9,4,2,8,6,4,1,15,21,11};
        sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
