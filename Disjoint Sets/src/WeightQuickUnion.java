public class WeightQuickUnion implements DisjointSets {
    protected int[] parent;

    public WeightQuickUnion(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
    }

    public void validate(int v1) {
        int n = parent.length;
        if (v1 < 0 || v1 >= n) {
            throw new IllegalArgumentException("index " + v1 + " is not between 0 and " + (n - 1));
        }
    }

    public int sizeOf(int v1) {
        int root = find(v1);
        return parent[root] * (-1);
    }

    @Override
    public boolean isConnected(int v1, int v2) {
        return find(v1) == find(v2);
    }

    @Override
    public void connect(int v1, int v2) {
        validate(v1);
        validate(v2);
        if (isConnected(v1, v2)) {
            return;
        }
        int v1Root = find(v1);
        int v2Root = find(v2);
        int v1Size = sizeOf(v1);
        int v2Size = sizeOf(v2);
        if (v1Size <= v2Size) {
            parent[v1Root] = v2Root;
            parent[v2Root] = v1Size + v2Size;
        } else {
            parent[v2Root] = v1Root;
            parent[v1Root] = v1Size + v2Size;
        }
    }

    public int find(int v1) {
        validate(v1);
        while (parent[v1] >= 0) {
            v1 = parent[v1];
        }
        return v1;
    }
}
