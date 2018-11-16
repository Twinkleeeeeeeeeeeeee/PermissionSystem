package com.asiainfo.permission.base;

import java.util.List;

/**
 * @ClassName BaseService
 * @Description TODO 业务逻辑基础类
 * @Author LIUYH
 * @DateTime 2018/11/2 16:19
 **/
public interface BaseService <T>{

    /**
     * 注入mapper
     */
    void setBaseMapper();


    /**
     * 根据关键字模糊搜索后的结果
     * @param data 关键字
     * @return 查找后的信息
     */

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
     * @param data
     * @return
     */
    int delete(String id);

    /**
     * 根据id得到相关的信息
     * @param id
     * @return
     */
    T getById(String id);

    List<T> selectAll();


}
