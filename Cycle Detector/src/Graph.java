import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Graph
{
	TreeSet<Integer>[] adj;

	public Graph(String filename) throws FileNotFoundException
	{
		File file = new File(filename);
		Scanner in = new Scanner(file);

		int V = in.nextInt();
		int E = in.nextInt();

		adj = new TreeSet[V];

		for (int i = 0; i < V; i++)
			adj[i] = new TreeSet<>();

		for (int i = 0; i < E; i++)
			addEdge(in.nextInt(), in.nextInt());
	}

	public void addEdge(int v, int w)
	{
		adj[v].add(w);
		adj[w].add(v);
	}

	public void removeEdge(int v, int w)
	{
		adj[v].remove(w);
		adj[w].remove(v);
	}

	public int V()
	{
		return adj.length;
	}

	public TreeSet<Integer> adj(int v)
	{
		return adj[v];
	}

	public String toString()
	{
		String result = "";

		for (int i = 0; i < adj.length; i++)
			result += i + ": " + adj[i] + "\n";

		return result;
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		Graph g = new Graph(args[0]);

		System.out.println(g);
	}
}
