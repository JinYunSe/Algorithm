#include <iostream>
#include <climits>

using namespace std;

int N;
int matrix[501][2];
int dp[501][501]; //행렬 i부터 행렬 j까지 곱하는 데 필요한 곱센 연산의 최솟값
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;

	for (int i = 1; i <= N; i++) {
		int r, c;
		cin >> r >> c;
		matrix[i][0] = r;
		matrix[i][1] = c;
	}

	for (int i = 1; i <= N; i++) {
		dp[i][i] = 0;
	}

	for (int l = 2; l <= N; l++) {
		for (int start = 1; start <= N - l + 1; start++) {
			int end = start + l - 1;
			dp[start][end] = INT_MAX;
			for (int k = start; k < end; k++) {
				int cost = dp[start][k] + dp[k + 1][end] + matrix[start][0] * matrix[k][1] * matrix[end][1];
				dp[start][end] = min(dp[start][end], cost);
			}
		}
	}

	cout << dp[1][N];
}