import java.lang.*;

class MyException extends Exception {
    public MyException(String s) {
        super(s);
    }
}
public class Q1_S20220010207 {
    public static void main(String args[]) {
        try {
            int d = 42 / 0; // This will throw an ArithmeticException.
            int[] arr = new int[5];
            arr[6] = 5; // This will throw an ArrayIndexOutOfBoundsException.
            int number = Integer.parseInt("ok"); // This will throw a Number Format Exception.
            String s = new String();
            s = "abcd";
            char m = s.charAt(5); // This will throw a String Index Out Of Bounds Exception.
        } catch (ArithmeticException e) {
            System.out.println("Invalid division");
        } catch (NumberFormatException e) {
            System.out.println("Format mismatch");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is invalid");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Index is invalid");
        }

        try {
            throw new MyException("This is a custom exception");
        } catch (MyException ex) {
            System.out.println("Caught");
            System.out.println(ex.getMessage()); 
        }
    }
}