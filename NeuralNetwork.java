/**
 * Created by Lee on 9/6/2016.
 */
public class NeuralNetwork {
    static NeuronLayer inputs;
    static Neuron output;
    static TransportLayer tpl1;

    public static void main(String[] args) {
        //Initialize input layer and output layer
        inputs = new NeuronLayer(3);
        output = new Neuron();
        tpl1 = new TransportLayer(inputs, output);
        tpl1 = makeConnections(inputs, output);

        for(int i = 0; i < 2000; i++) {
            double[][] testVals = makeTripleBinaryTestValues(8);
            double[] testAnswers = evaluate1(testVals);

            for(int j = 0; j < testAnswers.length; j++) {
                inputs.receive(testVals[j]);
                train(testAnswers[j]);
            }
        }

        inputs.receive(new double[]{1, 1, 0});
        think();
        System.out.println(Math.round(sigmoid(output.getValue())));
    }

    //Update the synaptic weights
    public static void train(double out) {
        double resp;
        if(tpl1.connections[0] != null) {
            think();
            resp = sigmoid(output.getValue());
            double error = out - resp;
            for(int i = 0; i < tpl1.connections.length; i++) {
                tpl1.connections[i].setWeight(tpl1.connections[i].getWeight() + tpl1.connections[i].getStart().getValue() * error * dSigmoid(resp));
            }
        }
        else {
            // Multi-layered code...
            System.out.println("Error");
        }
    }

    //Processes the neuron values to give a value to the output neuron
    public static void think() {
        double resp = 0;
        for(int i = 0; i < tpl1.connections.length; i++) {
            resp += tpl1.connections[i].getStart().getValue() * tpl1.connections[i].getWeight();
        }
        output.setValue(resp);
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

    public static double sigmoid(double in) { return (1 / (1 + Math.exp(-in))); }
    public static double dSigmoid(double in) { return in * (1 - (in)); }

    //Create test values
    public static double[][] makeTripleBinaryTestValues(int quantity) {
        double[][] t = new double[quantity][3];
        int count = 0;
        if(quantity > 8) {
            double[] temp = new double[3];
            for(int i = 0; i < 2; i++) {
                temp[0] = i;
                for(int j = 0; j < 2; j++) {
                    temp[1] = j;
                    for(int k = 0; k < 2; k++) {
                        temp[2] = k;
                        t[count] = temp;
                        count++;
                    }
                }
            }
        }
        for(int i = 0; i < quantity - count; i++) {
            t[i + count][0] = Math.round(Math.random());
            t[i + count][1] = Math.round(Math.random());
            t[i + count][2] = Math.round(Math.random());
        }
        return t;
    }

    //Evaluate generated test values for (i or j) -> k
    public static double[] evaluate1(double[][] d) {
        double[] retVal = new double[d.length];
        for(int i = 0; i < retVal.length; i++)
            retVal[i] = (((d[i][0] == 1 || d[i][1] == 1) && d[i][2] == 1) || ((d[i][0] != 1 && d[i][1] != 1))) ? 1 : 0;
        return retVal;
    }

    //Evaluate generated test values for (i and j) -> k
    public static double[] evaluate2(double[][] d) {
        double[] retVal = new double[d.length];
        for(int i = 0; i < retVal.length; i++)
            retVal[i] = (((d[i][0] == 1 && d[i][1] == 1) && d[i][2] == 1) || (d[i][0] == 0 && d[i][1] == 0)) ? 1 : 0;
        return retVal;
    }
}
