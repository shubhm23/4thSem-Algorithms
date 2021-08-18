class SelectionSort{

	void sort(int arr[]){
		int n = arr.length;
		for(int i=0;i<n-1;i++){
			int index = i;
			int min = arr[i];
			for(int j=i+1;j<n;j++){
				if(arr[j] < min){
					index = j;
					min = arr[j];
				}
			}
			swap(arr,index,i);
		}
	}

	void swap(int arr[],int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
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
            SelectionSort ss = new SelectionSort();
			long start = System.nanoTime();
            ss.sort(arr);
            long end = System.nanoTime();
            //printArray(arr);
            System.out.println(range[i] +" "+(end-start));
            //break;
		}

	}
}