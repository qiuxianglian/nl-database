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


    public static void main(String[] args) {
        Database database = new SampleDatabase(2);// todo impl Database
        testDb(database);
    }

    static void testDb(Database database){
        database.insert(new Comparable[]{"小明",12});
        database.insert(new Comparable[]{"张三",43});
        database.insert(new Comparable[]{"李四",28});
        database.insert(new Comparable[]{"小红",15});
        database.insert(new Comparable[]{"唐僧",23});


        Iterator<Comparable[]> id1 = database
                .filterMoreThan(1, 13)
                .filterLessThan(1,30)
//                .sortBy(1,true)
                .fetchResult();
        show(id1,"filterMoreThan 11 and filterLessThan 30");
    }
    static void show(Iterator<Comparable[]> result,String name){
        System.out.println("--------------query "+name+"--------------------");
        while (result.hasNext()){
            Object[] next = result.next();
            for (Object o : next) {
                System.out.print(o);
                System.out.print("\t");
            }
            System.out.println();
        }
    }


}
