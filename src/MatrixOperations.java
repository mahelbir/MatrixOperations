import java.util.Random;

public class MatrixOperations {

    /**
     * Main method
     */
    public static void main(String[] args) {
        int[][] matrix1 = createMatrix();
        int[][] matrix2 = createMatrix();
        int[][] transposed1 = transposeMatrix(matrix1);
        int[][] transposed2 = transposeMatrix(matrix2);
        int[][] sum = mathMatrices(matrix1, matrix2, "sum");
        int[][] sub = mathMatrices(matrix1, matrix2, "sub");
        int[][] multi = mathMatrices(matrix1, matrix2, "multi");

        System.out.println("*************** First Matrix ****************");
        printMatrix(matrix1);
        System.out.println("********* Transpose of First Matrix *********");
        printMatrix(transposed1);

        System.out.println("\n");

        System.out.println("*************** Second Matrix ***************");
        printMatrix(matrix2);
        System.out.println("******** Transpose of Second Matrix *********");
        printMatrix(transposed2);

        System.out.println("\n");

        System.out.println("***************** Summation *****************");
        printMatrix(sum);

        System.out.println("\n");

        System.out.println("**************** Subtraction ****************");
        printMatrix(sub);

        System.out.println("\n");

        System.out.println("************** Multiplication ***************");
        printMatrix(multi);
    }


    /**
     * Create a matrix
     */
    public static int[][] createMatrix() {
        int[][] matrix = new int[4][4];
        Random rand = new Random();

        //Double loop to create matrix
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //Generate a random value from 1-30 for each element of matrix
                matrix[i][j] = rand.nextInt(30) + 1;
            }
        }

        return matrix;
    }


    /**
     * Transpose the matrix
     */
    public static int[][] transposeMatrix(int[][] matrix) {
        int[][] transposed = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //Swap keys
                transposed[j][i] = matrix[i][j];
            }
        }

        return transposed;
    }


    /**
     * Print the matrix
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] elemEx :
                matrix) {
            System.out.print("[");
            for (int elemIn :
                    elemEx) {
                String spaces = "";

                //Get digit count of element
                int elemInLength = ("" + elemIn).length();

                //Add spaces by digit count of element
                int spaceCount = 7 - elemInLength;
                for (int i = 0; i < spaceCount; i++) {
                    spaces += " ";
                }

                System.out.print(spaces + elemIn);
            }
            System.out.println("]");
        }
    }


    /**
     * Mathematical operations
     */
    public static int[][] mathMatrices(int[][] matrix1, int[][] matrix2, String mathOperation) {
        int[][] newMatrix = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (mathOperation == "sum") {
                    //Summation
                    newMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                } else if (mathOperation == "sub") {
                    //Subtraction
                    newMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
                } else {
                    //Multiplication
                    for (int k = 0; k < 4; k++) {
                        newMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
        }

        return newMatrix;
    }

}
