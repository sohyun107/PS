/* nextbox[]를 선언하지 않고 큐와 BFS 사용
directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}} 배열로 방향 설정
상하좌우 -1 검사 실시하지 않음 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int M, N;
    static int[][] box;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N + 2][M + 2];

        // 외곽을 -1로 초기화
        for (int i = 0; i < N + 2; i++) {
            Arrays.fill(box[i], -1);
        }

        boolean hasUnripe = false;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
                if (box[i][j] == 0) hasUnripe = true;
            }
        }

        if (!hasUnripe) { // 모든 토마토가 이미 익어 있으면
            System.out.println(0);
            return;
        }

        int days = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int[] direction : directions) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];

                    if (box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            days++;
        }

        if (hasUnripeTomato()) {
            System.out.println(-1);
        }
        else {
            System.out.println(days - 1);
        }
    }

    static boolean hasUnripeTomato() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (box[i][j] == 0) return true;
            }
        }
        return false;
    }
}