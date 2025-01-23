function solution(number) 
{
    number = number.sort((a,b) => a - b)
    let count = 0;
    let arr = []
    
    for(let i = 0; i < number.length - 2; i++)
    {
        let temp = number[i]
        for(let j = i + 1; j < number.length - 1; j++)
        {
            for(let k = j + 1; k < number.length; k++)
            {
                number[j] + number[k]
                arr.push(number[j] + number[k])
            }
            
            arr.map((element)=> element + temp == 0 ? count++ : count)
            arr = []
        }
    }
    return count
}