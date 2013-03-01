package edu.algorithm.mit.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Floyd-Warshall algorithm for determining the shortest path between
 * two nodes in a graph.
 * <p>
 * Thread Safety: immutable
 */
public final class FloydWarshall
{

    private final int[][] D;

    private final Node[][] P;

    /**
     * Create an instance of this class by describing the graph
     * upon which it will operate.
     * <p>
     * Note <code>Node.name</code> must contain the index of the node in the
     * <code>nodes</code> parameter. Thus <code>Node[1].name</code> must equal
     * one.
     * <p>
     * On small computers the practical maximum graph size with a 4-byte Node is
     * about 23,000, at which point the data size of an instance begins to
     * exceed 4 GB.
     * 
     * @param nodes
     *            Array of Node; must be completely populated
     * @param edges
     *            Array of Edge, completely populated; order is not important
     */
    public FloydWarshall(final Node[] nodes, final Edge[] edges)
    {
        final int maxNodes = 23000;  // roughly 4 GB
        assert nodes.length < maxNodes : "nodes.length cannot exceed "
                + maxNodes
                + ".\nSize of class data structures is at least (2*(node size)*nodes.length**2).";

        D = initializeWeight(nodes, edges);
        P = new Node[nodes.length][nodes.length];

        for (int k = 0; k < nodes.length; k++)
        {
            for (int i = 0; i < nodes.length; i++)
            {
                for (int j = 0; j < nodes.length; j++)
                {
                    if (D[i][k] != Integer.MAX_VALUE
                            && D[k][j] != Integer.MAX_VALUE
                            && D[i][k] + D[k][j] < D[i][j])
                    {
                        D[i][j] = D[i][k] + D[k][j];
                        P[i][j] = nodes[k];
                    }
                }
            }
        }
    }

    /**
     * Determines the length of the shortest path from vertex A (source)
     * to vertex B (target), calculated by summing the weights of the edges
     * traversed.
     * <p>
     * Note that distance, like path, is not commutative. That is, distance(A,B)
     * is not necessarily equal to distance(B,A).
     * 
     * @param source
     *            Start Node
     * @param target
     *            End Node
     * @return The path length as the sum of the weights of the edges traversed,
     *         or <code>Integer.MAX_VALUE</code> if there is no path
     */
    public int getShortestDistance(final Node source, final Node target)
    {
        return D[source.index][target.index];
    }

    /**
     * Describes the shortest path from vertex A (source) to vertex B (target)
     * by returning a collection of the vertices traversed, in the order
     * traversed.
     * If there is no such path an empty collection is returned.
     * <p>
     * Note that because each Edge applies only to one direction of traverse,
     * the path from A to B may not be the same as the path from B to A.
     * 
     * @param source
     *            Start Node
     * @param target
     *            End Node
     * @return A List (ordered Collection) of Node, possibly empty
     */
    public List<Node> getShortestPath(final Node source, final Node target)
    {
        if (D[source.index][target.index] == Integer.MAX_VALUE)
        {
            return new ArrayList<Node>(); // no path
        }
        final List<Node> path = getIntermediatePath(source, target);
        path.add(0, source);
        path.add(target);
        return path;
    }

    private List<Node>
            getIntermediatePath(final Node source, final Node target)
    {
        if (P[source.index][target.index] == null)
        {
            return new ArrayList<Node>();
        }
        final List<Node> path = new ArrayList<Node>();
        path.addAll(getIntermediatePath(source, P[source.index][target.index]));
        path.add(P[source.index][target.index]);
        path.addAll(getIntermediatePath(P[source.index][target.index], target));
        return path;
    }

    private int[][] initializeWeight(final Node[] nodes, final Edge[] edges)
    {
        int[][] Weight = new int[nodes.length][nodes.length];
        for (int i = 0; i < nodes.length; i++)
        {
            Arrays.fill(Weight[i], Integer.MAX_VALUE);
        }
        for (Edge e : edges)
        {
            Weight[e.from.index][e.to.index] = e.weight;
            Weight[e.to.index][e.from.index] = e.weight; // Distance between AB
                                                         // = Distance between
                                                         // BA
        }
        return Weight;
    }
}

class Node implements Comparable<Node>
{

    final int name;

    boolean visited = false;   // used for Kosaraju's algorithm and Edmonds's
                             // algorithm

    int lowlink = -1;          // used for Tarjan's algorithm

    int index = -1;            // used for Tarjan's algorithm

    public Node(final int argName)
    {
        name = argName;
    }

    public int compareTo(final Node argNode)
    {
        return argNode == this ? 0 : -1;
    }
}

class Edge implements Comparable<Edge>
{

    final Node from, to;

    final int weight;

    public Edge(final Node argFrom, final Node argTo, final int argWeight)
    {
        from = argFrom;
        to = argTo;
        weight = argWeight;
    }

    public int compareTo(final Edge argEdge)
    {
        return weight - argEdge.weight;
    }
}