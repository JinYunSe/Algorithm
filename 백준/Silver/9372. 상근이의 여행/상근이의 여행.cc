#include <iostream>
#include <algorithm>

using namespace std;
int n, m;
pair<int, int> edge[10001];
int p[1001];

int find(int x) {
	if (p[x] < 0)
		return x;

	return p[x] = find(p[x]);
}

bool uni(int u, int v) {
	u = find(u);
	v = find(v);

	if (u == v)
		return false;

	if (p[v] < p[u])
		swap(p[u], p[v]);

	if (p[u] == p[v])
		p[u]--;

	p[v] = u;
	return true;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int T;
	cin >> T;
	for (int tc = 1; tc <= T; tc++) {
		cin >> n >> m;
		int a, b;
		for (int i = 0; i < m; i++) {
			cin >> a >> b;
			edge[i] = { a, b };
		}

		int cnt = 0;
		fill(p, p + n + 1, -1);

		for (int i = 0; i < m && cnt < n-1; i++) {
			pair<int, int> curr = edge[i];
			if (uni(curr.first, curr.second)) {
				cnt++;
			}
		}

		cout << cnt << "\n";
	}
}