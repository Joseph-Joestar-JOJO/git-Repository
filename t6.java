/*�̶��͵�Ԫ�ض�

Description

����һ�������һ�����֣��������в�����������ʹ�����ǵĺ�������������Ǹ����֣�ͳ�������������Ķ�����

Input

�����һ��Ϊ���������� ÿ���������������һ�������飬ÿһ�����ÿո�������ڶ��������ֺ͡�

Output

��������������м��ԡ�

Sample Input 1

1
1 2 4 7 11 0 9 15
11

Sample Output 1

3

*/
package oj1;

import java.util.Scanner;

public class t6 {
public static void main(String[] args) {
	try {
	Scanner scanner=new Scanner(System.in);
	int num=Integer.parseInt(scanner.nextLine());//����
	for (int i = 0; i < num; i++) {
		String[] arr=scanner.nextLine().split(" ");
		int key=Integer.parseInt(scanner.nextLine());
		int[] arr1=new int[arr.length];
		for (int j = 0; j < arr1.length; j++) {
			arr1[j]=Integer.parseInt(arr[j]);
		}
		getSumCount(arr1,key);
	}
	} catch (Exception e) {
		// TODO: handle exception
	}
}
	public static void getSumCount(int[] a,int k) {
		int count=0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (a[i]+a[j]==k) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
