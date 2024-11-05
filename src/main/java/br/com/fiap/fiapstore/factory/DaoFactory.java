package  br.com.fiap.fiapstore.factory;

import br.com.fiap.fiapstore.dao.ProductDao;
import br.com.fiap.fiapstore.dao.impl.OracleProductDao;


public class DaoFactory {

    public static ProductDao getProductDAO() {
        return new OracleProductDao();
    }
}
