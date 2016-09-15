/**
 * Created by Lee on 9/6/2016.
 */
public class NeuralNetwork {
    public static void main(String[] args) {
        //Initialize input layer and output layer
        NeuronLayer inputs = new NeuronLayer(2);
        Neuron output = new Neuron();

        //Start making connections between neurons
        TransportLayer tpl1 = makeConnections(inputs, output);

        //Creates single test data set
        double[] testData = {0.2, 0.3};
        double testResponse = 0;

        //Broken code for testing purposes
        for(int i = 0; i < inputs.size(); i++)
            inputs.set(i, testData[i]);

    }

    public static void train() {

    }

    //Use this method for getting the connections between a layer with multiple neurons and one with only one neuron
    public static TransportLayer makeConnections(NeuronLayer layer, Neuron n) {
        TransportLayer tpl = new TransportLayer(layer, n);
        for(int i = 0; i < layer.size(); i++) {
            tpl.connections[i] = new Connection(layer.get(i), n);
        }
        return tpl;
    }

    //Use this method for getting the connections between two layers that both have multiple neurons
    public static TransportLayer makeConnections(NeuronLayer start, NeuronLayer end) {
        TransportLayer tpl = new TransportLayer(start, end);
        for(int i = 0; i < end.size(); i++) {
            for(int j = 0; j < start.size(); j++) {
                tpl.groupConnections[i][j] = new Connection(start.get(j), end.get(i));
            }
        }
        return tpl;
    }
}
