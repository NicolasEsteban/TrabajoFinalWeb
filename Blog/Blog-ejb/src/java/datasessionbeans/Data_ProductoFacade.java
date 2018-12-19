package datasessionbeans;

import data.Producto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Data_ProductoFacade extends Data_AbstractFacade<Producto> implements Data_ProductoFacadeLocal {

    @PersistenceContext(unitName = "Blog-ejbPU")

    private EntityManager em;

    public Data_ProductoFacade() {
        super(Producto.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
