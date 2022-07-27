package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ 1707 : Bipartite Graph
// use BFS
// https://www.google.com/search?q=%EC%9D%B4%EB%B6%84%EA%B7%B8%EB%9E%98%ED%94%84&oq=%EC%9D%B4%EB%B6%84%EA%B7%B8%EB%9E%98%ED%94%84&aqs=chrome..69i57j69i59j69i61l3.2083j0j7&sourceid=chrome&ie=UTF-8
public class BOJ_1707 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    static int K, V, E;
    static Node[] nodes;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());

        while(K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            nodes = new Node[V+1];
            visited = new boolean[20001];

            for(int i = 1; i <= V; ++i) {
                nodes[i] = new Node(i);
            }

            boolean flag = true;

            int u,v;
            for(int i = 0; i < E; ++i) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());

                nodes[u].child.add(nodes[v]);
                nodes[v].child.add(nodes[u]);
            }

            for(int i = 1; i <= V; ++i) {
                if(!visited[i]) {
                    visited[i] = true;
                    nodes[i].setColor(1);

                    if(!bfs(i)) {
                        flag = false;
                        break;
                    }
                }
            }
            sb.append(flag?"YES":"NO").append("\n");
        }
        System.out.print(sb);
    }

    private static boolean bfs(int idx) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(nodes[idx]);

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            /*
             *  If a child node is visited and the color is the same as the current node,
             *  it is not a bipartite graph.
             */
            for(Node child : node.child) {
                if(visited[child.idx] && child.color == node.color) {
                    return false;
                }
            }

            for(Node child : node.child) {
                if(!visited[child.idx]) {
                    visited[child.idx] = true;
                    // The child is set to have a different color from the parent node.
                    child.setColor(1- node.color);
                    queue.offer(child);
                }
            }
        }

        return true;
    }

    static class Node {
        int idx;
        int color;

        ArrayList<Node> child = new ArrayList<>();

        public Node(int idx) {
            this.idx = idx;
        }

        public void setColor(int color) {
            this.color = color;
        }
    }
}