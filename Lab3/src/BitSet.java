import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BitSet {

    private final ArrayList<String> universe;
    private int bitRepresentation;

    public BitSet(ArrayList<String> universe) {
        this.universe = universe;
        this.bitRepresentation = 0;
    }

    public void addString(String element) throws Exception {
        int index = universe.indexOf(element);

        if(index == -1) {
            throw new Exception(element + " is not in the Universe.");
        }
        this.bitRepresentation = BasicBitOperations.setBit(this.bitRepresentation, index);
    }

    public BitSet union(BitSet set) throws Exception {
        if(!this.universe.equals(set.universe)) {
            throw new Exception("The two sets have different universe.");
        }

        BitSet resultSet = new BitSet(this.universe);
        resultSet.bitRepresentation = this.bitRepresentation | set.bitRepresentation;
        return resultSet;
    }

    public BitSet intersect(BitSet set) throws Exception {
        if(!this.universe.equals(set.universe)) {
            throw new Exception("The two sets have different universe.");
        }

        BitSet resultSet = new BitSet(this.universe);
        resultSet.bitRepresentation = this.bitRepresentation & set.bitRepresentation;
        return resultSet;
    }

    public BitSet complement() {
        BitSet resultSet = new BitSet(this.universe);
        resultSet.bitRepresentation = ~this.bitRepresentation & ((1 << universe.size()) - 1);
        return resultSet;
    }

    public BitSet difference(BitSet set) throws Exception {
        return this.intersect(set.complement());
    }

    public int cardinality() {
        return Integer.bitCount(this.bitRepresentation);
    }

    public ArrayList<String> getElements() {
        ArrayList<String> elements= new ArrayList<>();
        for(int i = 0; i < universe.size(); i++)
        {
            if(BasicBitOperations.getBit(this.bitRepresentation, i) == 1)
            {
                elements.add(universe.get(i));
            }
        }
        return elements;
    }
}
