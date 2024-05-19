public class WQUWithPathCompression extends WeightQuickUnion {
    public WQUWithPathCompression(int n) {
        super(n);
    }

    @Override
    public int find(int v1) {
        validate(v1);
        int root = v1;
        while (parent[root] >= 0) {
            root = parent[root];
        }
        while (v1 != root) {
            int temp = parent[v1];
            parent[v1] = root;
            v1 = temp;
        }
        return root;
    }
}
