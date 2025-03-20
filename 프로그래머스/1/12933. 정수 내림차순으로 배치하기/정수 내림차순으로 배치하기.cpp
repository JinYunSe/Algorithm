#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    
    vector<int> list;
    
    while(n != 0)
    {
        list.push_back(n % 10);
        n /= 10;
    }
    
    sort(list.begin(), list.end());
    reverse(list.begin(), list.end());
    
    for(int i = 0; i < list.size(); i++)
    {
        answer *= 10;
        answer += list[i];
    }
        
        
    return answer;
}