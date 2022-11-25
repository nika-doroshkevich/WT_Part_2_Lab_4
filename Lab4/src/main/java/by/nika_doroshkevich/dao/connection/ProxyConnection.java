package by.nika_doroshkevich.dao.connection;

import by.nika_doroshkevich.exeptions.ConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.DatabaseMetaData;
import java.sql.SQLWarning;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.NClob;
import java.sql.Savepoint;
import java.sql.Array;
import java.sql.SQLClientInfoException;
import java.sql.Struct;
import java.sql.SQLXML;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ProxyConnection implements Connection {

    private final Connection con;

    ProxyConnection(Connection con) {
        this.con = con;
    }

    @Override
    public Statement createStatement() throws ConnectionException {
        try {
            return con.createStatement();
        } catch (SQLException e) {
            throw new ConnectionException("Error in createStatement", e);
        }
    }

/*
    void closeConnection() throws ConnectionException {
        try {
            con.close();
        } catch (SQLException e) {
            throw new ConnectionException("Error in closeConnection", e);
        }
    }
*/

    @Override
    public PreparedStatement prepareStatement(String sql) throws ConnectionException {
        try {
            return con.prepareStatement(sql);
        } catch (SQLException e) {
            throw new ConnectionException("Error in prepareStatement", e);
        }
    }

    @Override
    public CallableStatement prepareCall(String sql) throws ConnectionException {
        try {
            return con.prepareCall(sql);
        } catch (SQLException e) {
            throw new ConnectionException("Error in prepareCall", e);
        }
    }

    @Override
    public String nativeSQL(String sql) throws ConnectionException {
        try {
            return con.nativeSQL(sql);
        } catch (SQLException e) {
            throw new ConnectionException("Error in nativeSQL", e);
        }
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws ConnectionException {
        try {
            con.setAutoCommit(autoCommit);
        } catch (SQLException e) {
            throw new ConnectionException("Error in setAutoCommit", e);
        }
    }

    @Override
    public boolean getAutoCommit() throws ConnectionException {
        try {
            return con.getAutoCommit();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getAutoCommit", e);
        }
    }

    @Override
    public void commit() throws ConnectionException {
        try {
            con.commit();
        } catch (SQLException e) {
            throw new ConnectionException("Error in commit", e);
        }
    }

    @Override
    public void rollback() throws ConnectionException {
        try {
            con.rollback();
        } catch (SQLException e) {
            throw new ConnectionException("Error in rollback", e);
        }
    }

    @Override
    public void close() throws ConnectionException {
        try {
            ConnectionPool.getInstance().releaseConnection(this);
        } catch (SQLException e) {
            throw new ConnectionException("Error in close", e);
        }
    }

    @Override
    public boolean isClosed() throws ConnectionException {
        try {
            return con.isClosed();
        } catch (SQLException e) {
            throw new ConnectionException("Error in isClosed", e);
        }
    }

    @Override
    public DatabaseMetaData getMetaData() throws ConnectionException {
        try {
            return con.getMetaData();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getMetaData", e);
        }
    }

    @Override
    public void setReadOnly(boolean readOnly) throws ConnectionException {
        try {
            con.setReadOnly(readOnly);
        } catch (SQLException e) {
            throw new ConnectionException("Error in setReadOnly", e);
        }
    }

    @Override
    public boolean isReadOnly() throws ConnectionException {
        try {
            return con.isReadOnly();
        } catch (SQLException e) {
            throw new ConnectionException("Error in isReadOnly", e);
        }
    }

    @Override
    public void setCatalog(String catalog) throws ConnectionException {
        try {
            con.setCatalog(catalog);
        } catch (SQLException e) {
            throw new ConnectionException("Error in setCatalog", e);
        }
    }

    @Override
    public String getCatalog() throws ConnectionException {
        try {
            return con.getCatalog();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getCatalog", e);
        }
    }

    @Override
    public void setTransactionIsolation(int level) throws ConnectionException {
        try {
            con.setTransactionIsolation(level);
        } catch (SQLException e) {
            throw new ConnectionException("Error in setTransactionIsolation", e);
        }
    }

    @Override
    public int getTransactionIsolation() throws ConnectionException {
        try {
            return con.getTransactionIsolation();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getTransactionIsolation", e);
        }
    }

    @Override
    public SQLWarning getWarnings() throws ConnectionException {
        try {
            return con.getWarnings();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getWarnings", e);
        }
    }

    @Override
    public void clearWarnings() throws ConnectionException {
        try {
            con.clearWarnings();
        } catch (SQLException e) {
            throw new ConnectionException("Error in clearWarnings", e);
        }
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency)
            throws ConnectionException {
        try {
            return con.createStatement(resultSetType, resultSetConcurrency);
        } catch (SQLException e) {
            throw new ConnectionException("Error in createStatement", e);
        }
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
            throws ConnectionException {
        try {
            return con.prepareStatement(sql, resultSetType, resultSetConcurrency);
        } catch (SQLException e) {
            throw new ConnectionException("Error in prepareStatement", e);
        }
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
            throws ConnectionException {
        try {
            return con.prepareCall(sql, resultSetType, resultSetConcurrency);
        } catch (SQLException e) {
            throw new ConnectionException("Error in prepareCall", e);
        }
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws ConnectionException {
        try {
            return con.getTypeMap();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getTypeMap", e);
        }
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws ConnectionException {
        try {
            con.setTypeMap(map);
        } catch (SQLException e) {
            throw new ConnectionException("Error in setTypeMap", e);
        }
    }

    @Override
    public void setHoldability(int holdability) throws ConnectionException {
        try {
            con.setHoldability(holdability);
        } catch (SQLException e) {
            throw new ConnectionException("Error in setHoldability", e);
        }
    }

    @Override
    public int getHoldability() throws ConnectionException {
        try {
            return con.getHoldability();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getHoldability", e);
        }
    }

    @Override
    public Savepoint setSavepoint() throws ConnectionException {
        try {
            return con.setSavepoint();
        } catch (SQLException e) {
            throw new ConnectionException("Error in setSavepoint", e);
        }
    }

    @Override
    public Savepoint setSavepoint(String name) throws ConnectionException {
        try {
            return con.setSavepoint(name);
        } catch (SQLException e) {
            throw new ConnectionException("Error in setSavepoint", e);
        }
    }

    @Override
    public void rollback(Savepoint savepoint) throws ConnectionException {
        try {
            con.rollback(savepoint);
        } catch (SQLException e) {
            throw new ConnectionException("Error in rollback", e);
        }
    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws ConnectionException {
        try {
            con.releaseSavepoint(savepoint);
        } catch (SQLException e) {
            throw new ConnectionException("Error in releaseSavepoint", e);
        }
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
            throws ConnectionException {
        try {
            return con.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
        } catch (SQLException e) {
            throw new ConnectionException("Error in createStatement", e);
        }
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
            throws ConnectionException {
        try {
            return con.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
        } catch (SQLException e) {
            throw new ConnectionException("Error in prepareStatement", e);
        }
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
            throws ConnectionException {
        try {
            return con.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
        } catch (SQLException e) {
            throw new ConnectionException("Error in prepareCall", e);
        }
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws ConnectionException {
        try {
            return con.prepareStatement(sql, autoGeneratedKeys);
        } catch (SQLException e) {
            throw new ConnectionException("Error in prepareStatement", e);
        }
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws ConnectionException {
        try {
            return con.prepareStatement(sql, columnIndexes);
        } catch (SQLException e) {
            throw new ConnectionException("Error in prepareStatement", e);
        }
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws ConnectionException {
        try {
            return con.prepareStatement(sql, columnNames);
        } catch (SQLException e) {
            throw new ConnectionException("Error in prepareStatement", e);
        }
    }

    @Override
    public Clob createClob() throws ConnectionException {
        try {
            return con.createClob();
        } catch (SQLException e) {
            throw new ConnectionException("Error in createClob", e);
        }
    }

    @Override
    public Blob createBlob() throws ConnectionException {
        try {
            return con.createBlob();
        } catch (SQLException e) {
            throw new ConnectionException("Error in createBlob", e);
        }
    }

    @Override
    public NClob createNClob() throws ConnectionException {
        try {
            return con.createNClob();
        } catch (SQLException e) {
            throw new ConnectionException("Error in createNClob", e);
        }
    }

    @Override
    public SQLXML createSQLXML() throws ConnectionException {
        try {
            return con.createSQLXML();
        } catch (SQLException e) {
            throw new ConnectionException("Error in createSQLXML", e);
        }
    }

    @Override
    public boolean isValid(int timeout) throws ConnectionException {
        try {
            return con.isValid(timeout);
        } catch (SQLException e) {
            throw new ConnectionException("Error in isValid", e);
        }
    }

    @Override
    public void setClientInfo(String name, String value) {
        try {
            con.setClientInfo(name, value);
        } catch (SQLClientInfoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setClientInfo(Properties properties) {
        try {
            con.setClientInfo(properties);
        } catch (SQLClientInfoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getClientInfo(String name) throws ConnectionException {
        try {
            return con.getClientInfo(name);
        } catch (SQLException e) {
            throw new ConnectionException("Error in getClientInfo", e);
        }
    }

    @Override
    public Properties getClientInfo() throws ConnectionException {
        try {
            return con.getClientInfo();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getClientInfo", e);
        }
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws ConnectionException {
        try {
            return con.createArrayOf(typeName, elements);
        } catch (SQLException e) {
            throw new ConnectionException("Error in createArrayOf", e);
        }
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws ConnectionException {
        try {
            return con.createStruct(typeName, attributes);
        } catch (SQLException e) {
            throw new ConnectionException("Error in createStruct", e);
        }
    }

    @Override
    public void setSchema(String schema) throws ConnectionException {
        try {
            con.setSchema(schema);
        } catch (SQLException e) {
            throw new ConnectionException("Error in setSchema", e);
        }
    }

    @Override
    public String getSchema() throws ConnectionException {
        try {
            return con.getSchema();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getSchema", e);
        }
    }

    @Override
    public void abort(Executor executor) throws ConnectionException {
        try {
            con.abort(executor);
        } catch (SQLException e) {
            throw new ConnectionException("Error in abort", e);
        }
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws ConnectionException {
        try {
            con.setNetworkTimeout(executor, milliseconds);
        } catch (SQLException e) {
            throw new ConnectionException("Error in setNetworkTimeout", e);
        }
    }

    @Override
    public int getNetworkTimeout() throws ConnectionException {
        try {
            return con.getNetworkTimeout();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getNetworkTimeout", e);
        }
    }


    @Override
    public <T> T unwrap(Class<T> iface) throws ConnectionException {
        try {
            return con.unwrap(iface);
        } catch (SQLException e) {
            throw new ConnectionException("Error in unwrap", e);
        }
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws ConnectionException {
        try {
            return con.isWrapperFor(iface);
        } catch (SQLException e) {
            throw new ConnectionException("Error in isWrapperFor", e);
        }
    }
}
