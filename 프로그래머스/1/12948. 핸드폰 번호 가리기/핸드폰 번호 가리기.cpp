#include <string>
#include <vector>

using namespace std;

string solution(string phone_number) 
{
    string answer = "";
    for(int i = 0; i < phone_number.size();i++)
    {
        answer += i < phone_number.size() - 4 ? '*' : phone_number[i];
    }
    return answer;
}