import java.util.Stack;

public class ResistanceCalculator {
    public static double calculateResistance(Stack<Double> I, Stack<Double> U)
    {
        //Проверка на одинаковый размер
        if (I.size() != U.size()) {
            throw new IllegalArgumentException("Стеки I и U должны иметь одинаковый размер");
        }

        int N = I.size();

        // Вычисляем средние значения тока и напряжения
        double I_avg = 0.0;
        double U_avg = 0.0;
        for (int i = 0; i < N; i++) {
            I_avg += I.get(i);
            U_avg += U.get(i);
        }
        I_avg /= N;
        U_avg /= N;

        // Вычисляем сумму произведений (I[i] - I_avg) * (U[i] - U_avg)
        double sum = 0.0;
        for (int i = 0; i < N; i++) {
            double deltaI = I.get(i) - I_avg;
            double deltaU = U.get(i) - U_avg;
            sum += deltaI * deltaU;
        }

        // Вычисляем сумму квадратов (U[i] - U_avg)
        double sumSquares = 0.0;
        for (int i = 0; i < N; i++) {
            double deltaU = U.get(i) - U_avg;
            sumSquares += deltaU * deltaU;
        }

        // Вычисляем значение сопротивления R
        double R = sum / sumSquares;

        return R;
    }
}
