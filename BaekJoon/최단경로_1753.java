package BaekJoon;
import java.util.*;
import java.io.*;

public class 최단경로_1753 {
	private static int V;
	private static int [] dist;
	private static ArrayList<Node> [] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//정점의 개수
		V = Integer.parseInt(st.nextToken());
		//간선의 개수
		int E = Integer.parseInt(st.nextToken());
		//시작정점의 번호
		int K = Integer.parseInt(br.readLine());
		//초기값 세팅, 최단거리를 갱신할 배열
		dist = new int[V+1];
		//최댓값으로 일단 채워둔다.
		Arrays.fill(dist, 2147000000);
		graph = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		//값 넣기
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			//graph에 상태 저장해두기
			graph[u].add(new Node(v,w));
		}
		//다익스트라 시작
		dijkstra(K);
		//정점에 따라 비용 출력
		for(int i=1; i<=V; i++) {
			if(dist[i]==2147000000)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
		
		
	}
	
	private static void dijkstra(int start) {
		//정점 나올 것 담아두기
		PriorityQueue <Node> pq = new PriorityQueue<>();
		//방문체크
		boolean [] visited = new boolean[V+1];
		//시작점은 0
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int cur = node.v;
			int cost = node.w;
			//방문한 정점이면 pass
			if(visited[cur]) continue;
			//이미 최소값이라면 pass
			visited[cur] = true;
			if(dist[cur]<cost) continue;
			for(int i=0; i<graph[cur].size(); i++) {
				int next = graph[cur].get(i).v;
				int next_cost = cost + graph[cur].get(i).w;
				//최소값 갱신, pq에 넣어두기
				if(dist[next]>next_cost)
					dist[next] = next_cost;
					pq.add(new Node(next, next_cost));
			}
		}
		
	}
}
class Node implements Comparable<Node>{
	int v, w;
	
	Node(int v, int w){
		this.v = v;
		this.w = w;
	}
	
	@Override
	public int compareTo(Node n) {
		return w-n.w;
	}
}