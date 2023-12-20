package co.id.test.sales.Dao.DaoProcces;

import co.id.test.sales.Constant.HttpConstant;
import co.id.test.sales.Constant.QueryConstant;
import co.id.test.sales.Dao.PerentInterfaceDao;
import co.id.test.sales.Exception.ResponseErrorException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.util.List;


@Repository("GroupProductDao")
@Log4j2
@Primary
public class GroupProductDao implements PerentInterfaceDao
{
    /*
    * propertie untuk transaction manager pada jdbc
    * */
    @Autowired
    private PlatformTransactionManager transactionManager;
    /*
     * propertie jdbcTemplate
     * */
    private JdbcTemplate jdbcTemplate;

    /*
     * function untuk set datasource yang sudah di jalan kan oleh ioc database config pada jdbc
     * @Qualifier("dataSource")
     * DataSource
     * */
    @Autowired
    public void setDataSource(@Qualifier("dataSource") final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*
     * insert data product
     * Object[] data
     * */
    @Override
    public <T> T insert(Object[] data , Class<T> tClass) {
        log.debug("Prepare save to data base ");
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            String query = QueryConstant.INSERT_GROUP_PRODUCT;
            T queryExecute = jdbcTemplate.queryForObject(
                    query,
                    data,
                    new BeanPropertyRowMapper<>(tClass)
            );
            transactionManager.commit(status);
            return queryExecute;
        }catch (Exception e){
            log.error(e.getMessage());
        }
        transactionManager.rollback(status);
        throw new ResponseErrorException(
                HttpConstant.BADR_CODE,
                HttpConstant.MESSAGE_BDR,
                HttpStatus.BAD_REQUEST
        );
    }

    /*
     * get 1 data product
     * Object[] data
     * */
    @Override
    public <T> T get(Object[] data, Class<T> tClass) {
        log.debug("Prepare query to data base ");
        try {
            String query = QueryConstant.SELECT_GROUP_PRODUCT;
            T queryExecute = jdbcTemplate.queryForObject(
                    query,
                    data,
                    new BeanPropertyRowMapper<>(tClass)
            );
            return queryExecute;
        }catch (Exception e){
            log.error(e.getMessage());
        }
        throw new ResponseErrorException(
                HttpConstant.BADR_CODE,
                HttpConstant.MESSAGE_BDR,
                HttpStatus.BAD_REQUEST
        );
    }

    @Override
    public <T> List<T> getAll(Class<T> tClass) {
        log.debug("Prepare query to data base ");
        try {
            String query = QueryConstant.SELECT_GROUP_PRODUCT_ALL;
            List<T> queryExecute = (List<T>)jdbcTemplate.query(
                    query,
                    new BeanPropertyRowMapper<>(tClass)
            );
            return queryExecute;
        }catch (Exception e){
            log.error(e.getMessage());
        }
        throw new ResponseErrorException(
                HttpConstant.BADR_CODE,
                HttpConstant.MESSAGE_BDR,
                HttpStatus.BAD_REQUEST
        );
    }

    @Override
    public <T> T update(Object[] data) {
        return null;
    }

    @Override
    public <T> T delete(Object[] data) {
        return null;
    }
}
