import java.util.*;

public class SampleDatabase implements Database {
    private List<Comparable[]> store;
    private int colSize ;
    public SampleDatabase(int colSize) {
        this.store = new ArrayList<>();
        this.colSize = colSize;
    }

    private SampleDatabase(List<Comparable[]> store) {
        this.store = store;
    }

    @Override
    public boolean insert(Comparable[] values) {

        if(values.length != colSize){
            throw new RuntimeException("列的大小必须为："+colSize+",实际插入大小为"+values.length);
        }
        store.add(values);
        return true;
    }

    @Override
    public Iterator<Comparable[]> fetchResult() {
        return store.iterator();
    }



    @Override
    public Database filterEqual(int colIndex, Comparable value) {
        List<Comparable[]> result = new ArrayList<>();
        for (Comparable[] next : store) {
            if (Objects.equals(next[colIndex], value)) {
                result.add(next);
            }
        }
        return new SampleDatabase(result);
    }

    @Override
    public Database filterNotEqual(int colIndex, Comparable value) {
        List<Comparable[]> result = new ArrayList<>();
        for (Comparable[] next : store) {
            if (!Objects.equals(next[colIndex], value)) {
                result.add(next);
            }
        }
        return new SampleDatabase(result);
    }

    @Override
    public Database filterIn(int colIndex, Comparable ... values) {
        List<Comparable[]> result = new ArrayList<>();
        for (Comparable[] next : store) {
            for (Comparable value : values) {
                if (Objects.equals(next[colIndex], value)) {
                    result.add(next);
                }
            }
        }
        return new SampleDatabase(result);
    }

    @Override
    public Database filterMoreThan(int colIndex, Comparable value) {
        List<Comparable[]> result = new ArrayList<>();
        for (Comparable[] next : store) {
            if (moreThan(next[colIndex], value)){
                result.add(next);
            }
        }
        return new SampleDatabase(result);
    }


    @Override
    public Database filterLessThan(int colIndex, Comparable value) {
        List<Comparable[]> result = new ArrayList<>();
        for (Comparable[] next : store) {
            if (lessThan(next[colIndex], value)){
                result.add(next);
            }
        }
        return new SampleDatabase(result);
    }

    @Override
    public Database sortBy(int colIndex, boolean ase) {

        throw new RuntimeException("not impl sortBy");
    }


    private boolean moreThan(Comparable v1,Comparable v2){
        if(v1 == null || v2 == null) return false;

        return v1.compareTo(v2) > 0;
    }

    private boolean lessThan(Comparable v1,Comparable v2){
        if(v1 == null || v2 == null) return false;

        return v1.compareTo(v2) < 0;
    }

}
