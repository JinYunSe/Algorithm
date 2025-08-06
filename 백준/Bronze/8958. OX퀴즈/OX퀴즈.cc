#include <iostream>
using namespace std;

int main() {
	int number;
	cin >> number;
	string* testcase = new string[number];
	for (int i = 0; i < number; i++) {
		cin >> testcase[i];
	}
	int count = 0;
	for (int i = 0; i < number; i++) {
		int sum = 0;
		for (int j = 0; j < testcase[i].length(); j++) {
			char check = testcase[i][j];
			if (check == 'O') {
				count++;
				sum += count;
			}
			else count = 0;
		}
		cout << sum << endl;
		count = 0;
	}
}