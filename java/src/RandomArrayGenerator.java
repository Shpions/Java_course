import java.util.Random;

public class RandomArrayGenerator {
    public static int[] arrayOne = randomArrays();
    public static int[] arrayTwo = randomArrays();

    private static int[] randomArrays(){

        int[] arrayOne;
        Random rand = new Random();
        int randomNumber = 0;
            while (randomNumber == 0){
                randomNumber = rand.nextInt(20);
            }
        arrayOne = new int[randomNumber];
        for(int elementOfArrayOne = 0; elementOfArrayOne < arrayOne.length; elementOfArrayOne++){
            int randomNumberForArrayOne = rand.nextInt(20) - 10;
            arrayOne[elementOfArrayOne] = randomNumberForArrayOne;
        }
        return arrayOne;
    }

}
