var array = [];
var visited = [];
var count = 0;
var row;
var col;

function inBounds(r, c){
    if (r >= row || r < 0 || c < 0 || c >= col)
        return false;
    else
        return true;
}

// depth-first search
function dfs(r, c){
    visited[r][c] = true;
    count++;
    // 8 directional search
    if (inBounds(r-1, c) && !visited[r-1][c] && array[r-1][c] == 1)
        dfs(r-1, c);
    if (inBounds(r-1, c-1)&& !visited[r-1][c-1] && array[r-1][c-1] == 1)
        dfs(r-1, c-1);
    if (inBounds(r-1, c+1) && !visited[r-1][c+1] && array[r-1][c+1] == 1)
        dfs(r-1, c+1);
    if (inBounds(r, c-1) && !visited[r][c-1] && array[r][c-1] == 1)
        dfs(r, c-1);
    if (inBounds(r, c+1) && !visited[r][c+1] && array[r][c+1] == 1)
        dfs(r, c+1);
    if (inBounds(r+1, c) && !visited[r+1][c] && array[r+1][c] == 1)
        dfs(r+1, c);
    if (inBounds(r+1, c-1) && !visited[r+1][c-1] && array[r+1][c-1] == 1)
        dfs(r+1, c-1);
    if (inBounds(r+1, c+1) && !visited[r+1][c+1] && array[r+1][c+1] == 1)
        dfs(r+1, c+1);
}

function processData(input) {
    var line = input.split('\n');
    row = parseInt(line[0]);
    col = parseInt(line[1]);
    // read input into a 2d array
    for (var i = 0; i < row; i++){
        array.push(line[i+2].split(' ').map(n => parseFloat(n)));
    }
    // initialize visited array to false
    for (var i = 0; i < row; i++){
        var vrow = [];
        for (var j = 0; j < col; j++){
            vrow[j] = false;
        }
        visited[i] = vrow;
    }
    // Go through each cell in grid. If unvisited and 1, do a DFS from it
    max = 0;
    for (var r = 0; r < row; r++){
        for (var c = 0; c < col; c++){
            if (array[r][c] == 1 && !visited[r][c]){
                dfs(r, c);
                if (count > max){
                    max = count;
                }
                count = 0; // reset
            }
        }
    }
    console.log(max);
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
