public class TravellingSalesManProblem {
    //Here we will use prism algo to find Minimum spanning tree for a graph.This is approximate solution for TSP.
    int totalVertices;
    boolean visited[];
    int forest[];
    int parent[];

    public TravellingSalesManProblem(int totalVertices,  int[][] graph) {
        this.totalVertices = totalVertices;

        this.visited =  new boolean[totalVertices];
        this.forest = new int[totalVertices];
        this.parent = new int[totalVertices];
        this.graph = graph;
    }

    int[][] graph;


    void MSP(int source) {
        //So this will pick  source vertex first
        for (int i = 0; i < totalVertices; i++){
            visited[i]=false;
            forest[i]=Integer.MAX_VALUE;


        }
            forest[source] = 0;

        for (int i = 0; i < totalVertices; i++) {
            int u = MstUtil();
            visited[u] = true;
            for (int v = 0; v < totalVertices; v++) {
                if (graph[u][v] != Integer.MAX_VALUE && !visited[v] && graph[u][v] < forest[v]) {
                    forest[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        printMST();
    }

    int MstUtil() {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < totalVertices; i++) {
            if (forest[i] != Integer.MAX_VALUE && !visited[i] && min > forest[i]) {
                min = forest[i];
                minIndex = i;
            }


        }


        return minIndex;
    }


    void printMST(){
        for(int i=1;i<totalVertices;i++){

            System.out.println(i +"--->"+ parent[i]);
        }



    }

    public static  void main(String arg[]){


        int graph[][] = {{Integer.MAX_VALUE, 2, Integer.MAX_VALUE, 6, Integer.MAX_VALUE},
            {2, Integer.MAX_VALUE, 3, 8, 5},
            {Integer.MAX_VALUE, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, 7},
            {6, 8, Integer.MAX_VALUE, Integer.MAX_VALUE, 9},
            {Integer.MAX_VALUE, 5, 7, 9, Integer.MAX_VALUE},
        };
        TravellingSalesManProblem travellingSalesManProblem=new TravellingSalesManProblem(5,graph);
        travellingSalesManProblem.MSP(0);
    }

}
