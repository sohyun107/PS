import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 정점개수 N
        int M = Integer.parseInt(st.nextToken());   // 간선개수 M

        graph = new ArrayList[N + 1];   // 인접리스트 배열 -> 1~N번까지 사용하므로 N+1 크기
        visited = new boolean[N + 1];   // 방문여부 배열 -> 0번 인덱스는 미사용

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();  // 정점에 대해 ArrayList 객체 할당
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        int count = 0;

        for (int i = 1; i <= N; i++) {   // bfs 탐색
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph[node]) {   // 현재 노드와 연결된 모든 노드들 탐색
                if (!visited[next]) {
                    visited[next] = true;  // 미방문노드 방문처리
                    queue.offer(next);
                }
            }
        }
    }
}