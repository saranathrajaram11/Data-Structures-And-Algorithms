class ApVertex {

    static void aproxVertexCover(int[][] edges, int n, int m) {
        int[] c = new int[n];                // To store vertex cover
        int csize = 0;                       // Count of vertices in cover
        boolean[] removed = new boolean[m];  // Mark removed edges
        int remain = m;

        while (remain > 0) {
            // Pick an arbitrary edge that is not removed
            int eindex = -1;
            for (int i = 0; i < m; i++) {
                if (!removed[i]) {
                    eindex = i;
                    break;
                }
            }

            if (eindex == -1)
                break; // No edges left

            int u = edges[eindex][0];
            int v = edges[eindex][1];

            // Add u and v to vertex cover if not already there
            boolean uexists = false, vexists = false;
            for (int i = 0; i < csize; i++) {
                if (c[i] == u)
                    uexists = true;
                if (c[i] == v)
                    vexists = true;
            }

            if (!uexists)
                c[csize++] = u;
            if (!vexists)
                c[csize++] = v;

            // Remove all the edges incident with u and v
            for (int i = 0; i < m; i++) {
                if (!removed[i]) {
                    if (edges[i][0] == u || edges[i][1] == u ||
                        edges[i][0] == v || edges[i][1] == v) {
                        removed[i] = true;
                        remain--;
                    }
                }
            }
        }

        // Print vertex cover
        System.out.println("The approximate vertex cover is {");
        for (int i = 0; i < csize; i++) {
            System.out.print(c[i]);
            if (i != csize - 1)
                System.out.print(", ");
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        int[][] edges = { {1, 2}, {1, 3}, {2, 4}, {3, 5} };
        int n = 5, m = 4;

        aproxVertexCover(edges, n, m);
    }
}
