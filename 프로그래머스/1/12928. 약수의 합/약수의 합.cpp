#include <iostream>
#include <string>
#include <cmath>
#include <vector>

using namespace std;

int solution(int n) {
    
    int sum = 0;
    
    for(int i = 1; i <= (int)sqrt(n); i++)
    {
        if(n % i == 0)
        {
            sum += i;
            if(n / i != i)sum += n / i;
        }
    }
    
    return sum;
}