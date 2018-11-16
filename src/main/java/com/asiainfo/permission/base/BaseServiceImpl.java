package com.asiainfo.permission.base;

import java.util.List;

/**
 * @ClassName BaseServiceImpl
 * @Description TODO
 * @Author LIUYH
 * @DateTime 2018/11/2 16:21
 **/
public abstract class BaseServiceImpl <T> implements BaseService<T>{

    private BaseMapper<T> baseMapper;

    public void setBaseMapper(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public int count() {
        return baseMapper.count();
    }

    @Override
    public int countByKeyWord(String data) {
        return baseMapper.countByKeyWord(data);
    }

    @Override
    public int insert(T entity) {
        return baseMapper.insert(entity);
    }

    @Override
    public int update(T entity) {
        return baseMapper.update(entity);
    }

    @Override
    public int delete(String id) {
        return baseMapper.delete(id);
    }

    @Override
    public T getById(String id) {
        return baseMapper.getById(id);
    }

    @Override
    public List<T> selectAll() {
        return baseMapper.selectAll();
    }
}
