import java.util.*;

class Sorting {

    //Bubble Sort
    public static int[] BubbleSort(int ar[],int n){
        if(n==0) return ar;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(ar[j]>ar[j+1]){
                    int temp=ar[j];
                    ar[j]=ar[j+1];
                    ar[j+1]=temp;
                }
            }
        }
        return ar;
    }

    //Selection Sort
    public static int[] SelectionSort(int ar[],int n){
        if(n==0) return ar;

        for(int i=0;i<n-1;i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                if(ar[j]<ar[min]) min=j;
            }
            int temp=ar[i];
            ar[i]=ar[min];
            ar[min]=temp;
        }
        return ar;
    }

    //Insertion Sort
    public static int[] InsertionSort(int ar[],int n){
        if(n==0) return ar;

        for(int i=1;i<n;i++){
            int key=ar[i];
            int j=i-1;
            while(j>=0 && ar[j]>key){
                ar[j+1]=ar[j];
                j--;
            }
            ar[j+1]=key;
        }
        return ar;
    }

    //Quick Sort
    public static void QuickSort(int ar[],int low,int high){
        if(low<high){
            int pi=Partition(ar,low,high);
            QuickSort(ar, low, pi-1);
            QuickSort(ar, pi+1, high);
        }
    }

    public static int Partition(int ar[],int low,int high){
        int pivot=ar[high];
        int i=low-1;

        for(int j=low;j<high;j++){
            if(ar[j]<pivot){
                i++;
                int temp=ar[i];
                ar[i]=ar[j];
                ar[j]=temp;
            }
        }
        int temp=ar[i+1];
        ar[i+1]=ar[high];
        ar[high]=temp;
        return i+1;
    }



    //*** Merge Sort

    public static void MergeSort(int ar[],int l,int r){
        if(l<r){
            int mid=(l+r)/2;

            MergeSort(ar,l,mid);
            MergeSort(ar,mid+1,r);

            merge(ar, l,mid,r);
        }
    }

    public static void merge(int ar[],int l,int mid,int r){
        int n1=mid-l+1;
        int n2=r-mid;

        int lArr[]=new int[n1];
        int rArr[]=new int[n2];

        for(int x=0;x<n1;x++) lArr[x]=ar[l+x];

        for(int x=0;x<n2;x++) rArr[x]=ar[mid+1+x];

        int i=0,j=0,k=l;

        while (i<n1 && j<n2) {
            if(lArr[i] <= rArr[j]){
                ar[k]=lArr[i];
                i++;
            }
            else{
                ar[k]=rArr[j];
                j++;
            }
            k++;
        }

        while (i<n1) {
            ar[k]=lArr[i];
            i++;
            k++;
        }

        while (j<n2) {
            ar[k]=rArr[j];
            j++;
            k++;
        }

    }



    public static void main(String args[]){
        int ar1[]={10,6,1,50,7,9,16};
        int n=ar1.length;
        
        BubbleSort(ar1, n);
        System.out.println("Bubble Sort: ");
        for(int i=0;i<n;i++){
            System.out.print(ar1[i]+" ");
        }
        System.out.println();


        int ar2[]={10,6,1,50,7,9,16};
        SelectionSort(ar2,n);
        System.out.println("Selections Sort: ");
        for(int i=0;i<n;i++){
            System.out.print(ar2[i]+" ");
        }
        System.out.println();

        int ar3[]={10,6,1,50,7,9,16};
        InsertionSort(ar3,n);
        System.out.println("Insertion Sort: ");
        for(int i=0;i<n;i++){
            System.out.print(ar3[i]+" ");
        }
        System.out.println();
        
        int ar4[]={10,6,1,50,7,9,16};
        QuickSort(ar4,0,n-1);
        System.out.println("Quick Sort: ");
        for(int i=0;i<n;i++){
            System.out.print(ar4[i]+" ");
        }
        System.out.println();

        int ar5[]={10,6,1,50,7,9,16};
        MergeSort(ar5, 0, n-1);
        System.out.println("Merge Sort: ");
        for(int i=0;i<n;i++){
            System.out.print(ar5[i]+" ");
        }
        System.out.println();

    }
}
