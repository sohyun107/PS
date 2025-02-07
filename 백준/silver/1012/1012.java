import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, M, N, K;
    static int count;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            M = Integer.parseInt(str.nextToken());
            N = Integer.parseInt(str.nextToken());
            K = Integer.parseInt(str.nextToken());
            int count = 0;

            check = new boolean[M][N];
            for (int i = 0; i < K; i++) {
                str = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(str.nextToken());
                int b = Integer.parseInt(str.nextToken());
                check[a][b] = true;
            }

            count = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (check[i][j]) {
                        find(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void find(int row, int col) {
        if (row < 0 || row >= M || col < 0 || col >= N) return;
        if (!check[row][col]) return;

        check[row][col] = false;

        find(row - 1, col);
        find(row + 1, col);
        find(row, col - 1);
        find(row, col + 1);
    }
}