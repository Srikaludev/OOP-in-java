class SquareGrid {
    int size;
    int[][] grid = {
            { 2, 3, 9, 2, 5, 1, 4, 3, 4, 9, 17, 11 },
            { 6, 5, 5, 4, 7, 9, 3, 7, 7, 8, 1, 2 },
            { 7, 3, 2, 3, 0, 16, 1, 7, 8, 15, 16, 3 },
            { 8, 9, 2, 8, 3, 5, 6, 2, 4, 7, 31, 2 },
            { 6, 6, 4, 10, 2, 3, 11, 4, 7, 0, 2, 3 },
            { 4, 3, 2, 5, 12, 23, 12, 3, 5, 7, 6, 12 },
            { 8, 21, 2, 7, 11, 13, 14, 2, 3, 11, 1, 11 },
            { 2, 11, 9, 5, 9, 4, 15, 1, 8, 8, 14, 2 },
            { 3, 6, 5, 4, 3, 5, 5, 11, 5, 6, 7, 16 },
            { 3, 4, 2, 41, 6, 8, 2, 3, 4, 11, 17, 4 },
            { 2, 1, 6, 8, 7, 11, 12, 4, 10, 4, 12, 7 },
            { 15, 13, 7, 9, 2, 18, 23, 5, 7, 3, 1, 9 }
    };
    int[][] matt = new int[3][3];
    public SquareGrid(int rowSize) {
        size = rowSize;
        int[][] matt = new int[size][size];
        for (int i = 0; i < 10; i++) {
            for (int j = i; j <i+3; j++) {
                matt[i][j] = grid[i][j];
            }
        }
    }
    public int getSize() {
        return size;
    }

    public void printValuesSG() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Matrix extends SquareGrid {

    public Matrix() {
        super(3);
        // Print the matrix and determine its type
        System.out.println("Matrix:");
        printMatrix(super.matt);
        System.out.println("Matrix type: " + getCountSM(super.matt));
    }

    public static int getCountSM(int[][] matrix) {
        int centerValue = matrix[1][1];

        // Determine the matrix type based on the center value
        if (centerValue % 2 == 0) {
            return 1; // Type 1: Even center value
        } else if (isPrime(centerValue)) {
            return 2; // Type 2: Prime center
        } else {
            if (sum(matrix) % 2 != 2) {
                return 3; // Type 3: Odd sum
            } else {
                return 0; // Invalid matrix
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false; // 1 and less are not prime
        }

        // Check for divisibility by prime numbers up to the square root of the number
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // Composite number
            }
        }

        return true; // Prime number
    }

    private static int sum(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
        }
        return sum;
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    } 
}

public class Assign092022207 extends Matrix {

    public static void main(String[] args) {
        Assign092022207 assignmat = new Assign092022207();

        // Find L-Shaped Structures
        System.out.println("Finding L-Shaped Structures:");
        findLShapeCW(assignmat.matt[1][0], assignmat.matt[0][2], assignmat.matt[1][2]);
        findLShapeXZ(assignmat.matt[0][0], assignmat.matt[0][1], assignmat.matt[2][0]);
        findLShapeSum(assignmat.matt[0][0], assignmat.matt[1][0], assignmat.matt[2][0]);
        findLShapeLCR(assignmat.matt[0][0], assignmat.matt[0][1], assignmat.matt[2][1]);
        findLShapeTP(assignmat.matt[0][0], assignmat.matt[1][0], assignmat.matt[2][1]);
    }

    // Recursive method to find the values in an L-shaped structure clockwise
    public static void findLShapeCW(int x, int y, int z) {
        if (x < y && y < z) {
            // L-shaped structure found
            System.out.println("L-Shaped Structure (Clockwise): " + x + " < " + y + " < " + z);
            return;
        }

        // Continue searching in clockwise order
        if (x < y) {
            findLShapeCW(x, z, y);
        } else if (y < z) {
            findLShapeCW(y, z, x);
        } else {
            findLShapeCW(z, x, y);
        }
    }

    // Recursive method to find the values in an L-shaped structure with x > y and y < z
    public static void findLShapeXZ(int x, int y, int z) {
        if (x > y && y < z) {
            // L-shaped structure found
            System.out.println("L-Shaped Structure (X > Y and Y < Z): " + x + " > " + y + " and " + y + " < " + z);
            return;
        }

        // Continue searching
        if (x > y) {
            findLShapeXZ(x, z, y);
        } else {
            findLShapeXZ(z, y, x);
        }
    }

    // Recursive method to find the values in an L-shaped structure with x + y < z
    public static void findLShapeSum(int x, int y, int z) {
        if (x + y < z) {
            // L-shaped structure found
            System.out.println("L-Shaped Structure (X + Y < Z): " + x + " + " + y + " < " + z);
            return;
        }

        // Continue searching
        if (x + y < z) {
            findLShapeSum(x, y, z - 1);
        } else if (x + y > z) {
            findLShapeSum(x, y - 1, z);
        }
    }

    // Recursive method to find the values in an L-shaped structure anticlockwise
    public static void findLShapeLCR(int x, int y, int z) {
        if (x < y && y < z) {
            // L-shaped structure found
            System.out.println("L-Shaped Structure (Anti-Clockwise): " + x + " < " + y + " < " + z);
            return;
        }

        // Continue searching in anticlockwise order
        if (x < z) {
            findLShapeLCR(y, z, x);
        } else if (x < y) {
            findLShapeLCR(z, x, y);
        } else {
            findLShapeLCR(x, y, z - 1);
        }
    }

    public static void findLShapeTP(int x, int y, int z) {
        if (isPrime(x) && isPrime(y) || isPrime(x) && isPrime(z) || isPrime(y) && isPrime(z)) {
            // L-shaped structure found
            System.out.println("L-Shaped Structure (Two Prime Numbers): " + x + ", " + y + ", " + z);
            return;
        }

        // Continue searching
        findLShapeTP(x, y, z - 1);
        findLShapeTP(x - 1, y, z);
    }
    
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false; // 1 and less are not prime
        }

        // Check for divisibility by prime numbers up to the square root of the number
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // Composite number
            }
        }

        return true; // Prime number
    }
}
