import org.junit.Assert;
import org.junit.Test;

/**
 * Created by redric on 20.10.17.
 *
 * It is tests for the realization of lab 1a.
 */
public class TestMatrixUtil {

    /**
     * Test the sorting of matrix with random unique values of all the parameters.
     */
    @Test
    public void testRandomValues() {
        int[][] expected = new int[][] {{4, 5, 8}, {12, 7, 4}, {5, 9, 10}};
        int[][] actual = new MatrixUtil().sort(new int[][] {{1, 8, 5}, {7, 1, 3}, {5, 10, 9}}, 4);

        Assert.assertArrayEquals(expected, actual);
    }

    /**
     * Test the sorting of matrix with almost equal values in each row.
     */
    @Test
    public void testAlmostEqualValuesInRows() {
        int[][] expected = new int[][] {{40, 60, 60}, {90, 90, 20}, {10, 10, 90}};
        int[][] actual = new MatrixUtil().sort(new int[][]{{6, 4, 6}, {9, 9, 2}, {9, 10, 10}}, 10);

        Assert.assertArrayEquals(expected, actual);
    }

    /**
     * Test the sorting of already sorted matrix.
     */
    @Test
    public void testSortedMatrix() {
        int[][] expected = new int[][] {{3, 4, 6}, {5, 3, 2}, {9, 10, 11}};
        int[][] actual = new MatrixUtil().sort(new int[][] {{3, 4, 6}, {5, 3, 2}, {9, 10, 11}}, 1);

        Assert.assertArrayEquals(expected, actual);
    }

    /**
     * Test the sorting of reversed sorted matrix.
     */
    @Test
    public void testReversedSortedMatrix() {
        int[][] expected = new int[][] {{3, 3, 4, 6}, {8, 5, 3, 2}, {2, 9, 10, 11}};
        int[][] actual = new MatrixUtil().sort(new int[][] {{6, 4, 3, 3}, {2, 3, 5, 8}, {11, 10, 9, 2}}, 2);

        Assert.assertArrayEquals(expected, actual);
    }

    /**
     * Test the sorting of matrix with zero as the second parameter.
     */
    @Test
    public void testZeroInNumber() {
        int[][] expected = new int[][] {{0, 4, 6}, {5, 3, 0}, {9, 10, 11}};
        int[][] actual = new MatrixUtil().sort(new int[][]{{-3, 4, 6}, {5, 3, -2}, {9, 10, 11}}, 0);

        Assert.assertArrayEquals(expected, actual);
    }

    /**
     * Test the sorting of empty matrix where rows has no elements.
     */
    @Test
    public void testEmptyMatrix() {
        int[][] expected = new int[][] {{}, {}, {}};
        int[][] actual = new MatrixUtil().sort(new int[][] {{}, {}, {}}, 100);

        Assert.assertArrayEquals(expected, actual);
    }

    /**
     * Test the sorting of two dimensional array where each row has different length.
     */
    @Test(expected = InvalidMatrixException.class)
    public void testArrayIsNotMatrix() {
        anew MatrixUtil().sort(new int[][]{{2, 4}, {}, {1}}, 3);
    }


}
