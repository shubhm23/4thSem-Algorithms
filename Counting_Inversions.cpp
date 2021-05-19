//Count Inversions of an Array : https://www.cp.eng.chula.ac.th/~prabhas//teaching/algo/algo2008/count-inv.htm

//The idea is similar to "merge" in merge-sort. Merge two sorted lists into one output list, but we also count the inversion.

#include<iostream>
using namespace std;

int merge(int arr[],int l,int m,int r)
{
	int n1 = m-l+1;
	int n2 = r-m;
	int count = 0;

	int L[n1],R[n2];

	for(int i=0;i<n1;++i)
		L[i] = arr[l+i];
	for(int j=0;j<n2;++j)
		R[j] = arr[m+1+j];
	
	int i = 0;
	int j = 0;
	int k = l;

	while(i < n1 && j < n2){
		if(L[i] <= R[j]){
			arr[k] = L[i];
			i++;
		}
		else{
			count += n1-i;
			arr[k] = R[j];
			j++;
		}
		k++;
	}

	while(i < n1){
		arr[k] = L[i];
		k++;
		i++;
	}

	while(j < n2){
		arr[k] = R[j];
		k++;
		j++;
	}
	return count;
}

int mergeSort(int arr[],int l,int r){
	if(l >= r)
		return 0;
	int m = l + (r - l)/2;
	int r1 = mergeSort(arr,l,m);
	int r2 = mergeSort(arr,m+1,r);
	int p = merge(arr,l,m,r);
	return r1+r2+p;
}

int main(){
	int n = 8;
	int arr[n] = {8,3,2,9,7,1,5,4};
	int res = mergeSort(arr,0,7);
	for(int i : arr){
		cout<<i<<"\t";
	}
	cout<<"\n"<<"Number of Inversions: "<<res<<"\n";
}

//Written by: Shubham Prasad