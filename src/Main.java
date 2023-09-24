import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите количество измерений: ");
        int N = sc.nextInt();
        Stack<Double>I = new Stack<>();
        Stack<Double>U = new Stack<>();

        for(int i=0;i<N;i++) {
            System.out.print("Введите измерение силы тока(I) №"+(i+1)+": ");
            I.push(sc.nextDouble());
        }

        for(int i=0;i<N;i++) {
            System.out.print("Введите измерение напряжения тока(U) №"+(i+1)+": ");
            U.push(sc.nextDouble());
        }

        double R = ResistanceCalculator.calculateResistance(I, U);
        System.out.println("Приближенное значение сопротивления: " + R);
    }
}