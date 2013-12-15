import java.util.Random;

public class RandomArrayGenerator {
    //local code review (vtegza): initiate arrays where you actually need to use them (Main) @ 15.12.13
    public static int[] arrayOne = randomArrays();
    public static int[] arrayTwo = randomArrays();

    //local code review (vtegza): make it public and use this class as Utility class @ 15.12.13
    private static int[] randomArrays(){

        //local code review (vtegza): declare int where you actually use it(#20) @ 15.12.13
        int[] arrayOne;
        Random rand = new Random();
        //local code review (vtegza): name it accordingly ex: randomSize @ 15.12.13
        int randomNumber = 0;
        //local code review (vtegza): no need in this loop @ 15.12.13
            while (randomNumber == 0){
                randomNumber = rand.nextInt(7);
            }
        arrayOne = new int[randomNumber];
        for(int elementOfArrayOne = 0; elementOfArrayOne < arrayOne.length; elementOfArrayOne++){
            int randomNumberForArrayOne = rand.nextInt(10) - 5;
            arrayOne[elementOfArrayOne] = randomNumberForArrayOne;
        }
        return arrayOne;
    }

}
