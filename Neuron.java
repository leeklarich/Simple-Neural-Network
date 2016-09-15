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
        this.activationValue = psi(value);
        return this.activationValue;
    }

    public double psi(double in) {
        return 1 / (1 + Math.pow(Math.E, -in));
    }

    public double deltaPsi(double in) {
        return psi(in) * (1 - psi(in));
    }
}
