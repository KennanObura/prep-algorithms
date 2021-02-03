package kennan.co.ke.arrays;

public class SecondLargestNumber {
    public static void main(String[] args) {
        int [] array = {1,3,2,5,4};
        System.out.println(solve(array));
    }

    private static int solve(int [] array){

        int largest = 0;
        int secondLargest = largest;

        for(int i: array) {
            if (i > largest) {
                secondLargest = largest;
                largest = i;
            }else if(i > secondLargest)
                secondLargest = i;
        }
        return secondLargest;
    }

}
