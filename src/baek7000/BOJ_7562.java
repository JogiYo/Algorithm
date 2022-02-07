package baek7000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// BOJ 7562 : Knight's move
// use BFS
public class BOJ_7562 {
    static int tc;
    static int n;
    static int x1,y1;
    static int x2,y2;

    static int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {-2,-1,1,2,2,1,-1,-2};

    static int[][] visited = new int[301][301];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {
            cleanVisited();

            n = Integer.parseInt(br.readLine());
            String[] input1 = br.readLine().split(" ");
            String[] input2 = br.readLine().split(" ");

            x1 = Integer.parseInt(input1[0]);
            y1 = Integer.parseInt(input1[1]);

            x2 = Integer.parseInt(input2[0]);
            y2 = Integer.parseInt(input2[1]);

            solution(x1, y1, x2, y2);
            sb.append(visited[x2][y2] + "\n");
        }

        System.out.print(sb);
    }

    // use BFS
    private static void solution(int a, int b, int c, int d) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(a,b));
        visited[a][b] = 0;

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            if(p.x == c && p.y == d) break;

            for(int i = 0; i < 8; ++i) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                // 범위를 넘어가지 않고, 방문하지 않고, 원래 횟수보다 작을 때
                if(0 <= nx && nx < n && 0 <= ny & ny < n &&
                        (visited[nx][ny]==-1 || visited[p.x][p.y]+1 < visited[nx][ny])
                ){
                    visited[nx][ny] = visited[p.x][p.y]+1;
                    queue.add(new Point(nx,ny));
                }
            }
        }
    }

    public static void cleanVisited(){
        for(int i=0;i<=300;i++)
            for(int j=0;j<=300;j++)
                visited[i][j]=-1;
    }

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
