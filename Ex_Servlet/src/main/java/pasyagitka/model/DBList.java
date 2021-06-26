package pasyagitka.model;

import java.util.ArrayList;
import java.util.List;

public class DBList {
    private static DBList instance;
    private final List<Book> list;

    private DBList()
    {
        list = new ArrayList<>();
    }
    public static DBList getInstance()
    {
        if ( instance != null) {
            return instance;
        }
        instance = new DBList();
        return instance;
    }

    public List<Book> getList() {
        return list;
    }

    public void add(Book r)
    {
        list.add(r);
    }
    public void clear(){ list.clear(); }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Book r: list) {
            result.append(r.toString());
        }
        return result.toString();
    }
}
