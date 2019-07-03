package cn.zciel.class03;

/**
 * @author YINZHEN
 * @date 2019/7/1 16:07
 * @Description 螺旋打印矩阵
 * 先确定左上点和右下点，先打出边框，然后向内调整点的位置，循环打印
 */
public class Code_06_PrintMatrixSpiralOrder {

    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private static void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        if (tR == dR) {  //TODO
            for (int i = tC; i < dC; i++) {
                System.out.println(matrix[tR][i]);
            }
        } else if (tC == dC) {
            for (int i = tR; i < dR; i++) {
                System.out.println(matrix[i][tC]);
            }
        } else {
            int curR = tR;
            int curC = tC;
            while (curC != dC) {
                System.out.print(matrix[tR][curC] + " ");
                curC++;
            }
            while (curR != dR) {
                System.out.print(matrix[curR][dC] + " ");
                curR++;
            }
            while (curC != tC) {
                System.out.print(matrix[dR][curC] + " ");
                curC--;
            }
            while (curR != tR) {
                System.out.print(matrix[curR][tC] + " ");
                curR--;
            }

        }


    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        spiralOrderPrint(matrix);

    }


}
