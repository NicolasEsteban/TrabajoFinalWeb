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

    @Override
    public void create(Movimiento movimiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Movimiento movimiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Movimiento movimiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Movimiento find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Movimiento> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Movimiento> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
