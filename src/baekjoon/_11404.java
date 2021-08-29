package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class _11404 {
        
    public static int cityCount;
    public static int[][] distance;
    public static final int INF = 1000000000;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        cityCount = Integer.parseInt(br.readLine());
        
        int busCount = Integer.parseInt(br.readLine());
        
        distance = new int[cityCount+1][cityCount+1];
        
        for(int i=1; i <= cityCount; i++) {
            for(int j=1; j <= cityCount; j++) {
                if(i == j) continue;
                distance[i][j] = INF;
            }
        }
        
        while(busCount-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            
            distance[start][end] = Math.min(distance[start][end], time);    
        }
 
        floydWarshall();
        print();
    }
    
    public static void floydWarshall() {
        // 기준이 되는 거쳐가는 노드 K
        for(int k = 1; k <= cityCount; k++) {
            // 출발하는 노드 i
            for(int i=1; i <= cityCount; i++) {
                // 도착하는 노드 j
                for(int j=1; j <= cityCount; j++) {
                    //i에서 k를 거쳤다가 k에서 j 까지 가는 거리와 i에서 j 까지 가는 거리를 비교해서 작은 값이 최소거리이다.
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
                }
            }
        }
    }
    
    public static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= cityCount; i++) {
            for(int j=1; j <= cityCount; j++) {
                if(distance[i][j] >= INF) sb.append("0 ");
                else sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}


/*입력
n(도시의 개수)
m(버스의 개수)
...
m+2(a, b, c)(시작도시, 도착도시, 한번 타는데 필요한 비용)
a=b는 존재하지 않는다.
c<100000

출력
0              최소비용 최소비용 최소비용 최소비용
최소비용     0          최소비용 최소비용 최소비용
최소비용 최소비용      0         최소비용 최소비용
최소비용 최소비용 최소비용      0         최소비용
최소비용 최소비용 최소비용 최소비용       0

n * n 배열임!!
 * 
 * 
 */
