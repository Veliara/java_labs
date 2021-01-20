package sample;

public class Function {
    double[] x, y;
    double a = 1.5, eps = 0.0000001;
    int p = 4;
    double beg, end, step;

    Function(double beg, double end, double step) {
        this.beg = beg;
        this.end = end;
        this.step = step;
        fillX(beg, end, step);
        fillY(x);

    }

    public int stepsCount(double beg, double end, double step) {
        return (int) ((end - beg) / step + 1);
    }

    public double calcFun(double x) {
        if (Math.abs(x - 1.7) < eps)
            return (a * (x * x * x) + 7 * Math.sqrt(x));
        else if (x < 1.7)
            return (p * x * x - 7 / (x * x));
        else return Math.log10(x + 7 * Math.sqrt(x));
    }

    public void fillX(double beg, double end, double step) {
        int lengthArray = stepsCount(beg, end, step);
        x = new double[lengthArray];
        for (int i = 0; i < x.length; i++) {
            x[i] = beg + i * step;
        }
    }

    public void fillY(double[] x) {
        y = new double[x.length];
        for (int i = 0; i < y.length; i++) {
            y[i] = calcFun(x[i]);
        }
    }

    public String getArrays() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stepsCount(beg, end, step); i++) {
            sb.append(i + ".  x= " + x[i] + ",  y= " + y[i] + "\n");
        }
        return sb.toString();
    }

    public int indexMax() {
        int index = 0;
        for (int i = 1; i < y.length; i++) {
            if (y[index] < y[i])
                index = i;
        }
        return index;
    }

    public int indexMin() {
        int index = 0;
        for (int i = 1; i < y.length; i++) {
            if (y[index] > y[i])
                index = i;
        }
        return index;
    }

    public void showMinMax() {
        System.out.printf("Min = %f; Index = %d; x = %f\n", y[indexMin()], indexMin(), x[indexMin()]);
        System.out.printf("Max = %f; Index = %d; x = %f\n", y[indexMax()], indexMax(), x[indexMax()]);
    }

    public double sumArray() {
        double sum = 0;
        for (double v : y) {
            sum += v;
        }
        return sum;
    }

    public double meanArray() {
        return sumArray() / y.length;
    }

    public double getX(int i) {
        return x[i];
    }

    public double getY(int i) {
        return y[i];
    }

    public int getStepsCount() {
        return stepsCount(beg, end, step);
    }
}
