import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GraphColoring {
    boolean availableColour[];
    int result[];
    int V;

    public GraphColoring( int v) {
        this.availableColour = new boolean[v];
        this.result = new int[v];
         this. V = v;
    }

    Map<Integer, ArrayList<Integer>> graph=new HashMap<Integer, ArrayList<Integer>>();

    void addEdge(int src, int dest) {
        if (graph.containsKey(src)) {
            graph.get(src).add(dest);
        } else {
            ArrayList<Integer> adjList = new ArrayList<Integer>();
            adjList.add(dest);
            graph.put(src, adjList);
        }


        if (graph.containsKey(dest)) {
            graph.get(dest).add(src);
        } else {
            ArrayList<Integer> adjList = new ArrayList<Integer>();
            adjList.add(src);
            graph.put(dest, adjList);
        }

    }


    void color() {

        for (int j = 0; j < V; j++) {
            result[j] = -1;
        }
        for (int i = 0; i < V; i++) {
            //For all vertices first check for available adjacent vertices
            Iterator<Integer> adjVertices = graph.get(i).iterator();
            while (adjVertices.hasNext()) {
                int adjValue = adjVertices.next();
                if (result[adjValue] != -1) {
                    availableColour[result[adjValue]] = true;
                }
            }
            //Now find a color
            for (int j = 0; j < V; j++) {
                if (!availableColour[j]) {
                    result[i] = j;
                    break;
                }
            }
            //Make color available for other calls
            for (int j = 0; j < V; j++) {
                availableColour[j] = false;
            }
        }


    }

    public static void main(String arg[]) {
        GraphColoring graphColoring = new GraphColoring(4);

        graphColoring.addEdge(0, 1);
        graphColoring.addEdge(0, 2);
        graphColoring.addEdge(0, 3);
        graphColoring.addEdge(1, 3);
        graphColoring.addEdge(2, 3);
        graphColoring.color();
        for (int j = 0; j <  graphColoring.V; j++) {
        System.out.print( graphColoring. result[j]);
        }


    }


}
