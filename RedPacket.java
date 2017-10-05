import java.util.Scanner;


public class RedPacket {
	static double[] result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();   //�������
		double money = scanner.nextDouble();    //�ܽ��
		if (n*1.0/100>money) {    //��ÿ���˲��ܷ�����һ��Ǯ������ʾ���̫�٣���������
			System.out.println("Ǯ̫���ˣ��෢��������ǰ�");
			return;
		}
		allocateRedPacket(n,100*money);   //����100����Ԫת��Ϊ��
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		scanner.close();
	}

	private static void allocateRedPacket(int n, double money) {
		// TODO Auto-generated method stub
		result = new double[n];
		double[] randNumber = new double[n];
		double randSum = 0;   //�������
		double allocateSum = money-n;    //��ÿ��һ��Ǯ�ļƻ��۳�����ʣ�µ��ٷ���
		for (int i = 0; i < randNumber.length; i++) {
			randNumber[i]=Math.random()*allocateSum;    //���������
			randSum+=randNumber[i];
		}
		double left = allocateSum;
		for (int i = 0; i < result.length-1; i++) {			
			result[i]=Math.round(randNumber[i]/randSum*allocateSum);
			left -= result[i];
			result[i]=(result[i]+1)*1.0/100;       //��һ��Ǯ�ӻ�ȥ
		}
		result[n-1] = (left+1)*1.0/100;
	}

}
