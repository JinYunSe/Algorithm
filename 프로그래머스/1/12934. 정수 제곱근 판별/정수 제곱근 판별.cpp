#include <iostream>
#include <string>
#include <cmath>
#include <vector>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    
    int temp = (double)sqrt(n);
    
    return pow(temp, 2) == n ? pow(temp + 1, 2) : -1;
}