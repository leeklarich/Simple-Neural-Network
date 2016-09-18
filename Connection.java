/**
 * Created by Lee on 9/6/2016.
 */
public class Connection {
    private Neuron start, end;
    private double weight;

    public Connection(Neuron a, Neuron b) {
        this.start = a;
        this.end = b;
        this.weight = Math.random();
    }

    public Neuron getStart() { return this.start; }
    public Neuron getEnd() { return this.end; }
    public double getWeight() { return this.weight; }
    public void setWeight(double d) { this.weight = d; }
}
