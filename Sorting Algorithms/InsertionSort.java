class InsertionSort{

	void sort(int arr[]){
		int n = arr.length;
		for(int i=0;i<n;i++){
			int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
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
		int []range = {100,200,300,500,1000,2000,3000,5000,6000,8000,10000,200000};
		int min = 1;
		for(int i=0;i<range.length;i++){
			int n = range[i];
			int []arr = new int[n];
			for(int j=0;j<n;j++){
				arr[j] = (int)(Math.random() * n) + min;
			}
            InsertionSort is = new InsertionSort();
			long start = System.nanoTime();
            is.sort(arr);
            long end = System.nanoTime();
            //printArray(arr);
            System.out.println(range[i] +" "+(end-start));
            //break;

		}

	}
}