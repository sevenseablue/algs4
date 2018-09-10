package edu.princeton.cs.algs4;

import java.util.stream.IntStream;

public class AcycleLPSort {
    public IntDouble[] sort(String fileIn){
        In in = new In(fileIn);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        Double[] lpl = new Double[G.V()];
        for(int s = 0; s < G.V(); s++) {
            AcyclicLP lp = new AcyclicLP(G, s);
            double maxL = 0;
            for (int v = 0; v < G.V(); v++) {
                if (lp.hasPathTo(v)) {
                    if (lp.distTo(v)>maxL){
                        maxL = lp.distTo(v);
                    }
//                    StdOut.printf("%d to %d (%.2f)  ", s, v, lp.distTo(v));
//                    for (DirectedEdge e : lp.pathTo(v)) {
//                        StdOut.print(e + "   ");
//                    }
//                    StdOut.println();
                } else {
//                    StdOut.printf("%d to %d         no path\n", s, v);
                }
            }
            lpl[s] = maxL;
        }
        int[] sortedIndices = IntStream.range(0, lpl.length)
                .boxed().sorted((i,j) -> lpl[j].compareTo(lpl[i]))
                .mapToInt(ele -> ele).toArray();
        for(int i=0; i<sortedIndices.length; i++){
            System.out.println(sortedIndices[i]+": "+lpl[sortedIndices[i]]);
        }
        IntDouble[] idarr = new IntDouble[sortedIndices.length];
        for (int i=0; i<idarr.length; i++){
            idarr[i] = new IntDouble(sortedIndices[i], lpl[sortedIndices[i]]);
        }
        return idarr;

    }
    public static void main(String[] args) {

    }
}
