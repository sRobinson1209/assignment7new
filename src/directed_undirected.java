public class directed_undirected {
    public static class Graph{
        private boolean adjMatrix[][];
        private int numVertices;

        public Graph(int numVertices){
            this.numVertices = numVertices;
            adjMatrix = new boolean[numVertices][numVertices];
        }

        //Edges
        //O(1)
        public void addEdge(int i, int j){
            adjMatrix[i][j] = true;
            adjMatrix[j][i] = true;
        }
        //O(1)
        public void removeEdge (int i, int j){
            adjMatrix[i][j]= false;
            adjMatrix[j][i] = false;
        }

        public boolean idDirected(){
            //O(1) returning true or false
            for(int i =0; i < numVertices; i++){
                for(int j = 0; j < numVertices; j++){
                    if(adjMatrix[i][j] != adjMatrix[j][i]){
                        return true; // any edge is not symmetrically mirrored
                    }
                }
            }
            return false;
        }

        //print the matrix
        public String toString(){
            StringBuilder s = new StringBuilder();
            //o(n^2)
            for(int i = 0;i < numVertices; i++){
                s.append(i + "");
                for( boolean j : adjMatrix[i]){
                    s.append((j ? 1 : 0)+ "");
                }
                s.append("\n");
            }
            return s.toString();
        }
        public static void main(String args[]){
            Graph g = new Graph(4);
            g.addEdge(0,1);
            g.addEdge(0,2);
            g.addEdge(1,2);
            g.addEdge(2,0);
            g.addEdge(2,3);

            System.out.print(g.toString());
            System.out.println("is directed graph: "+ g.idDirected());
        }

    }
}
