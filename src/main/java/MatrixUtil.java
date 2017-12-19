import javax.management.InvalidAttributeValueException;

/**
 * Created by redric on 19.10.17.
 *
 * It is the realization of lab 1a for sorting two dimensional matrix MxN.
 */
public class MatrixUtil {

    /**
     * Sort matrix with the help of bubble sorting algorithm. All elements of matrix is checked on being bigger then the
     * second method parameter. If it is smaller, then multiplying is made with element of matrix and this number. If it
     * is bigger or equal, then no action is made. The sorting of matrix is made after checking all the elements.
     *
     * @param matrix    two dimensional matrix with m number of rows and n number of columns
     * @param inNumber  number for multiplying with element of matrix, if it's smaller, then the number
     * @return          sorted matrix
     */
    public int[][] sort(int[][] matrix, int inNumber) {
        int rowLength = matrix[0].length;

        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i].length != rowLength) {
                throw new InvalidMatrixException("Argument is not matrix!");
            }

            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] < inNumber) {
                    matrix[i][j] *= inNumber;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            matrix[i] = this.sortRow(matrix[i], i % 2 == 0);
        }

        return matrix;
    }

    /**
     *Sort the row of matrix with the help of bubble sorting. If the second parameter is true, then sorting is made
     *by ascending. In the other case the sorting is made by descending.
     *
     * @param row           row of matrix to sort
     * @param isAscending   to sort by ascending or by descending
     * @return              sorted row
     */
    private int[] sortRow(int[] row, boolean isAscending) {
        int temp = 0;

        for(int j = 0; j < row.length; j++) {
            for (int k = j; k < row.length; k++) {
                if((row[j] > row[k]) && isAscending) {
                    temp = row[j];
                    row[j] = row[k];
                    row[k] = temp;
                }
                else if((row[j] < row[k]) && !isAscending) {
                    temp = row[j];
                    row[j] = row[k];
                    row[k] = temp;
                }
            }
        }
        return row;
    }
}




