#include <iostream>
#include <algorithm>
#include <climits>

using namespace std;

int k;
int dp[501][501];
int prefix[501];
int sz[501];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int T;
	cin >> T;
	for (int tc = 1; tc <= T; tc++) {
		cin >> k;
		fill(&dp[0][0], &dp[0][0] + 501 * 501, 0);
		fill(&prefix[0], &prefix[0] + 501, 0);

		for (int i = 1; i <= k; i++) {
			cin >> sz[i];
			prefix[i] = prefix[i - 1] + sz[i];
		}

		for (int len = 2; len <= k; len++) {
			for (int i = 1; i +len - 1 <= k; i++) {
				int en = i + len - 1;
				dp[i][en] = INT_MAX;
				for (int m = i; m < en; m++) {
					dp[i][en] = min(dp[i][en], dp[i][m] + dp[m + 1][en] + prefix[en] - prefix[i-1]);
				}
			}
		}

		cout << dp[1][k] << "\n";
	}
}