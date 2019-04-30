package CodeForOffer.四月30号;

public class HasPath {

    /*
    题目：
    请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
    思路：深度搜索而已
     */
    int[][] yi = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        char[][] map = new char[rows][cols];
        int[][] jilu = new int[rows][cols];
        int length = str.length;
        int flag = 0;
        for(int i = 0 ; i < rows; i++)
            for(int j = 0; j < cols; j++)
                map[i][j] = matrix[i * cols + j];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols ; j++){
                if(map[i][j] == str[0]){
                    jilu[i][j] = 1;
                    if(search(map,i,j,0,jilu,length,str)) {
                        flag = 1;
                        break;
                    }
                    jilu[i][j] = 0;
                }
            }
            if(flag == 1) break;
        }
        if(flag == 1) return true;
        else return false;
    }
    boolean search(char[][] map,int x,int y,int index,int[][] jilu,int length,char[] str){
        int rows = map.length;
        int cols = map[0].length;
        if(index == length - 1){
            return true;
        }
        for(int i = 0; i < 4; i++){
            int nowX = x + yi[i][0] , nowY = y + yi[i][1];
            if(nowX >= 0 && nowX < rows && nowY >= 0 && nowY < cols ){
                if(map[nowX][nowY] == str[index + 1] && jilu[nowX][nowY] == 0){
                    jilu[nowX][nowY] = 1;
                    if(search(map,nowX,nowY,index + 1,jilu,length,str)){
                        return  true;
                    }
                    jilu[nowX][nowY] = 0;
                }
            }
        }
        return false;
    }

}
