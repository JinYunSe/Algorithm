#include <iostream>
#include <algorithm>

using namespace std;
int N;
int T[1500001];
int P[1500001];
int D[1500001];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;

	for (int i = 1; i <= N; i++) {
		cin >> T[i] >> P[i];
	}

	for (int i = N; i >= 1; i--) {
		if (i + T[i] <= N + 1) {
			D[i] = max(D[i + T[i]] + P[i], D[i + 1]);
		}
		else
		{
			D[i] = D[i + 1];
		}
	}

	cout << *max_element(D + 1, D + N + 1);
	return 0;
}