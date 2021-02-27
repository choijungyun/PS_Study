package BaekJoon;
import java.util.*;
import java.io.*;

public class �ִܰ��_1753 {
	private static int V;
	private static int [] dist;
	private static ArrayList<Node> [] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//������ ����
		V = Integer.parseInt(st.nextToken());
		//������ ����
		int E = Integer.parseInt(st.nextToken());
		//���������� ��ȣ
		int K = Integer.parseInt(br.readLine());
		//�ʱⰪ ����, �ִܰŸ��� ������ �迭
		dist = new int[V+1];
		//�ִ����� �ϴ� ä���д�.
		Arrays.fill(dist, 2147000000);
		graph = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		//�� �ֱ�
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			//graph�� ���� �����صα�
			graph[u].add(new Node(v,w));
		}
		//���ͽ�Ʈ�� ����
		dijkstra(K);
		//������ ���� ��� ���
		for(int i=1; i<=V; i++) {
			if(dist[i]==2147000000)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
		
		
	}
	
	private static void dijkstra(int start) {
		//���� ���� �� ��Ƶα�
		PriorityQueue <Node> pq = new PriorityQueue<>();
		//�湮üũ
		boolean [] visited = new boolean[V+1];
		//�������� 0
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int cur = node.v;
			int cost = node.w;
			//�湮�� �����̸� pass
			if(visited[cur]) continue;
			//�̹� �ּҰ��̶�� pass
			visited[cur] = true;
			if(dist[cur]<cost) continue;
			for(int i=0; i<graph[cur].size(); i++) {
				int next = graph[cur].get(i).v;
				int next_cost = cost + graph[cur].get(i).w;
				//�ּҰ� ����, pq�� �־�α�
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