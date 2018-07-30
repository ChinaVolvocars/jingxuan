package com.jiameng.jingxuan.support;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MybatisDaoSupport extends SqlSessionDaoSupport {
	@Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
	
	public void insert(String prefix, String key, Object object) {
        getSqlSession().insert(prefix + key, object);
    }
	
	public void update(String prefix, String key, Object object) {
        getSqlSession().update(prefix + key, object);
    }
	
	public void delete(String prefix, String key, Serializable id) {
        getSqlSession().delete(prefix + key, id);
    }
	
	public void delete(String key, Serializable id) {
        getSqlSession().delete(key, id);
    }
	
	public void delete(String prefix, String key, Object object) {
        getSqlSession().delete(prefix + key, object);
    }
	
	public <T> T get(String prefix, String key, Object params) {
        return getSqlSession().selectOne(prefix + key, params);
    }
	
	public <T> List<T> getList(String prefix, String key) {
        return getSqlSession().selectList(prefix + key);
    }
	
	public <T> List<T> getList(String prefix, String key, Object params) {
        return getSqlSession().selectList(prefix + key, params);
    }
	
	public Integer count(String prefix, String key, Object params) {
        return getSqlSession().selectOne(prefix + key, params);
    }
	
	public Object[] page(String prefix, String pageKey, String countKey, Object params, int offset, int limit) {
        return new Object[]{
            getSqlSession().selectList(prefix + pageKey, params, new RowBounds(offset, limit)),
            getSqlSession().selectOne(prefix + countKey, params)
        };
    }
	
	public boolean executeSql(String sql) {
        try {
            return getSqlSession().getConnection().prepareStatement(sql).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public List<Map<String, String>> querySql(String sql) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        try {
            ResultSet rs = getSqlSession().getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery();
            try {
                ResultSetMetaData rsm = rs.getMetaData(); 
                int columnCount = rsm.getColumnCount(); 
                String[] columnNames = new String[columnCount];                
                for (int i = 0; i < columnCount; i++) {
                	columnNames[i] = rsm.getColumnName(i+1);
                }
                rs.beforeFirst();
                while (rs.next()) {
                    Map<String, String> map =  new HashMap<String, String>();
                    for(String columnName : columnNames) {
                        map.put(columnName, rs.getString(columnName));
                    }
                    list.add(map);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}