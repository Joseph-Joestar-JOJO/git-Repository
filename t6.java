/*固定和的元素对

Description

输入一个数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字，统计这样两个数的对数。

Input

输入第一行为用例个数， 每个测试用例输入第一行是数组，每一个数用空格隔开；第二行是数字和。

Output

输出这样两个数有几对。

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
	int num=Integer.parseInt(scanner.nextLine());//次数
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
