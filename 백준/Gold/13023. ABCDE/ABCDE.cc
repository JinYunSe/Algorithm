#include <cstring>
#include <iostream>
#include <vector>

using namespace std;
int n, m;
vector<int> adj[2001];
bool vis[2001];
bool flag;

void depthOver5(int curr, int depth) {
    if(flag)
        return;
    
	if (depth == 5) {
		flag = true;
		return;
	}

	for (auto nxt : adj[curr]) {
		if (!vis[nxt]) {
			vis[nxt] = true;
			depthOver5(nxt, depth + 1);
			vis[nxt] = false;
		}
	}
}

int main()
{
    ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;

		adj[a].push_back(b);
		adj[b].push_back(a);
	}

	

	for (int i = 0; i < n; i++) {
		vis[i] = true;
		depthOver5(i, 1);
		vis[i] = false;

		if (flag) {
			cout << "1";
			return 0;
		}
	}

	cout << "0";
	return 0;
}