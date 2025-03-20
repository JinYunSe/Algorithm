#include <string>
#include <algorithm>
#include <cmath>
#include <vector>

using namespace std;

long long solution(int a, int b) {
    long long answer = 0;
    
    int minTemp = min(a,b);
    int maxTemp = max(a,b);
    
    
    for(int i = minTemp; i <= maxTemp; i++)
        answer += i;
    
    return answer;
}