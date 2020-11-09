a.b.c();
to.equal();
package oj1;
public class Hanoi {
public static void main(String[] args) {
	hanoiProbleml(2, "zuo", "zhong", "you");
}
    public static int hanoiProbleml(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    public static int process(int num, String left, String mid, String right, String form, String to) {
        if (num == 1) {
            if (form.equals(mid) || to.equals(mid)) {
                System.out.println("Move 1 from" + form + "to" + mid);
                return 1;
            } else {
                System.out.println("Move 1 from" + form + "to" + mid);
                System.out.println("Move 1 from" + mid + "to" + to);
                return 2;
            }
        }
        if (form.equals(mid) || to.equals(mid)) {
            String another = (form.equals(left) || to.equals(left)) ? right : left;
            int part1 = process(num - 1, left, mid, right, form, another);
            int part2 = 1;
            System.out.println("Move" + num + "form" + form + "to" + to);
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(num - 1, left, mid, right, form, to);
            int part2 = 1;
            System.out.println("Move" + num + "form" + form + "to" + mid);
            int part3 = process(num - 1, left, mid, right, to, form);
            int part4 = 1;
            System.out.println("Move" + num + "form" + mid + "to" + to);
            int part5 = process(num - 1, left, mid, right, form, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

}