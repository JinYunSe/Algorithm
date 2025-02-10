function solution(lottos, win_nums) {
    lottos = lottos.sort((a,b)=> a - b)
    console.log(lottos)
    let max = 0, min = 0
    lottos.forEach((element)=>
    {
        element === 0 ? max++ : max;
        win_nums.forEach((element2)=>
        {
            element === element2 ? min++ : min;    
        })
    })
    
    return [7 - (max + min) === 7 ? 6 : 7 - (max + min),
            7 - (min) === 7 ? 6 : 7 - (min)];
}