function solution(number, limit, power) {
    let result = 1;
    for(i = 2; i <= number; i++)
    {
        let count = 2;
        let temp = Math.sqrt(i);
        for(let j = 2; j <= temp; j++)
        {
            if(i % j === 0)
            {
                if(temp === j) count++;
                else count += 2;
            }
        }
        if(limit < count) result += power
        else result+= count
    }
    
    return result
}