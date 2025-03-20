#include <iostream>
#include <string>
#include <vector>

using namespace std;

char alpabet[] = {'A', 'E', 'I', 'O', 'U'};
vector<string> list;

void DFS(string currentWords)
{
    if(currentWords.length() > 5) return;
    
    list.push_back(currentWords);
    
    for(int i = 0; i < sizeof(alpabet); i++)
        DFS(currentWords + alpabet[i]);
    
    return;
}

int solution(string word) {
    DFS("");
    
    for(int i = 0 ; i < list.size(); i++)
    {
        if(list[i] == word) return i;
    }
    return 0;
}