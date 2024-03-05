package v1;

import java.util.Iterator;

public interface Database {
    boolean insert(Comparable []values);
    Iterator<Comparable[]> fetchResult();
    Database filterEqual(int colIndex, Comparable value);
    Database filterNotEqual(int colIndex, Comparable value);
    Database filterIn(int colIndex, Comparable ... values);
    Database filterMoreThan(int colIndex, Comparable value);
    Database filterLessThan(int colIndex, Comparable value);
    Database sortBy(int colIndex, boolean ase);
    Database count(int colIndex);
    Database countDistinct(int ... colIndexList);
    Database groupByCount(int colIndex,int countColIndex);
    Database groupByCountDistinct(int colIndex,int ... countColIndexList);
    Database join(Database other,int onEqualIndexLeft,int onEqualIndexRight);

}
