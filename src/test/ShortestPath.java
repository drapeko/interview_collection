package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPath {

	private static class Vertex implements Comparable<Vertex> {
		String name;
		Double estimatedDistance = Double.POSITIVE_INFINITY;
		Double actualDistance = Double.POSITIVE_INFINITY;
		List<Edge> edges = new ArrayList<Edge>();
		Vertex previous = null;
		
		public Vertex(String name) {
			this.name = name;
		}
		public void addEdge(Edge edge) {
			edges.add(edge);
		}
		@Override
		public int compareTo(Vertex arg0) {
			return Double.compare(estimatedDistance, arg0.estimatedDistance);
		}
		
		@Override
		public String toString() {
			return name;
		}
	}
	
	private static class Edge {
		Vertex target;
		Double weight;
		Double heuristic;
		public Edge(Vertex target, Double weight, Double heuristic) {
			this.target = target;
			this.weight = weight;
			this.heuristic = heuristic;
		}
	}

	public static void dijkstra(Vertex source) {
		source.estimatedDistance = 0.;
		source.actualDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
      	vertexQueue.add(source);
      	
      	while(!vertexQueue.isEmpty()) {
      		Vertex current = vertexQueue.poll();
      		
      		for(Edge edge : current.edges) {
      			Vertex v = edge.target;
      			Double estimatedDistance = current.actualDistance + edge.weight + edge.heuristic;
      			if (estimatedDistance < v.estimatedDistance) {
      				vertexQueue.remove(v);
      				v.estimatedDistance = estimatedDistance;
      				v.actualDistance = current.actualDistance + edge.weight;
      				v.previous = current;
      				vertexQueue.add(v);
      			}
      		}
      	}
	}
	
	public static List<Vertex> shortestPath(Vertex toVertex) {
		List<Vertex> pathes = new ArrayList<Vertex>();
		while(toVertex != null) {
			pathes.add(toVertex);
			toVertex = toVertex.previous;
		}
		Collections.reverse(pathes);
		return pathes;
	}
	
	public static void main(String [] args) {
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Vertex v6 = new Vertex("6");
		
		Vertex [] graph = {v1, v2, v3, v4, v5, v6};
		
		v1.addEdge(new Edge(v2, 7.,  4.));
		v1.addEdge(new Edge(v3, 9.,  19.));
		v1.addEdge(new Edge(v6, 14., 0.));
		v2.addEdge(new Edge(v3, 10., 2.));
		v2.addEdge(new Edge(v4, 15., 22.));
		v3.addEdge(new Edge(v6, 2.,  44.));
		v3.addEdge(new Edge(v4, 11., 2.));
		v4.addEdge(new Edge(v5, 6.,  44.));
		v6.addEdge(new Edge(v5, 9.,  12.));
		
		dijkstra(v1);
		
		for (Vertex v : graph) {
		    System.out.println("Distance to " + v + ": " + v.actualDistance);
		    List<Vertex> path = shortestPath(v);
		    System.out.println("Path: " + path);
		}
	}
}
