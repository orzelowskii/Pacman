
public class MazeGenerate {
    private int[][] maze;


    public MazeGenerate() {
    }

    public int[][] mazeGenerator(int[][] maze){
        for(int i = 1;i< maze.length-1;i++){
            if(i%2 != 0){
                for(int j = 0;j<maze[i].length-1;j++){
                    int tmp = (int)(Math.random()*4)+1;
                    if(j<maze[i].length-tmp){
                        for(int k = j;k<j+tmp;k++){
                            j++;
                            k++;
                            maze[i][j] = 1;
                        }
                    }
                    j++;
                }
            }
            i++;
        }
        return maze;
    }


}
