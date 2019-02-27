package ImageData.Model;

public class Part {

    private final Topology topology;
    private final int start;
    private final int count;

    public Part(Topology topology, int start, int count) {
        this.topology = topology;
        this.start = start;
        this.count = count;
    }
}
