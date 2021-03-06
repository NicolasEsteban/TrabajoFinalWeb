package datasessionbeans;

import data.Producto;
import java.util.List;
import javax.ejb.Local;

@Local
public interface Data_ProductoFacadeLocal {

    void create(Producto producto);

    void edit(Producto producto);

    void remove(Producto producto);

    Producto find(Object id);

    List<Producto> findAll();

    List<Producto> findRange(int[] range);

    int count();

}
