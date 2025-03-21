#include <string>
#include <vector>

using namespace std;

string solution(vector<string> seoul) {
    
    string temp = "김서방은 ";
    for(int i = 0; i < seoul.size();i++)
    {
        if(seoul[i] == "Kim")
        {
            temp += to_string(i)+"에 있다";
            break;
        }
    }
    
    return temp;
}