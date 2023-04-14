public class Main {
    public static void main(String[] Args){

        int arr[] = new int[7];

        arr[0] = 101;
        arr[1] = 21;
        arr[2] = 11;
        arr[3] = 51;
        arr[4] = 10;
        arr[5] = 77;
        arr[6] = 17;
        

        int size = 7;
        //bubble sort 

        for(int i = 1 ; i< size ; i++){
            boolean swap = false;
            for(int j = 0 ; j<(size-i) ; j++){
                if(arr[j] > arr[j+1]){

                    //Swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            } 
            if(swap == false){

                //It means array is already sorted
                break;
            }
        }

        System.out.println("Sorted Array is : ");

        for(int i = 0 ; i< size ; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        //Using binary search to find index of element 51

        int value = 51;

        int index = -1;


        int start = 0;
        int end = size ;
        int mid = (start+end)/2;

        while(start <= end){
        if(arr[mid]==value){
            index =  mid;
            break;
        }
        else if(arr[mid]>value){
            end = mid-1;
        }
        else{
            start = mid+1;
        }
        mid = (start+end)/2;
        }

        System.out.println("Element 51 is present at index : " + index);

    }
}

