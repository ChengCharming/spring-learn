package Learn.SortAndSearch;

public class LearnSort {
	
	    public static void main(String[] args) {
	        int data[] = {43,54,123,5,98,10,7,74,5,54};
	        System.out.println("原先数组：");
	        for(int d : data) {
	            System.out.print(d + "  ");
	        }
	        System.out.println("\n");
	        /*System.out.println("冒泡排序：");
	        MySort.bubleSort(data, 10);
	        for(int d : data) {
	            System.out.print(d + "  ");
	        }
	        System.out.println("\n");
	        System.out.println("快速排序：");
	        MySort.quickSort(data, 0, 9);
	        for(int d : data) {
	            System.out.print(d + "  ");
	        }
	        System.out.println("\n");
	        System.out.println("插入排序：");
	        MySort.bInsertSort(data, 10);
	        for(int d : data) {
	            System.out.print(d + "  ");
	        }
	        System.out.println("\n");
	        System.out.println("希尔排序：");
	        MySort.shellSort(data, 10);
	        for(int d : data) {
	            System.out.print(d + "  ");
	        }
	        System.out.println("\n");
	        System.out.println("选择排序：");
	        MySort.selectSort(data, 10);
	        for(int d : data) {
	            System.out.print(d + "  ");
	        }
	        System.out.println("\n");
	        System.out.println(" 堆排序 ：");
	        int data2[] = C语言实现8种排序C语言实现8种排序{-1,43,54,123,5,98,10,7,74,5,54};
	        MySort.heapSort(data2, 10);
	        for(int i = 1; i < 11; i++) {
	            System.out.print(data2[i] + "  ");
	        }
	        System.out.println("\n");/*
	        System.out.println("归并排序：");
	        MySort.mergeSort(data, 0, 9);
	        for(int d : data) {
	            System.out.print(d + "  ");
	        }
	        System.out.println("\n");*/
	        System.out.println("基数排序：");
	        MySort.radixSort(data, 10);
	        for(int d : data) {
	            System.out.print(d + "  ");
	        }
	        System.out.println("\n");
	    }
	}

	class MySort {
	    //----------------------冒泡排序----------------------**/
	    public static void bubleSort(int data[], int n) {
	        for(int j = 0; j < n - 1; j++) {
	            for(int i = 0; i < n - j - 1; i++) {
	                if(data[i] > data[i+1]) {
	                    int temp = data[i];
	                    data[i] = data[i+1];
	                    data[i+1] = temp;
	                }
	            }
	        }
	    }

	   //----------------------快速排序----------------------**/
	    public static int findPos(int data[], int low, int high) {
	        int t = data[low];
	        while(low < high) {
	            while(low < high && data[high] >= t) {
	                high--;
	            }
	            data[low] = data[high];
	            while(low < high && data[low] <= t) {
	                low++;
	            }
	            data[high] = data[low];
	        }
	        data[low] = t;
	        return low;
	    }
	    public static void quickSort(int data[], int low, int high) {
	        if(low > high) {
	            return;
	        }
	        int pos = findPos(data, low, high);
	        quickSort(data, low, pos - 1);
	        quickSort(data, pos + 1, high);
	    }

	    //----------------------插入排序----------------------**/
	    public static void bInsertSort(int data[], int n) {
	        int low, high, temp, mid;
	        for(int i = 1; i < n; i++) {
	            low = 0;
	            temp = data[i];
	            high = i - 1;
	            while(low <= high) {
	                mid = (low + high) / 2;
	                if(data[mid] > temp) {
	                    high = mid - 1;
	                }
	                else {
	                    low = mid + 1;
	                }
	            }
	            int j = i;
	            while((j > low) && data[j-1] > temp) {
	                data[j] = data[j-1];
	                --j;
	            }
	            data[low] = temp;
	        }
	    }

	   //----------------------希尔排序----------------------**/
	    public static void shellSort(int data[], int n) {
	        int key, j;
	        for(int step = n / 2; step > 0; step /= 2) {
	            for(int i = step; i < n; i++) {
	                key = data[i];
	                for(j = i - step; j >= 0 && key < data[j]; j -= step) {
	                    data[j+step] = data[j];
	                }
	                data[j+step] = key;
	            }
	        }
	    }

	    //----------------------选择排序----------------------**/
	    public static void selectSort(int data[], int n) {
	        for(int i = 0; i < n - 1; i++) {
	            int mix = i;
	            for(int j = i + 1; j < n; j++) {
	                if(data[j] < data[mix]) {
	                    mix = j;
	                }
	            }
	            if(i != mix) {
	                int temp = data[i];
	                data[i] = data[mix];
	                data[mix] = temp;
	            }
	        }
	    }

	    //----------------------堆排序----------------------**/
	    public static void heapSort(int data[], int n) {
	        for(int i = n / 2; i > 0; i--) {
	            heapAdjust(data, i, n);
	        }
	        for(int i =n; i > 1; i--) {
	            swap(data, 1, i);
	            heapAdjust(data, 1, i - 1);
	        }
	    }
	    public static void swap(int data[], int i, int j) {
	        int temp = data[i];
	        data[i] = data[j];
	        data[j] = temp;
	    }
	    public static void heapAdjust(int data[], int i, int n) {
	        int temp = data[i];
	        for(int j = 2 * i; j <= n; j *= 2) {
	            if(j < n && data[j] < data[j+1]) {
	                j++;
	            }
	            if(temp >= data[j]) {
	                break;
	            }
	            data[i] = data[j];
	            i = j;
	        }
	        data[i] = temp;
	    }

	   //----------------------归并排序----------------------**/
	    public static void mergeSort(int data[], int first, int last) {
	        int mid = 0;
	        if(first < last) {
	            mid = (first + last) / 2;
	            mergeSort(data, first, mid);
	            mergeSort(data, mid + 1, last);
	            merge(data, first, mid, last);
	        }
	        return;
	    }
	    public static void merge(int data[], int low, int mid, int high) {
	        int[] temp = new int[high-low+1];
	        int k;
	        int left_low = low;
	        int left_high = mid;
	        int right_low = mid+1;
	        int right_high = high;
	        for(k = 0; left_low <= left_high && right_low <= right_high; k++) {
	            if(data[left_low] <= data[right_low]) {
	                temp[k] = data[left_low++];
	            } else {
	                temp[k] = data[right_low++];
	            }
	        }
	        if(left_low <= left_high) {
	            for(int i = left_low; i <= left_high; i++) {
	                temp[k++] = data[i];
	            }
	        }
	        if(right_low <= right_high) {
	            for(int i = right_low; i <= right_high; i++) {
	                temp[k++] = data[i];
	            } 
	        }
	        for(int i = 0; i < high-low+1; i++) {
	            data[low+1] = temp[i];
	        }
	        return;
	    }

	    //----------------------基数排序----------------------**/
	    public static int getNumPos(int num, int pos) {
	        int temp = 1;
	        for(int i = 0; i < pos - 1; i++) {
	            temp *= 10;
	        }
	        return (num / temp) % 10;
	    }
	    public static void radixSort(int data[], int n) {
	        int num = 0;
	        int index = 0;
	        int k = 0;
	        int[][] radixArrays = new int[10][];
	        for(int i = 0; i < 10; i++) {
	            radixArrays[i] = new int[n+1];
	            radixArrays[i][0] = 0;
	        }
	        for(int pos = 1; pos <= 31; pos++) {
	            for(int i = 0; i < n; i++) {
	                num = getNumPos(data[i], pos);
	                index = ++radixArrays[num][0];
	                radixArrays[num][index] = data[i];
	            }
	            int j = 0;
	            for(int i = 0; i < 10; i++) {
	                for(k = 1; k <= radixArrays[i][0]; k++) {
	                    data[j++] = radixArrays[i][k];
	                }
	                radixArrays[i][0] = 0;
	            }
	        }
	    }
}