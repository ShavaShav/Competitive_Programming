function processData(input) {
    var lines = input.split('\n');
    var ln = lines[0].split(' ');
    var n = ln[0];
    var k = ln[1];
    ln = lines[1].split(' ');
    var array = [];
    for (var i = 0; i < n; i++){
        array.push(parseInt(ln[i]));
    }
    array.sort((a,b) => a - b);
    var num = 0;
    for (let i of array){
        k -= i;
        if(k < 0)
            break;  // overspent
        num++;
    }
    console.log(num);
} 

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
   processData(_input);
});
