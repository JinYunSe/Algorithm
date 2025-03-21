#include <string>
#include <vector>

using namespace std;

int solution(int num) 
{   
    long temp  = num;
    int count = 0;
    
    while(temp != 1)
    {
        temp = temp % 2 == 0 ? temp / 2 : temp * 3 + 1;
        count++;
    }
    
    return count > 500 ? -1 : count;
}