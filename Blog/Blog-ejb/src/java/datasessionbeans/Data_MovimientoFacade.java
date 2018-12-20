package datasessionbeans;


import data.Movimiento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Data_MovimientoFacade extends Data_AbstractFacade<Movimiento> implements Data_MovimientoFacadeLocal {

    @PersistenceContext(unitName = "Blog-ejbPU")

    private EntityManager em;

    public Data_MovimientoFacade() {
        super(Movimiento.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

 
}
