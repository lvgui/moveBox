package moveBox;
//游戏配置信息
public class Config {
	
	public static int WIDTH = 320;
	public static int HEIGHT = 320;
	public static int CELL = 32;
	
	public static final int LEFT = 2;
	public static final int	UP = 4;
	public static final int	RIGHT = 3;
	public static final int	DOWN = 1;	
	
	public static final int [][]  map ={//地图状态数组 1:路   0:强   2:目标位置 3：箱子位置 4：人物位置 5  箱子目标位置
        {1,1,0,0,0,0,0,0,1,1},
        {0,0,0,1,1,1,1,0,0,0},
        {0,1,1,1,1,1,1,1,1,0},
        {0,1,0,1,0,1,1,0,1,0},
        {0,1,1,1,1,1,1,0,1,0},
        {0,0,0,1,1,1,1,1,1,0},
        {1,1,0,1,1,1,0,0,0,0},
        {1,1,0,1,1,1,0,1,1,1},
        {1,1,0,1,1,1,0,1,1,1},
        {1,1,0,0,0,0,0,1,1,1}
       };
	public static  int[][] targersBox = new int[][] {{2,3},{4,3},{1,5},{3,5},{4,5},{6,5}}; //箱子要被推到的目标位置
	
	public static  int[][] boxFirst = new int[][]{{2,2},{2,4},{2,5},{2,6},{5,5},{6,4}};  	//箱子起始的位置,这个游戏箱子的位置即是这个
	
}
