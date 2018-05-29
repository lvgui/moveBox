package moveBox;
//��Ϸ������Ϣ
public class Config {
	
	public static int WIDTH = 320;
	public static int HEIGHT = 320;
	public static int CELL = 32;
	
	public static final int LEFT = 2;
	public static final int	UP = 4;
	public static final int	RIGHT = 3;
	public static final int	DOWN = 1;	
	
	public static final int [][]  map ={//��ͼ״̬���� 1:·   0:ǿ   2:Ŀ��λ�� 3������λ�� 4������λ�� 5  ����Ŀ��λ��
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
	public static  int[][] targersBox = new int[][] {{2,3},{4,3},{1,5},{3,5},{4,5},{6,5}}; //����Ҫ���Ƶ���Ŀ��λ��
	
	public static  int[][] boxFirst = new int[][]{{2,2},{2,4},{2,5},{2,6},{5,5},{6,4}};  	//������ʼ��λ��,�����Ϸ���ӵ�λ�ü������
	
}
