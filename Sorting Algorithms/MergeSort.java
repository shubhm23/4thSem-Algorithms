
// //Counting Inversions

// import java.lang.Math;
// class MergeSort{
    
//     int merge(int arr[], int l, int m, int r)
//     {
    
//         int n1 = m - l + 1;
//         int n2 = r - m;
//         int count = 0;
    
//         int L[] = new int[n1];
//         int R[] = new int[n2];
 
//         for (int i = 0; i < n1; ++i)
//             L[i] = arr[l + i];
//         for (int j = 0; j < n2; ++j)
//             R[j] = arr[m + 1 + j];
 
//         int i = 0, j = 0;

//         int k = l;
//         while (i < n1 && j < n2) {
//             if (L[i] <= R[j]) {
//                 arr[k] = L[i];
//                 i++;
//             }
//             else {
//                 count += n1-i;
//                 arr[k] = R[j];
//                 j++;
//             }
//             k++;
//         }

//         while (i < n1) {
//             arr[k] = L[i];
//             i++;
//             k++;
//         }

//         while (j < n2) {
//             arr[k] = R[j];
//             j++;
//             k++;
//         }

//         return count;
//     }


//     int sort(int arr[], int l, int r)
//     {
//         if (l >= r) 
//                 return 0;
//             int m =l+ (r-l)/2;
//             int r1 = sort(arr, l, m);
//             int r2 = sort(arr, m + 1, r);
//             int p = merge(arr, l, m, r);
//             return r1+r2+p;
//     }
 
//     static void printArray(int arr[])
//     {
//         int n = arr.length;
//         for (int i = 0; i < n; ++i)
//             System.out.print(arr[i] + " ");
//         System.out.println();
//     }
 

// 	public static void main(String[] args) {
// 		int []range = {8};
// 		int min = 1;
// 		for(int i=0;i<range.length;i++){
// 			int n = range[i];
// 			int []arr = new int[n];
// 			for(int j=0;j<n;j++){
// 				arr[j] = (int)(Math.random() * n) + min;
// 			}
//             MergeSort ms = new MergeSort();
// 			long start = System.nanoTime();
//             int res = ms.sort(arr,0,n-1);
//             long end = System.nanoTime();
//             System.out.println("Total number of invesions: "+res);
//             printArray(arr);
//             System.out.println(range[i] +" "+(end-start));
// 		}

// 	}
// }


//Merge Sort
import java.lang.Math;
class MergeSort{
    
    void merge(int arr[], int l, int m, int r)
    {
    
        int n1 = m - l + 1;
        int n2 = r - m;
 
    
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    void sort(int arr[], int l, int r)
    {
        if (l < r) {

            int m =l+ (r-l)/2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
 
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 

    public static void main(String[] args) {
        int []range = {100,200,300,500,1000,2000,3000,5000,6000,8000,10000,50000};
        int min = 1;
        for(int i=0;i<range.length;i++){
            int n = range[i];
            int []arr = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = (int)(Math.random() * n) + min;
            }
            MergeSort ms = new MergeSort();
            long start = System.nanoTime();
            ms.sort(arr,0,n-1);
            long end = System.nanoTime();
            //printArray(arr);
            System.out.println(range[i] +" "+(end-start));
        }

    }
}