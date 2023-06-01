package DataAccess;

public class DataForTable {
    Object[] antet ;
    Object[][] table;
    public DataForTable( Object[] antet,Object[][] table){
        this.antet = antet;
        this.table = table;
    }

    public Object[] getAntet() {
        return antet;
    }

    public Object[][] getTable() {
        return table;
    }
}

