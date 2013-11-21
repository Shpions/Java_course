import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //arrays();
        //System.out.print(joinArrays());
        outerArrays();
    }

    /*    // ----------------1

        public static void arrays(){
            int[] arrayOne = {1, 5, 4, 23, 65, 32, 78};
            int[] arrayTwo = {3, 5, 24, 54, 1, 2, 34, 45, 32};
            System.out.println("\n arrayOne:");
            for (int i = 0; i < arrayOne.length ; i++ ) System.out.print(arrayOne[i] + ",");
            System.out.println("\n arrayTwo:" );
            for (int i = 0; i < arrayTwo.length ; i++ ) System.out.print(arrayTwo[i] + ",");
        }
        private static String joinArrays(){
            int[] arrayOne = {1, 5, 4, 23, 65, 32, 78};
            int[] arrayTwo = {3, 5, 24, 54, 1, 2, 34, 45, 32};

            int arraysLenght = arrayOne.length + arrayTwo.length;
            int[] result = new int[arraysLenght];
            for(int i = 0, j = 0; i < arrayOne.length; i++, j++){
                result[j] = arrayOne[i];
            }
            for(int i = 0, j = arrayOne.length; i < arrayTwo.length; i++, j++){
                result[j] = arrayTwo[i];
            }

            //System.out.print("\n Result of concatenation: ");
            //System.out.print(Arrays.toString(result));
            return (Arrays.toString(result));
            }
    */
    //-----------------2
    private static void outerArrays() {
        int[] arrayOne = {1, 5, 4, 23, 65, 32, 78};
        int[] arrayTwo = {3, 5, 24, 54, 1, 2, 34, 45, 32};
        int count = 0;
        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayTwo.length; j++) {
                if (arrayOne[i] == arrayTwo[j]) {
                    count++;
                } else continue;
            }
        }

        int arraysLenght = arrayOne.length + arrayTwo.length - count;
        int[] result = new int[arraysLenght];
        for (int i = 0; i < arraysLenght; i++) {

            for (int i1 = 0, j = 0; i1 < arrayOne.length; i1++, j++) {
                result[j] = arrayOne[i1];
            }

            for (int i2 = 0, j = 0; i2 < arrayTwo.length; i2++, j++) {
                for (int i3 = 0; i3 < arrayOne.length;) {
                    if (arrayTwo[i2] == arrayOne[i3])continue;
                    else result[j] = arrayTwo[i2];
                }
            }
            System.out.println(Arrays.toString(result));
        }

    }


}