import java.util.Arrays;

//local code review (vtegza): in most of cases main class should not extends other functionality @ 15.12.13

public class Main extends RandomArrayGenerator {

    public static void main(String[] args) {
       /*
        get(arrayOne,"Array one is: ");
        get(arrayTwo,"Array two is: ");
        mergeArrays(arrayOne,arrayTwo);
        innerJoin(arrayOne,arrayTwo);
        outerJoin(arrayOne,arrayTwo);
        rightJoin(arrayOne,arrayTwo);
        */
        //local code review (vtegza): Country is not in VCS @ 15.12.13
    Country[] arrayOne = {new Country.Builder().code("FR").description("France").build(),
            new Country.Builder().code("US").description("USA").build(),
            new Country.Builder().code("RUS").description("Russia").build()};

    Country[] arrayTwo = {new Country.Builder().code("It").description("Italy").build(),
            new Country.Builder().code("CA").description("Canada").build(),
            new Country.Builder().code("GR").description("Germany").build()};

    //merge(arrayOne,arrayTwo);
        System.out.println(merge(arrayOne,arrayTwo).toString());


    Country country = new Country.Builder().code("UA").build();
    Country country2 = new Country.Builder().code("FR").description("France").build();
    Country countryCopy = new Country.Builder(country2).description("new").build();
    System.out.println(country.toString());
    System.out.println(country2.toString());
    System.out.println(countryCopy.toString());
    }

    //---------get method
    //local code review (vtegza): get method should always return value @ 15.12.13
    public static void get(int []array,String b){
        System.out.println(b + Arrays.toString(array));
    }


    public static Country[] merge(Country[] arrayOne, Country[] arrayTwo){
       int countryLength = arrayOne.length + arrayTwo.length;
       Country[] result = new Country[countryLength];
       int count = arrayOne.length;
       for(int i = 0; i < arrayOne.length; i++) {
           result[i] = arrayOne[i];
       }
       for(int i = 0; i < arrayTwo.length; i++){
           result[count] = arrayTwo[i];
           count++;
       }

       return result;
    }

    //---------------left join
    private static int[] mergeArrays(int[] arrayOne, int []arrayTwo) {
        int count = 0;

        //local code review (vtegza): foreach @ 15.12.13
        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayTwo.length; j++) {
                if (arrayOne[i] == arrayTwo[j]) count++;
            }
        }
//------remove count and fix logic for indexes out of array length
        int resultArrayLength = arrayOne.length + arrayTwo.length;
        int[] resultOld = new int[resultArrayLength];

        //local code review (vtegza): use Array copy @ 15.12.13
        for (int elementOfArrayOne = 0; elementOfArrayOne < arrayOne.length; elementOfArrayOne++) {
            resultOld[elementOfArrayOne] = arrayOne[elementOfArrayOne];
        }

        int elementOfArrayResult = arrayOne.length;;
        //local code review (vtegza): foreach @ 15.12.13
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
        //local code review (vtegza): use array copy @ 15.12.13
        for (int elementOfResultFinal = 0; elementOfResultFinal < result.length; elementOfResultFinal++){
            result[elementOfResultFinal] = resultOld[elementOfResultFinal];
        }
        get(result,"Merge without duplicates: ");
        return result;

    }

   //-------------------Inner Join
    private static void innerJoin(int[] arrayOne, int []arrayTwo){

    //find count of common element
        int countCommonElement = 0;
        //local code review (vtegza): foreach @ 15.12.13
        for (int elementOfArrayOne = 0; elementOfArrayOne < arrayOne.length; elementOfArrayOne++){
            //local code review (vtegza): foreach @ 15.12.13
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
            //local code review (vtegza): foreach @ 15.12.13
          for(int elementOfArrayOne = 0; elementOfArrayOne < arrayOne.length; elementOfArrayOne++){
              //local code review (vtegza): foreach @ 15.12.13
              for(int elementOfArrayTwo = 0; elementOfArrayTwo < arrayTwo.length; elementOfArrayTwo++){
                  if(arrayOne[elementOfArrayOne] == arrayTwo[elementOfArrayTwo]){
                      result[elementOfArrayResult] = arrayOne[elementOfArrayOne];
                      elementOfArrayResult++;
                      break;
                  }
                  //local code review (vtegza): no need in continue here @ 15.12.13
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
        //local code review (vtegza): foreach @ 15.12.13
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
        //local code review (vtegza): foreach @ 15.12.13
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
        //local code review (vtegza): use array copy @ 15.12.13
        for (int elementOfResultFinal = 0; elementOfResultFinal < result.length; elementOfResultFinal++){
            result[elementOfResultFinal] = resultOld[elementOfResultFinal];
        }
        get(result,"Outer join: ");
    }


    //-------------------Right Join
    private static void rightJoin(int[] arrayOne, int []arrayTwo){

        //find count of common element
        int countCommonElement = 0;
        //local code review (vtegza): foreach @ 15.12.13
        for (int elementOfArrayOne = 0; elementOfArrayOne < arrayOne.length; elementOfArrayOne++){
            //local code review (vtegza): foreach @ 15.12.13
            for(int elementOfArrayTwo = 0; elementOfArrayTwo < arrayTwo.length; elementOfArrayTwo++){
                if(arrayOne[elementOfArrayOne] == arrayTwo[elementOfArrayTwo]){
                    countCommonElement++;
                    break;
                }
                //local code review (vtegza): no need in continue here @ 15.12.13
                else continue;
            }
        }
        //initialize and create array of common element
        int[] result = new int[countCommonElement];
        for (int elementOfArrayResult = 0; elementOfArrayResult < result.length; elementOfArrayResult++){
            //local code review (vtegza): foreach @ 15.12.13
            for(int elementOfArrayOne = 0; elementOfArrayOne < arrayOne.length; elementOfArrayOne++){
                //local code review (vtegza): foreach @ 15.12.13
                for(int elementOfArrayTwo = 0; elementOfArrayTwo < arrayTwo.length; elementOfArrayTwo++){
                    if(arrayOne[elementOfArrayOne] == arrayTwo[elementOfArrayTwo]){
                        result[elementOfArrayResult] = arrayOne[elementOfArrayOne];
                        elementOfArrayResult++;
                        break;
                    }
                    //local code review (vtegza): no need in continue here @ 15.12.13
                    else continue;
                }
            }
        }

        int[] merge = new int[result.length + arrayTwo.length];
        for(int elementsOfMerge = 0; elementsOfMerge < merge.length; elementsOfMerge++){
            //local code review (vtegza): foreach @ 15.12.13
            for(int elementOfResult = 0; elementOfResult < result.length; elementOfResult++){
                merge[elementsOfMerge] = result[elementOfResult];
                elementsOfMerge++;
            }
            //local code review (vtegza): foreach @ 15.12.13
            for(int elementsOfArrayTwo = 0; elementsOfArrayTwo < arrayTwo.length; elementsOfArrayTwo++){
                merge[elementsOfMerge] = arrayTwo[elementsOfArrayTwo];
                elementsOfMerge++;
            }
        }
         get(merge,"Right join: ");
    }

}
