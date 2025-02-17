/* 시간초과 소스코드 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int p = arr[i][1];
            int q = 1;

            for(int j = 1; j < N; j++){
                if(p <= arr[j][0]){
                    p = arr[j][1];
                    q++;
                }
            }
            if(cnt < q) cnt = q;
        }

        System.out.println(cnt);
    }
}
