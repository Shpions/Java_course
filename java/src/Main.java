import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        outerArrays();
        innerJoin();
        outerJoin();
    }
    //---------------Merge without duplicates
    private static void outerArrays() {
        int[] arrayOne = {1, 5, 4, 23, 65, 32, 78};
        int[] arrayTwo = {3, 5, 24, 54, 1, 2, 34, 45, 32};
        int count = 0;

        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayTwo.length; j++) {
                if (arrayOne[i] == arrayTwo[j]) count++;
            }
        }

        int resultArrayLength = arrayOne.length + arrayTwo.length - count;
        int[] result = new int[resultArrayLength];

        for (int elementOfArrayOne = 0; elementOfArrayOne < arrayOne.length; elementOfArrayOne++) {
            result[elementOfArrayOne] = arrayOne[elementOfArrayOne];
        }

        int elementOfArrayResult = arrayOne.length;;

        for (int elementOfArrayTwo = 0; elementOfArrayTwo < arrayTwo.length; elementOfArrayTwo++){
            for(int elementOfArrayOne = 0; elementOfArrayOne < arrayOne.length; elementOfArrayOne++){
                if(arrayTwo[elementOfArrayTwo]!=arrayOne[elementOfArrayOne]){
                    if(elementOfArrayOne + 1 == arrayOne.length){
                        result[elementOfArrayResult]=arrayTwo[elementOfArrayTwo];
                        elementOfArrayResult++;
                        break;
                    }
                }
                else break;
            }
        }
        System.out.println("Array one is: " + Arrays.toString(arrayOne));
        System.out.println("Array two is: " + Arrays.toString(arrayTwo));
        System.out.print("Merge without duplicates: ");
        System.out.println(Arrays.toString(result));
    }

   //-------------------Inner Join
    private static void innerJoin(){
        int arrayOne[] ={1,5,4,23,65,32,78};
        int arrayTwo[] ={3,5,24,4,1,2,34,45,32,5};

    //find count of common element
        int countCommonElement = 0;
        for (int elementOfArrayOne = 0; elementOfArrayOne < arrayOne.length; elementOfArrayOne++){
            for(int elementOfArrayTwo = 0; elementOfArrayTwo < arrayTwo.length; elementOfArrayTwo++){
                if(arrayOne[elementOfArrayOne] == arrayTwo[elementOfArrayTwo]){
                    countCommonElement++;
                    break;
                }
                else continue;
            }
        }
    //initialize and create array of common element
        int[] result = new int[countCommonElement];
        for (int elementOfArrayResult = 0; elementOfArrayResult < result.length; elementOfArrayResult++){
          for(int elementOfArrayOne = 0; elementOfArrayOne < arrayOne.length; elementOfArrayOne++){
              for(int elementOfArrayTwo = 0; elementOfArrayTwo < arrayTwo.length; elementOfArrayTwo++){
                  if(arrayOne[elementOfArrayOne] == arrayTwo[elementOfArrayTwo]){
                      result[elementOfArrayResult] = arrayOne[elementOfArrayOne];
                      elementOfArrayResult++;
                      break;
                  }
                  else continue;
              }
          }
        }
        System.out.println("\nArray one is: " + Arrays.toString(arrayOne));
        System.out.println("Array two is: " + Arrays.toString(arrayTwo));
        System.out.print("Inner join: ");
        System.out.println(Arrays.toString(result));
    }

    //-----------------Outer join
    public static void outerJoin(){
        int[] arrayOne = {1,5,4,23,65,32,78};
        int[] arrayTwo = {3,5,24,4,1,2,34,45,32,5};
        int[] arrayExpected = {23,65,78,3,24,2,34,45};
        int[] result = new int[arrayOne.length + arrayTwo.length];
        int elementOfResult = 0;
        //fill array by unique value from arrayOne
        for(int elementOfArrayOne = 0; elementOfArrayOne < arrayOne.length; elementOfArrayOne++) {
            for ( int elementOfArrayTwo = 0; elementOfArrayTwo < arrayTwo.length; elementOfArrayTwo++){
                if(arrayOne[elementOfArrayOne] != arrayTwo[elementOfArrayTwo]){
                    if((elementOfArrayTwo + 1) == arrayTwo.length){
                        result[elementOfResult] = arrayOne[elementOfArrayOne];
                        elementOfResult++;
                    }
                }
                else break;
            }
        }
        //fill array by unique value from arrayTwo
        for(int elementOfArrayTwo = 0; elementOfArrayTwo < arrayTwo.length; elementOfArrayTwo++) {
            for ( int elementOfArrayOne = 0; elementOfArrayOne < arrayOne.length; elementOfArrayOne++){
                if(arrayOne[elementOfArrayOne] != arrayTwo[elementOfArrayTwo]){
                    if((elementOfArrayOne + 1) == arrayOne.length){
                        result[elementOfResult] = arrayTwo[elementOfArrayTwo];
                        elementOfResult++;
                    }
                }
                else break;
            }
        }
        //create and fill array by unique value from array result
        int[] resultFinal = new int[elementOfResult];
        for (int elementOfResultFinal = 0; elementOfResultFinal < resultFinal.length; elementOfResultFinal++){
            resultFinal[elementOfResultFinal] = result[elementOfResultFinal];
        }
        System.out.println("\nArray one is: " + Arrays.toString(arrayOne));
        System.out.println("Array two is: " + Arrays.toString(arrayTwo));
        System.out.print("Outer join: ");
        System.out.println(Arrays.toString(resultFinal));
    }
}