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
    Database count(int colIndex);
    Database countDistinct(int ... colIndexList);
    Database groupByCount(int colIndex,int countColIndex);
    Database groupByCountDistinct(int colIndex,int ... countColIndexList);
    Database join(Database other,int onEqualIndexLeft,int onEqualIndexRight);
}
```


第二期：实现以下方法：

引入Expression，以实现相当灵活的接口。


```java
public interface Database {
    boolean insert(Comparable []values);
    Iterator<Comparable[]> fetchResult();
    Database filter(Expression filterExpression);
    Database sortBy(Expression ... cols);
    Database count(Expression col);
    Database countDistinct(Expression ... cols);
    Database groupBy(Expression ... cols);
    Database join(Database other, Expression onCondition);
}
```