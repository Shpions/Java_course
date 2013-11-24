import java.util.Arrays;

public class Main extends RandomArrayGenerator {

    public static void main(String[] args) {
        get(arrayOne,"Array one is: ");
        get(arrayTwo,"Array two is: ");
        mergeArrays(arrayOne,arrayTwo);
        innerJoin(arrayOne,arrayTwo);
        outerJoin(arrayOne,arrayTwo);
    }

    //
    public static void get(int []array,String b){
        System.out.println(b + Arrays.toString(array));
    }
    //---------------Merge without duplicates
    private static void mergeArrays(int[] arrayOne, int []arrayTwo) {
        int count = 0;

        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayTwo.length; j++) {
                if (arrayOne[i] == arrayTwo[j]) count++;
            }
        }
//------remove count and fix logic for indexes out of array length
        int resultArrayLength = arrayOne.length + arrayTwo.length;
        int[] resultOld = new int[resultArrayLength];

        for (int elementOfArrayOne = 0; elementOfArrayOne < arrayOne.length; elementOfArrayOne++) {
            resultOld[elementOfArrayOne] = arrayOne[elementOfArrayOne];
        }

        int elementOfArrayResult = arrayOne.length;;

        for (int elementOfArrayTwo = 0; elementOfArrayTwo < arrayTwo.length; elementOfArrayTwo++){
            for(int elementOfArrayOne = 0; elementOfArrayOne < arrayOne.length; elementOfArrayOne++){
                if(arrayTwo[elementOfArrayTwo]!= arrayOne[elementOfArrayOne]){
                    if(elementOfArrayOne + 1 == arrayOne.length && elementOfArrayResult < resultOld.length){
                        resultOld[elementOfArrayResult] = arrayTwo[elementOfArrayTwo];
                        elementOfArrayResult++;
                        break;
                    }
                }
                else break;
            }
        }
        //create and fill array by unique value from array resultOld
        int[] result = new int[elementOfArrayResult];
        for (int elementOfResultFinal = 0; elementOfResultFinal < result.length; elementOfResultFinal++){
            result[elementOfResultFinal] = resultOld[elementOfResultFinal];
        }

        get(resultOld,"Merge without duplicates: ");
    }

   //-------------------Inner Join
    private static void innerJoin(int[] arrayOne, int []arrayTwo){

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
        get(result,"Inner join: ");
    }

    //-----------------Outer join
    public static void outerJoin(int[] arrayOne, int []arrayTwo){
        int[] resultOld = new int[arrayOne.length + arrayTwo.length];
        int elementOfResult = 0;
        //fill array by unique value from arrayOne
        for(int elementOfArrayOne = 0; elementOfArrayOne < arrayOne.length; elementOfArrayOne++) {
            for ( int elementOfArrayTwo = 0; elementOfArrayTwo < arrayTwo.length; elementOfArrayTwo++){
                if(arrayOne[elementOfArrayOne] != arrayTwo[elementOfArrayTwo]){
                    if((elementOfArrayTwo + 1) == arrayTwo.length){
                        resultOld[elementOfResult] = arrayOne[elementOfArrayOne];
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
                        resultOld[elementOfResult] = arrayTwo[elementOfArrayTwo];
                        elementOfResult++;
                    }
                }
                else break;
            }
        }
        //create and fill array by unique value from array resultOld
        int[] result = new int[elementOfResult];
        for (int elementOfResultFinal = 0; elementOfResultFinal < result.length; elementOfResultFinal++){
            result[elementOfResultFinal] = resultOld[elementOfResultFinal];
        }
        get(result,"Outer join: ");
    }
}