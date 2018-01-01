package com.wsz.rcpsum.server.model.base;

import java.io.Serializable;
import java.util.List;

/**
 * 数据操作层基础接口，供dao层接口继承，如有需要请调用者在适当时候手动关闭session。
 * 
 * @author wsz
 * 
 */
public interface IBaseDao {

	/**
	 * 根据任意类型的id值获取数据对象信息
	 * 
	 * @param obj
	 *            对象
	 * @param id
	 * @return object
	 */
	Object getObjById(Class<?> obj, Object id);

	/**
	 * 根据条件查询返回多个数据对象信息，预编译方式实现
	 * 
	 * @param hql
	 *            hql查询语句
	 * @param values
	 *            条件数组
	 * @return list list<SheetVO>
	 */
	List findList(String hql, Object... values);

	/**
	 * 基于id数组的查询操作，预编译时hql语句id取名 :ids 如：form User where id in :ids
	 * 
	 * @param hql
	 *            hql语句
	 * @param ids
	 *            id集合 可为空
	 * @return list 为空返回null
	 */
	List findListByIds(String hql, Object... ids);

	/**
	 * 根据sql语句，条件查询。offset和length都不为空时启用分页功能
	 * 
	 * @param sql
	 * @param offset
	 *            初始位置
	 * @param length
	 *            返回数据条数
	 * @param values
	 *            查询条件
	 * @return
	 */
	List findListForPageBySql(String sql, Integer offset, Integer length, Object... values);

	/**
	 * 根据sql语句，条件查询
	 * 
	 * @param sql
	 * @param values
	 *            查询条件
	 * @return
	 */
	List findListBySql(String sql, Object... values);

	/**
	 * 新增数据
	 * 
	 * @param obj
	 * @return OID主键值
	 */
	Serializable save(Object obj);

	/**
	 * 修改数据
	 * 
	 * @param obj
	 */
	void update(Object obj);

	/**
	 * 新增或修改数据
	 * 
	 * @param obj
	 */
	void saveOrUpdate(Object obj);

	/**
	 * 删除数据
	 * 
	 * @param obj
	 * @return true-成功,false-失败
	 */
	void delete(Object obj);

	/**
	 * 基于id数组的更新或删除操作，预编译时hql语句id取名 :ids 如：delete form User where id in :ids
	 * 
	 * @param hql
	 *            hql语句
	 * @param ids
	 *            id集合 可为空
	 * @param parms
	 *            hql中的其他预编译变量值
	 */
	void executeByIds(String hql, Object[] ids, Object... parms);

	/**
	 * 预编译方式执行任意的更新或删除操作。
	 * 
	 * @param hql
	 *            hql语句
	 * @param parms
	 *            参数
	 */
	void executeByParms(String hql, Object... parms);
}
