/**
 * Created by Lee on 9/6/2016.
 */
import java.lang.Math;

public class Neuron {
    private double value, activationValue;

    public void setValue(double d) {this.value = d;}
    public double getValue() {return this.value;}
    public void modifyValue(double d) {this.value += d;}

    public double activate() {
        this.activationValue = sigmoid(value);
        return this.activationValue;
    }

    public double sigmoid(double in) { return 1 / (1 + Math.exp(-in)); }
    public double dSigmoid(double in) { return sigmoid(in) * (1 - sigmoid(in)); }
}
