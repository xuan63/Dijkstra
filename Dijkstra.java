public static final int INFINITY = 9999;
public static int[] dijkstra(int MGrapg[][], int src){
    //MGraph: Adjacency matrix
    //P: previous vertex table of src; 
    //D: weight value table to src
    int v, w, k, min;
    int numV = MGrapg.length;
    int fin[] = new int[numV];
    int P[] = new int[numV];
    int D[] = new int[numV];    
    //f[i]=1: have computed the shortest path form src to i 
    for( v=0; v<numV; v++){
        fin[v] = 0;
        D[v] = MGrapg[src][v];
        P[v] = 0;
    }
    fin[src] = 1;
    D[src] = 0;

    k = 0;
    for( v=1; v<numV; v++){
        min = INFINITY;
        for( w=0; w<numV; w++ ){
            if( fin[w]==0 && D[w]<min){
                min = D[w];
                k = w;
            }
        }
        fin[k] = 1;
        //corrent the current shortest path table(D)
        for( w=0; w<numV; w++){
            if( fin[w]==0 && min+MGrapg[k][w]<D[w]){
                D[w] = min+MGrapg[k][w];
                P[w] = k;
            }
        }
    }
    return D;
}

