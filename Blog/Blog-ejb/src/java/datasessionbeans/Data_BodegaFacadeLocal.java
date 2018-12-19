package datasessionbeans;

import data.Bodega;
import java.util.List;
import javax.ejb.Local;

@Local
public interface Data_BodegaFacadeLocal {

    void create(Bodega bodega);

    void edit(Bodega bodega);

    void remove(Bodega bodega);

    Bodega find(Object id);

    List<Bodega> findAll();

    List<Bodega> findRange(int[] range);

    int count();

}
