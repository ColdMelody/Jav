package algorithms;

import java.util.Arrays;

/**
 * Created by Bill on 2017/3/26.
 * Email androidBaoCP@163.com
 * 快速排序算法的Java简单实现
 */
public class FastSort {
    // 第一次排序
    private static int firstSqu(int[] array,int low,int high){
        // 选定一个基准数
        int key = array[low];
        while (low<high){
            // 比基准数大的放在右边
            while (array[high]>=key&&high>low){
                high--;
            }
            // 右边出现比基准数小的，放在基准数的左边
            array[low] = array[high];
            while (array[low]<=key&&high>low){
                low++;
            }

            array[high] = array[low];
        }
        // 左右的数放好之后，将基准数放在合适的位置
        array[high] = key;
        return high;
    }

    private static void secodeSqu(int array[],int low,int high){
        if (low>=high)
            return;
        // 迭代直至排序完成
        int index = firstSqu(array,low,high);
        secodeSqu(array,low,index-1);
        secodeSqu(array,index+1,high);
    }
    public static void main(String[] args){
        int[] array = {5,8,2,3,6,9,4,2,8,6,4,1,15,21,11};
        secodeSqu(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
