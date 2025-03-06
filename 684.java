class Solution {
    private int[] uf;
    public int[] findRedundantConnection(int[][] edges) {
        uf = new int[edges.length * 2 + 1];
        for(int i = 1; i < uf.length; i++){
            uf[i] = i;
        }
        for(int[] edge : edges){
            int p = find(edge[0]);
            int q = find(edge[1]);
            if(p == q) return edge;
            uf[p] = q;
        }
        return null;
    }
    private int find(int i){
        if(i != uf[i]){
            uf[i] = find(uf[i]);
        }
        return uf[i];
    }
}
