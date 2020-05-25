package com.ybzbcq.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * 编程式事务
 */
@Component
@Scope("prototype") // 设置成原型，解决线程安全问题
public class TransactionUtils {

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    private TransactionStatus transactionStatus;

    // 开启事务
    public TransactionStatus begin(){
        transactionStatus = dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
        return transactionStatus;
    }
    // 提交事务
    public void commit(){
        dataSourceTransactionManager.commit(transactionStatus);
    }
    // 回滚事务
    public void rollback(){
        dataSourceTransactionManager.rollback(transactionStatus);
    }

}
