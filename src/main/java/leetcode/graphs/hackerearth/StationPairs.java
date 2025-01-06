package leetcode.graphs.hackerearth;

import java.util.*;

public class StationPairs {

    /*
    Problem:
    https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/station-pairs-8c901658/

    Solution:
    https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/station-pairs-8c901658/editorial/
     */

    private static int len = 0;

    public static void main(String[] args) {
        int n=5;
        int m=4;
        int x=3;
        int y=5;

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(1,2));
        pairs.add(new Pair(2,3));
        pairs.add(new Pair(3,4));
        pairs.add(new Pair(4,5));

        long ans = getNoEdgesCanbeAdded(n,m,x,y,pairs);
        System.out.println(ans);
    }

    private static long getNoEdgesCanbeAdded(int n, int m, int x, int y, List<Pair> pairs) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int i=0; i<m; i++) {
            int src = pairs.get(i).getSrc();
            int dest = pairs.get(i).getDest();

            adj.putIfAbsent(src, new ArrayList<>());
            adj.get(src).add(dest);

            adj.putIfAbsent(pairs.get(i).getDest(), new ArrayList<>());
            adj.get(dest).add(src);
        }

        int[] dy = bfs(x, y, n, adj);
        print(dy, "dy");
        System.out.println("Len = " + len);

        int[] dx = bfs(y, x, n, adj);
        print(dx, "dx");
        System.out.println("Len = " + len);

        long[] ps = new long[n+1];
        // Run a for loop for 'i' from 0 to 'n-1'.
        for (int i = 0; i < n; i++)
        {
            // Make 'ps[i+1]' equal to 'ps[i]'+'dx[i]' to store the number of elements which are at a distance less than or equal to 'i' from 'y'.
            ps[i + 1] = ps[i] + dx[i];
        }
        print(ps,"ps");

        // Initialise a variable 'ans' with '(n * (n - 1) / 2) - m'. These are the maximum number of pairs till now.
        long ans = (long)(n * (n - 1)) / 2 - m;
        System.out.println("All nodes - m  = " + ans);

        // Run a for loop for all possible distance, from 0 to 'len-1' to decrease the number of pairs that are decreasing the distance between 'x' and 'y'.
        for (int i = 0; i < len - 1; i++)
        {
            // Subtract 'ans' by 'dy[i] * ps[len-i-1]'. 'dy[i]' and 'ps[len-i-1]' represents the total number of nodes having distance 'i' and less than 'len-i-1' respectively.
            System.out.println("dy" + i + "="+ dy[i]);
            System.out.println("len - i - 1 = " + (len - i -1 ));
            System.out.println("ps" + i + "=" + ps[len - i - 1]);
            ans -= dy[i] * ps[len - i - 1];
        }

        // Return ans;
        return ans;
    }

    private static void print(long[] arr, String name) {
        System.out.println("----------------------------------");
        for(int i=0; i<arr.length; i++) {
            System.out.println(name + "[" + i + "]=" + arr[i]);
        }
    }

    private static void print(int[] arr, String name) {
        System.out.println("----------------------------------");
        for(int i=0; i<arr.length; i++) {
            System.out.println(name + "[" + i + "]=" + arr[i]);
        }
    }

    private static int[] bfs(int s, int t, int n, Map<Integer, List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(s);

        // Initialise a vector 'dist' of size 'n + 1' to store the distance of all nodes from 's'.
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);

        dist[s] = 0;

        // Initialise a vector 'layer' of size 'n' with 0 to count the number of nodes of with particular distance.
        int[] layers = new int[n];

        while(!q.isEmpty()) {
            int u = q.poll();

            layers[dist[u]]++;

            if(adj.get(u) != null) {
                for (int v : adj.get(u)) {
                    if(dist[v] == -1) {
                        dist[v] = dist[u] + 1;

                        q.offer(v);
                    }
                }
            }
        }

        len = dist[t];
        return layers;
    }

    private static class Pair {
        private int src;
        private int dest;

        public Pair(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

        public int getSrc() {
            return src;
        }

        public int getDest() {
            return dest;
        }
    }
}

/*
#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
using namespace std;
using namespace __gnu_pbds;
#define int long long int
#define ordered_set tree<int, nuint_type,less<int>, rb_tree_tag,tree_order_statistics_node_update>
mt19937 rng(std::chrono::duration_cast<std::chrono::nanoseconds>(chrono::high_resolution_clock::now().time_since_epoch()).count());
#define mp make_pair
#define pb push_back
#define F first
#define S second
const int N=200005;
#define M 1000000007
#define BINF 1e16
#define init(arr,val) memset(arr,val,sizeof(arr))
#define MAXN 10000005
#define deb(xx) cout << #xx << " " << xx << "\n";
const int LG = 22;

vector<int> v[N];
int n, m, x, y;

vector<int> bfs(int u) {
    vector<int> dist(n + 1, 1e9), vis(n + 1, 0);
    dist[u] = 0;
    vis[u] = 1;
    queue<pair<int, int>>q;
    q.push(make_pair(u, 0));
    while(q.size()) {
        int node = q.front().F, l = q.front().S;
        q.pop();
        for(auto i : v[node]) {
            if(!vis[i]) {
                dist[i] = 1 + l;
                q.push(make_pair(i, dist[i]));
                vis[i] = 1;
            }
        }
    }
    return dist;
}


void solve() {

    cin >> n >> m >> x >> y;

    for(int i = 0; i <= n; i++) {
        v[i].clear();
    }

    for(int i = 0; i < m; i++) {
        int uu, vv;
        cin >> uu >> vv;

        v[uu].push_back(vv);
        v[vv].push_back(uu);
    }

    vector<int> v1 = bfs(x);
    int len = v1[y];

    vector<int> v2 = bfs(y);

    vector<int> nodes1(n + 1, 0), nodes2(n + 1, 0);
    for(int i = 1; i <= n; i++) {
        nodes1[v1[i]] = nodes1[v1[i]] + 1;
    }
    for(int i = 1; i <= n; i++) {
        nodes2[v2[i]] = nodes2[v2[i]] + 1;
    }

    vector<int> psum(n + 1, 0);
    psum[0] = nodes2[0];
    for(int i = 1; i <= n; i++) {
        psum[i] = psum[i - 1] + nodes2[i];
    }

    int c = (n * (n - 1)) / 2 - m;

    for(int i = 0; i < len - 1; i++) {
        int c1 = nodes1[i] * psum[len - 2 - i];
        c = c - c1;
    }

    cout << c << endl;

}


#undef int
int main() {
#define int long long int
ios_base::sync_with_stdio(false);
cin.tie(0);
cout.tie(0);
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("optput.txt", "w", stdout);
#endif

    int T;
    cin >> T;
    assert(T >= 1 and T <= 10);

    for(int tc = 1; tc <= T; tc++){
        // cout << "Case #" << tc << ": ";
        solve();
    }

return 0;

}
 */
