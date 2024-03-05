package v2;

import java.util.Iterator;

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
