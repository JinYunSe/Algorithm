function solution(s) {
    let count = 0;
    let zeroCount = 0;
    while(s.length !== 1){
        let zero = s.match(/0/g)
        zeroCount += (zero !== null) ? zero.length : 0
        s = s.replace(/0/g,"")
        s = Number(s.length).toString(2)
        count++
    }
    return [count, zeroCount];
}