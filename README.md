# 手搓一个数据库，教学用

第一期：实现以下方法：

```java
public interface Database {
    boolean insert(Comparable []values);
    Iterator<Comparable[]> fetchResult();
    Database filterEqual(int colIndex, Comparable value);
    Database filterNotEqual(int colIndex, Comparable value);
    Database filterIn(int colIndex, Comparable ... values);
    Database filterMoreThan(int colIndex, Comparable value);
    Database filterLessThan(int colIndex, Comparable value);
    Database sortBy(int colIndex, boolean ase);
}
```