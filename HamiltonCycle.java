public class HamiltonCycle {
    int totalVertices;
    int graph[][];
    int pathData[];

    boolean isSafe(int v, int pos, int[] path) {
        if (graph[v][path[pos - 1]] == Integer.MAX_VALUE)
            return false;
        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;
        return true;
    }

    boolean hamiltonCycle(int[] path, int pos) {
        if (pos == totalVertices) {
            if (graph[path[0]][path[pos-1]] != Integer.MAX_VALUE) {
                pathData = path;
                return true;
            } else
                return false;
        } else {
            for (int i = 1; i < totalVertices; i++) {
                if (isSafe(i, pos, path)) {
                    path[pos] = i;
                    if (hamiltonCycle(path, pos+1))
                        return true;
                    path[pos] = Integer.MAX_VALUE;
                }
            }

        }
        return false;
    }

    boolean hamCycle(int graph[][], int v) {
        this.graph = graph;
        this.totalVertices=v;
        int[] path = new int[v];
        for (int i = 0; i < v; i++)
            path[i] = Integer.MAX_VALUE;

    /* Let us put vertex 0 as the first vertex in the path. If there is
       a Hamiltonian Cycle, then the path can be started from any point
       of the cycle as the graph is undirected */
        path[0] = 0;
        if (!hamiltonCycle(path, 1)) {
            System.out.println(("\nSolution does not exist"));
            return false;
        }


        return true;
    }

    void printPath(){
        for (int i = 0; i < totalVertices; i++){
            System.out.println(pathData[i]);
        }
        System.out.println();
    }


    public static  void main(String arg[]){
        HamiltonCycle hamiltonCycle=new HamiltonCycle();
        int graph1[][] = {{Integer.MAX_VALUE, 1, Integer.MAX_VALUE, 1, Integer.MAX_VALUE},
            {1, Integer.MAX_VALUE, 1, 1, 1},
            {Integer.MAX_VALUE, 1, Integer.MAX_VALUE, Integer.MAX_VALUE, 1},
            {1, 1, Integer.MAX_VALUE, Integer.MAX_VALUE, 1},
            {Integer.MAX_VALUE, 1, 1, 1, Integer.MAX_VALUE},
        };
     if( hamiltonCycle. hamCycle(graph1,5)){
         hamiltonCycle.printPath();
     }


    }
}
