/*������

Description

��һ�в��ظ�������ɸ���������ٵ���ʹ�ô������ҿ�����Щ���Ǵ�С�����ٴӴ�С�ġ�

Input

�����һ��Ϊ���������� ÿ����������������һ�����飬��ֵͨ���ո������

Output

���ɸѡ֮������飬�ÿո����������ж��ֽ������һ��һ�ֽ���� ������������н������С�������������key�����ȼ���index�������ݼ� ���� 3 4 7 6�� 1 3 7 5�� 1 2 7 6�� 1 3 7 6 ����� 1 2 7 6��1 3 7 5��1 3 7 6�� 3 4 7 6��

Sample Input 1

4
1 2 4 7 11 10 9 15 3 5 8 6
1 3 5 4 7 6 4 5 3
1 2 3
3 2 1

Sample Output 1

1 2 4 7 11 10 9 8 6
1 3 4 7 6 4 3
1 3 4 7 6 5 3
1 3 5 7 6 4 3
1 3 5 7 6 5 3
1 2 3
3 2 1

*/
package oj1;

	import java.util.Map;
	import java.util.Scanner;
	import java.util.Set;
	import java.util.TreeMap;
	
	public class t7 {
		static int[] a;
		static Map<String, String> map;
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int num=Integer.parseInt(scanner.nextLine());//����
		for (int i = 0; i < num; i++) {
			map=new TreeMap<String, String>();
			String[] arr=scanner.nextLine().split(" ");
			int[] a=new int[arr.length];
			for (int j = 0; j < arr.length; j++) {
				a[j]=Integer.parseInt(arr[j]);
			}
			//k�����ڳ���λ������0��ʼ
			for (int k = 0; k< a.length-1; k++) {
				GetArrByK(a,k,0);
				if (!map.isEmpty()) {
					break;
				}
			}
			Set<String> entry=map.keySet();
			for (String string : entry) {
				System.out.println(string);
			}
		}
	}
	
	//�ݹ飬k�����ڳ���λ����ÿ�ݹ�һ�ξ�-1��l������һ�εݹ��Ѿ��ڳ�����������
	public static void GetArrByK(int[] a,int k,int l) {
		//ȫ���ںú�
		if (k==0) {
			//����������ֱ�Ӽ���map
			if (isRight(a)) {
				StringBuilder sBuilder=new StringBuilder();
				for (int i = 0; i < a.length-1; i++) {
					sBuilder.append(a[i]+" ");
				}
				sBuilder.append(a[a.length-1]);
				map.put(sBuilder.toString(), " ");
			}
			return;
		}
		int[] tmp=new int[a.length-1];
		int x=k-1;
		for (int i = l; i <a.length; i++) {
			tmp=remove(a,i);
			GetArrByK(tmp ,x,i);
		}
	}
	
	
	//�����Ƴ�ָ������
	public static int[] remove(int[] a,int index) {
		int[] tmp=new int[a.length-1];
		int index2=0;
		for (int i = 0; i < a.length; i++) {
			if (i!=index) {
				tmp[index2++]=a[i];
			}
		}
		return tmp;
	}
	
	//�ж��Ƿ���ϵ����ݼ�
	public static boolean isRight(int[] a) {
		boolean isPositive=true;
		for (int i = 1; i < a.length; i++) {
			if (a[i]<a[i-1]) {
				isPositive=false;
			}
			if (isPositive) {
				if (a[i]<a[i-1]) {
					return false;
				}
			}
			else {
				if (a[i]>a[i-1]) {
					return false;
				}
			}
		}
		return true;
	}
	}
