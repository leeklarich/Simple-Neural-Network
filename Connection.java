/**
 * Created by Lee on 9/6/2016.
 */
import java.math.*;

public class Connection {
    private Neuron start, end;
    private double weight;

    public Connection(Neuron a, Neuron b) {
        this.start = a;
        this.end = b;
        this.weight = Math.random();
    }
}
