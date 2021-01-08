package com.example.demo.design.factory;


/**
 *  抽象工厂模式
 *  提供一个创建一系列相关或相互依赖对象的接口
 *
 */
public class AbstractFactory {

    public static void main(String[] args) {
        IDatabaseUtils mysqlDatabaseUtils = new MysqlDatabaseUtils();
        mysqlDatabaseUtils.getConnection().connect();
        mysqlDatabaseUtils.getCommand().command();

        IDatabaseUtils oracleDatabaseUtils = new OracleDatabaseUtils();
        oracleDatabaseUtils.getConnection().connect();
        oracleDatabaseUtils.getCommand().command();
    }

}

// 接口
interface IConnection {
    void connect();
}

interface ICommand{
    void command();
}

interface IDatabaseUtils{
    IConnection getConnection();
    ICommand getCommand();
}


// mysql 实现
class MysqlConnection implements IConnection{
    @Override
    public void connect() {
        System.out.println(" mysql connected .. ");
    }
}

class MysqlCommand implements ICommand{
    @Override
    public void command() {
        System.out.println(" mysql command .. ");
    }
}

class MysqlDatabaseUtils implements IDatabaseUtils{
    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}

// oracle 实现

class OracleConnection implements IConnection{
    @Override
    public void connect() {
        System.out.println(" oracle connected ..");
    }
}

class OracleCommand implements ICommand{

    @Override
    public void command() {
        System.out.println(" oracle command .. ");
    }
}

class OracleDatabaseUtils implements IDatabaseUtils{

    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}





















