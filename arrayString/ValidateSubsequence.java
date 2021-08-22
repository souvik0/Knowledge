package arrayString;
// Sam logic can also be applicable for sub array check.
public class ValidateSubsequence {

    public static void main(String[] args) {
        int[] array = {5,1,22,25,6,-1,8,10};
        int[] sequenceArray = {1,6,-1,10};
        System.out.println(validateSubsequenceArray(array, sequenceArray));
    }

    public static boolean validateSubsequenceArray(int[] array, int[] sequenceArray) {
       int counter = 0;
       for (int i = 0; i< array.length; i++) {
           int currentElement = array[i];
           // This check has to be on counter position
           if (sequenceArray[counter] == currentElement) {
               counter++;
           }
           // This check has to be here to check end the loop as soon as we reach end of sequence array
           if (counter == sequenceArray.length) {
               return true;
           }
       }
       return false;
    }
}
