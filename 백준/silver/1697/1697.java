import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] time = new int[100001];
        Arrays.fill(time, -1); // 방문하지 않은 위치 -1로 초기화

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        time[N] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) {
                break;
            }


            int[] moves = {current - 1, current + 1, current * 2};   // -1, +1, *2

            for (int i = 0; i < 3; i++) {
                int nextPos = moves[i];

                if (nextPos >= 0 && nextPos <= 100000 && time[nextPos] == -1) {
                    queue.offer(nextPos);
                    time[nextPos] = time[current] + 1;
                }
            }
        }
        System.out.println(time[K]);
    }
}
