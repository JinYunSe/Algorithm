#include <iostream>
#include <queue>
#include <vector>

using namespace std;
int n, c;
pair<int, int> p[2000];
vector<pair<long long, int>> adj[2000];
bool vis[2000];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> n >> c;
	for (int i = 0; i < n; i++) {
		cin >> p[i].first >> p[i].second;
	}

	//cal distance
	for (int i = 0; i < n - 1; i++) {
		for (int j = i + 1; j < n; j++) {
			long long dx = p[i].first - p[j].first;
			long long dy = p[i].second - p[j].second;

			long long dist = dx * dx + dy * dy;
			if (dist >= c) {
				adj[i].push_back({ dist, j });
				adj[j].push_back({ dist, i });
			}
		}
	}

	//prim
	priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<>> pq;
	pq.push({ 0, 0 });
	long long cost = 0;
	int cnt = 0;
	while (!pq.empty()) {
		pair<long long, int> curr = pq.top();
		pq.pop();

		if (vis[curr.second])
			continue;

		vis[curr.second] = true;
		cost += curr.first;
		cnt++;
		for (auto nxt : adj[curr.second]) {
			if (!vis[nxt.second])
				pq.push({ nxt.first, nxt.second });
		}
	}

	if (cnt != n)
		cout << "-1";
	else
		cout << cost;
}