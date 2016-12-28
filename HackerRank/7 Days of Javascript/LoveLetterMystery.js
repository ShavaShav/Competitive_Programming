function processData(input) {
    var string = input.split('\n');
    var t = parseInt(string[0]);
    for (var i = 1; i <= t; i++){
        var count = 0;
        for (var l = 0, r = string[i].length-1; l < r; l++, r--){
               count += Math.abs(string[i].charCodeAt(l) - string[i].charCodeAt(r));
        }
        console.log(count);
    } 
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
