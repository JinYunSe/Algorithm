function solution(cards1, cards2, goal) 
{
    let check = true
    goal.map((element)=>
    {
        if(element == cards1[0]) cards1.shift()
        else if(element == cards2[0]) cards2.shift()
        else check = false
    })
    return check ? "Yes" : "No"
}