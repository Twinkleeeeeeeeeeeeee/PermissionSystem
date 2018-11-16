package com.asiainfo.permission.base;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName BaseMapper
 * @Description TODO 数据库操作公共持久化操作类
 * @Author LIUYH
 * @DateTime 2018/11/2 16:03
 **/
public interface BaseMapper <T>{

    /**
     * 查询所有实体类的信息
     * @return
     */
    List<T> selectAll();

    /**
     * 根据关键字模糊搜索后的结果
     * @param data
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<T> selectByKeyWord(String data, Integer pageIndex, Integer pageSize);

    /**
     * 分页查询相关信息
     * @param pageIndex  本页开始的编号
     * @param pageSize 查询多少
     * @return 结果
     */
    List<T> selectByPage(Integer pageIndex, Integer pageSize);

    /**
     * 所有结果的数量统计
     * @return 结果
     */
    int count();

    /**
     * 根据关键字模糊搜索后的结果统计
     * @param data 关键字
     * @return 结果
     */
    int countByKeyWord(String data);

    /**
     * 添加相关信息
     * @param entity 实体类信息
     * @return 是否成功
     */
    int insert(T entity);

    /**
     * 更新相关信息
     * @param entity 实体类信息
     * @return 是否成功
     */
    int update(T entity);

    /**
     * 删除相关信息
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 根据id得到相关的信息
     * @param id
     * @return
     */
    T getById(String id);



}
