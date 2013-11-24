import java.util.Random;

public class RandomArrayGenerator {
    public static int[] arrayOne = randomArraysOne();
    public static int[] arrayTwo = randomArraysTwo();

    private static int[] randomArraysOne(){

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

    private static int[] randomArraysTwo(){

        int[] arrayTwo;
        Random rand = new Random();
        int randomNumber = 0;
            while (randomNumber == 0){
                randomNumber = rand.nextInt(20);
            }
        arrayTwo = new int[randomNumber];
        for(int elementOfArrayTwo = 0; elementOfArrayTwo < arrayTwo.length; elementOfArrayTwo++){
            Random random = new Random();
            int randomNumberForArrayTwo = random.nextInt(20) - 10;
            arrayTwo[elementOfArrayTwo] = randomNumberForArrayTwo;
        }
        return arrayTwo;
    }
}
