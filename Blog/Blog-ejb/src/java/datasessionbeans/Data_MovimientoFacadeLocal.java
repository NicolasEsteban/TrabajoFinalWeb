package datasessionbeans;

import data.Movimiento;
import java.util.List;
import javax.ejb.Local;

@Local
public interface Data_MovimientoFacadeLocal {

    void create(Movimiento movimiento);

    void edit(Movimiento movimiento);

    void remove(Movimiento movimiento);

    Movimiento find(Object id);

    List<Movimiento> findAll();

    List<Movimiento> findRange(int[] range);

    int count();

}
