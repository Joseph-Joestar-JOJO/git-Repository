/*�����k��С

Description

�ҵ���������ĸ��������ڵĵ�KС����ֵ��

Input

�����һ��Ϊ���������� ÿ��������������ĵ�һ��Ϊ���飬ÿһ�����ÿո�������ڶ��������䣨�ڼ��������ڼ���������ͷ��������������ֵ�ÿո������������ΪKֵ��

Output

�����

Sample Input 1

1
1 2 3 4 5 6 7
3 5
2

Sample Output 1

4

*/
package oj1;

import java.util.Arrays;
import java.util.Scanner;
public class t5 {
public static void main(String[] args) {
	try {
	Scanner scanner=new Scanner(System.in);
	int num=Integer.parseInt(scanner.nextLine());//����
	for (int i = 0; i < num; i++) {
		String[] arr=scanner.nextLine().split(" ");
		String[] loc=scanner.nextLine().split(" ");
		int s=Integer.parseInt(loc[0]);
		int e=Integer.parseInt(loc[1]);
		int key=Integer.parseInt(scanner.nextLine());
		int[] arr1=new int[arr.length];
		for (int j = 0; j < arr1.length; j++) {
			arr1[j]=Integer.parseInt(arr[j]);
		}
		getMinByKey(arr1,key,s,e);
	}
	} catch (Exception e) {
		// TODO: handle exception
	}
}

public static void getMinByKey(int[] a,int k,int start,int end) {
	int[] tmp=new int[end-start+1];
	int index=0;
	for (int i = start-1; i < end; i++) {
		tmp[index++]=a[i];
	}
	Arrays.sort(tmp);
	System.out.println(tmp[k-1]);
}
}
