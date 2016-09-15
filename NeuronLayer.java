/**
 * Created by Lee on 9/6/2016.
 */
public class NeuronLayer {
    private Neuron[] layer;

    public NeuronLayer(int size) {
        layer = new Neuron[size];
    }

    public double getSum() {
        double temp = 0;
        for(Neuron e: layer)
            temp += e.getValue();
        return temp;
    }

    public Neuron get(int index) {return this.layer[index];}
    public void set(int index, double val) {this.layer[index].setValue(val);}
    public int size() {return this.layer.length;}
}
