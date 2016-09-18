/**
 * Created by Lee on 9/6/2016.
 */
public class NeuronLayer {
    private Neuron[] layer;

    public NeuronLayer(int size) {
        this.layer = new Neuron[size + 1];
        for(int i = 0; i < layer.length; i++)
            this.layer[i] = new Neuron();
        this.layer[layer.length - 1].setValue(1);
    }

    public Neuron get(int index) {return this.layer[index];}
    public void set(int index, double val) {this.layer[index].setValue(val);}
    public int size() {return this.layer.length;}
    public Neuron[] getLayer() { return this.layer; }

    public void receive(double[] ins) {
        if(ins.length == this.layer.length - 1) {
            for (int i = 0; i < ins.length; i++) {
                 this.layer[i].setValue(ins[i]);
            }
        }
    }
}
