package cn.zciel.class03;

/**
 * @author YINZHEN
 * @date 2019/7/2 10:26
 * @Description 之字形打印矩阵
 */

/**
 * 1.设置两个点A,B
 * 2.A和B分别向右向下移动沿着边界
 * 3.移动到右下角为止
 */
public class Code_08_ZigZagPrintMatrix {

    public static void printMatrixZigZag(int[][] matrix) {
        int tR = 0;//向下
        int tC = 0;
        int dR = 0;//向右
        int dC = 0;
        int endR = matrix.length - 1; //下侧的底部
        int endC = matrix[0].length - 1; //右侧的底部
        boolean fromUp = false; //翻转标识 从上到下true
        while (tR != endR + 1) {
            printLevel(matrix, tR, tC, dR, dC, fromUp);
            //调整位置
            tR = tC == endC ? ++tR : tR;
            tC = tC == endC ? tC : ++tC;
            dC = dR == endR ? ++dC : dC;
            dR = dR == endR ? dR : ++dR;
            fromUp = !fromUp;
        }
        System.out.println();

    }

    private static void printLevel(int[][] matrix, int tR, int tC, int dR, int dC, boolean fromUp) {

        if (fromUp) {  //从上到下
            while (tR != dR + 1) {
                System.out.print(matrix[tR++][tC--] + " ");
            }
        } else { //从下到上
            while (dR != tR - 1) {
                System.out.print(matrix[dR--][dC++] + " ");
            }
        }
        /*if (fromUp) {  //从上到下
            while (dR != tR + 1) {
                System.out.print(matrix[dR++][dC--] + " ");
            }
        } else { //从下到上
            while (tR != dR - 1) {
                System.out.print(matrix[tR--][tC++] + " ");
            }
        }*/

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        printMatrixZigZag(matrix);
    }


}
