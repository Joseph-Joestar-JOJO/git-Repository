/*先升后降

Description

从一列不重复的数中筛除尽可能少的数使得从左往右看，这些数是从小到大再从大到小的。

Input

输入第一行为用例个数， 每个测试用例输入是一个数组，数值通过空格隔开。

Output

输出筛选之后的数组，用空格隔开。如果有多种结果，则一行一种结果， 单个输入的所有结果按从小到大排序，排序的key的优先级随index递增而递减 例如 3 4 7 6； 1 3 7 5； 1 2 7 6； 1 3 7 6 排序成 1 2 7 6；1 3 7 5；1 3 7 6； 3 4 7 6；

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
		int num=Integer.parseInt(scanner.nextLine());//次数
		for (int i = 0; i < num; i++) {
			map=new TreeMap<String, String>();
			String[] arr=scanner.nextLine().split(" ");
			int[] a=new int[arr.length];
			for (int j = 0; j < arr.length; j++) {
				a[j]=Integer.parseInt(arr[j]);
			}
			//k代表挖出几位数，从0开始
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
	
	//递归，k代表挖出的位数，每递归一次就-1，l代表上一次递归已经挖出的数组索引
	public static void GetArrByK(int[] a,int k,int l) {
		//全部挖好后
		if (k==0) {
			//符合条件，直接加入map
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
	
	
	//数组移除指定索引
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
	
	//判断是否符合递增递减
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
