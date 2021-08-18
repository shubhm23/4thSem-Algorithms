class Quicksort{
	
	public void sort(int[]arr,int begin,int end){
		if(begin < end){
			int partitionIndex = partition(arr,begin,end);
			sort(arr,begin,partitionIndex-1);
			sort(arr,partitionIndex+1,end);
		}
	}

	public int partition(int arr[],int begin,int end){
		int pivot = arr[end];
		int i = begin-1;

		for(int j=begin;j<end;j++){
			if(arr[j] <= pivot){
				i++;
				swap(i,j,arr);
			}
		}

		swap(i+1,end,arr);
		return i+1;
	}

	public void swap(int i,int j,int[]arr){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void printArr(int arr[]){
		for(int x: arr)
			System.out.print(x + " ");
	}

	public static void main(String[] args) {
		int n = 100;
		int []arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = (int)(Math.random() * n);
		}
		Quicksort qs = new Quicksort();
		qs.sort(arr,0,n-1);
		printArr(arr);
	}
}