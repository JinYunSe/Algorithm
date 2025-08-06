#include <iostream>
using namespace std;

int main() {
	int number;
	cin >> number;
	double *temp = new double[number];
	for (int i = 0; i < number; i++) {
		cin >> temp[i];
	}
	int max = 0;
	double avg = 0;
	for (int i = 0; i < number; i++) {
		if (max < temp[i]) max = temp[i];
	}
	for (int i = 0; i < number; i++) {
		temp[i] = temp[i] * 100 / max;
		avg += temp[i];
	}
	avg /= number;
	cout << avg << endl;
}