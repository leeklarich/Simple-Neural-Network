/**
 * Created by Lee on 9/6/2016.
 */
public class TransportLayer {
    public Connection[][] groupConnections;
    public Connection[] connections;

    public TransportLayer(NeuronLayer start, NeuronLayer end) { groupConnections = new Connection[end.size()][start.size()]; }
    public TransportLayer(NeuronLayer start, Neuron end) {
        connections = new Connection[start.size()];
        for(int j = 0; j < start.getLayer().length; j++)
            this.connections[j] = new Connection(start.get(j), end);
    }
}
