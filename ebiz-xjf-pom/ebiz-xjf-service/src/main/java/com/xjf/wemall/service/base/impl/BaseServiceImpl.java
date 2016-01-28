/*
 * Copyright (C), 2013-2015, 上海汽车集团股份有限公司
 * FileName: BaseServiceImpl.java
 * Author:   dongzejun
 * Date:     2015年5月4日 下午8:35:38
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.base.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.xjf.wemall.service.redis.AbstractRedisService;

/**
 * Sevice基类处理
 *
 * @author baowenzhou
 * @see com.saic.ebiz.cxj.service.IBaseService
 */
@Service
public class BaseServiceImpl extends AbstractRedisService implements ApplicationContextAware {
//public class BaseServiceImpl<P extends BasePo, Dal extends BaseDal<P>> 
	//extends AbstractRedisService 
	//implements BaseService<P, Dal>,
    //    ApplicationContextAware {

//    // Po实体类
//    private Class<P> PoClass;
//
//    // Dal实体类
//    private Class<Dal> DalClass;
//
//    // Dal实体对象
//    private Dal baseDal;

	// Spring的ApplicationContext
    private static ApplicationContext context;
    
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
    	BaseServiceImpl.context = ctx;
    }
    
    
//    /*
//     * (non-Javadoc)
//     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(
//     * org.springframework.context.ApplicationContext)
//     */
//    @Override
//    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
//        this.baseDal = ctx.getBean(DalClass);
//    }
//
//    /*
//     * (non-Javadoc)
//     * @see com.saic.ebiz.cxj.service.IBaseService#getDal()
//     */
//    public Dal getDal() {
//        return baseDal;
//    }
//
//    /**
//     * 构造函数
//     */
//    @SuppressWarnings("unchecked")
//    public BaseServiceImpl() {
//        Type genType = getClass().getGenericSuperclass();
//        if (genType instanceof ParameterizedType) {
//            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
//
//            if (params[0].getClass().isInstance(BasePo.class)) {
//                this.PoClass = (Class<P>) params[0];
//            }
//            if (params[1].getClass().isInstance(BaseDal.class)) {
//                this.DalClass = (Class<Dal>) params[1];
//            }
//        }
//    }
//    
//    /*
//     * (non-Javadoc)
//     * @see com.saic.ebiz.cxj.service.IBaseService#getLoginUserId()
//     */
//    @Override
//    public Long getLoginUserId() {
//        return 0L;
//    }
//
//    /*
//     * 单表添加操作
//     * @see com.saic.ebiz.cxj.service.IBaseService#create(org.ebiz.cxj.common.vo.BaseVo)
//     */
//    @Override
//    @Transactional(propagation=TransactionPropagation.PROPAGATION_REQUIRED)
//    public <V extends BaseVo>Long create(V vo) {
//
//        // 创建人ID
//        vo.setCreateBy(this.getLoginUserId());
//        // 创建时间
//        vo.setCreateTime(DateUtil.getCurrentDate());
//        // 更新者ID
//        vo.setUpdateBy(this.getLoginUserId());
//        // 更新时间
//        vo.setUpdateTime(DateUtil.getCurrentDate());
//
//        // 逻辑删除标记
//        vo.setIsDeleted(WemallConstants.IS_DELETED_FALSE);
//
//        // 单表添加操作
//        Long id = this.getDal().create(this.convert2Po(vo));
//        vo.setId(id);
//        return id;
//    }
//
//    /*
//     * VO中的主键(ID)有值的情况下update（更新非空字段），否则create<BR>
//     * @see com.saic.ebiz.cxj.service.IBaseService#createOrUpdate(org.ebiz.cxj.common.vo.BaseVo)
//     */
//    @Override
//    @Transactional(propagation=TransactionPropagation.PROPAGATION_REQUIRED)
//    public <V extends BaseVo> Long createOrUpdate(V vo) {
//        if (vo.getId() != null) {
//            // 存在主键(ID)的情况下，更新非空字段
//            this.dynamicUpdate(vo);
//        } else {
//            // 不存在主键(ID)的情况下，新增记录
//            vo.setId(this.create(vo));
//        }
//
//        return vo.getId();
//    }
//
//    /*
//     * 根据 @Id, 单表修改记录（更新全部字段）
//     * @see com.saic.ebiz.cxj.service.IBaseService#update(org.ebiz.cxj.common.vo.BaseVo)
//     */
//    @Override
//    @Transactional(propagation=TransactionPropagation.PROPAGATION_REQUIRED)
//    public <V extends BaseVo> Integer update(V vo) {
//          return this.dynamicUpdate(vo);
////        // 更新者ID
////        vo.setUpdateBy(this.getLoginUserId());
////        // 更新时间
////        vo.setUpdateTime(DateUtil.getCurrentDate());
////
////        // 根据 @Id, 单表修改记录（更新全部字段）
////        return this.getDal().update(this.convert2Po(vo));
//    }
//
//    /*
//     * 根据@ID, 单表修改记录（更新全部字段）
//     * @see com.saic.ebiz.cxj.service.IBaseService#updateWithNull(org.ebiz.cxj.common.vo.BaseVo)
//     */
//    @Override
//    @Transactional(propagation=TransactionPropagation.PROPAGATION_REQUIRED)
//    public <V extends BaseVo> Integer updateWithNull(V vo) {
//        // 更新者ID
//        vo.setUpdateBy(this.getLoginUserId());
//        // 更新时间
//        vo.setUpdateTime(DateUtil.getCurrentDate());
//
//        // 根据 @Id, 单表修改记录（更新全部字段）
//        return this.getDal().updateWithNull(this.convert2Po(vo));
//    }
//
//    /*
//     * 根据 @Id, 单表修改记录（更新实体对象中的非空字段）
//     * @see com.saic.ebiz.cxj.service.IBaseService#dynamicUpdate(org.ebiz.cxj.common.vo.BaseVo)
//     */
//    @Override
//    @Transactional(propagation=TransactionPropagation.PROPAGATION_REQUIRED)
//    public <V extends BaseVo> Integer dynamicUpdate(V vo) {
//        // 更新者ID
//        vo.setUpdateBy(this.getLoginUserId());
//        // 更新时间
//        vo.setUpdateTime(DateUtil.getCurrentDate());
//
//        // 根据 @Id, 单表修改记录（更新实体对象中的非空字段）
//        return this.getDal().dynamicUpdate(this.convert2Po(vo));
//    }
//
//    /*
//     * 根据 @ParentId, 单表修改记录（更新实体对象中的非空字段）
//     * @see com.saic.ebiz.cxj.service.IBaseService#dynamicUpdateByParentId(org.ebiz.cxj.common.vo.BaseVo)
//     */
//    @Override
//    @Transactional(propagation=TransactionPropagation.PROPAGATION_REQUIRED)
//    public <V extends BaseVo> Integer dynamicUpdateByParentId(V vo) {
//        // 更新者ID
//        vo.setUpdateBy(this.getLoginUserId());
//        // 更新时间
//        vo.setUpdateTime(DateUtil.getCurrentDate());
//
//        // 根据 @ParentId, 单表修改记录（更新实体对象中的非空字段）
//        return this.getDal().dynamicUpdateByParentId(this.convert2Po(vo));
//    }
//
//    /*
//     * 根据 @Id 单表物理删除操作
//     * @see com.saic.ebiz.cxj.service.IBaseService#removeById(java.lang.Long)
//     */
//    @Override
//    @Transactional(propagation=TransactionPropagation.PROPAGATION_REQUIRED)
//    public Integer removeById(Long id) {
//
//        // 根据 @Id 单表物理删除操作
//        return this.getDal().removeById(id);
//    }
//
//    /*
//     * 根据 @Id 单表逻辑删除操作
//     * @see com.saic.ebiz.cxj.service.IBaseService#deleteById(java.lang.Long)
//     */
//    @Override
//    @Transactional(propagation=TransactionPropagation.PROPAGATION_REQUIRED)
//    public Integer deleteById(Long id) {
//        P po = this.makePoWithId(id);
//
//        // 更新者ID
//        po.setUpdateBy(this.getLoginUserId());
//        // 更新时间
//        po.setUpdateTime(DateUtil.getCurrentDate());
//
//        // 逻辑删除标记
//        po.setIsDeleted(WemallConstants.IS_DELETED_TRUE);
//
//        // 根据包含主键(ID)的PO实体对象, 单表修改记录（更新实体对象中的非空字段）
//        return this.getDal().dynamicUpdate(po);
//    }
//
//    /*
//     * 根据 @ParentId 单表物理删除操作
//     * @see com.saic.ebiz.cxj.service.IBaseService#removeByParentId(java.lang.Long)
//     */
//    @Override
//    @Transactional(propagation=TransactionPropagation.PROPAGATION_REQUIRED)
//    public Integer removeByParentId(Long parentId) {
//
//        // 根据 @ParentId 单表物理删除操作
//        return this.getDal().removeByParentId(parentId);
//    }
//
//    /*
//     * 根据 @ParentId 单表物理删除操作
//     * @see com.saic.ebiz.cxj.service.IBaseService#removeByParentId(org.ebiz.cxj.common.vo.BaseVo)
//     */
//    @Override
//    @Transactional(propagation=TransactionPropagation.PROPAGATION_REQUIRED)
//    public <V extends BaseVo> int removeByParentId(V v) {
//        // 根据 @ParentId 单表物理删除操作
//        return this.getDal().removeByParentId(this.convert2Po(v));
//    }
//
//    /*
//     * 根据 @ParentId 单表逻辑删除操作
//     * @see com.saic.ebiz.cxj.service.IBaseService#deleteByParentId(java.lang.Long)
//     */
//    @Override
//    @Transactional(propagation=TransactionPropagation.PROPAGATION_REQUIRED)
//    public Integer deleteByParentId(Long parentId) {
//
//        P po = this.makePoWithParentId(parentId);
//
//        // 更新者ID
//        po.setUpdateBy(this.getLoginUserId());
//        // 更新时间
//        po.setUpdateTime(DateUtil.getCurrentDate());
//
//        // 逻辑删除标记
//        po.setIsDeleted(WemallConstants.IS_DELETED_TRUE);
//
//        // 根据 @ParentId 单表逻辑删除操作
//        return this.getDal().dynamicUpdateByParentId(po);
//    }
//
//    /*
//     * 根据 @RemoveCondition 单表删除操作
//     * @see com.saic.ebiz.cxj.service.IBaseService#removeByRemoveCondition(org.ebiz.cxj.common.vo.BaseVo)
//     */
//    @Override
//    @Transactional(propagation=TransactionPropagation.PROPAGATION_REQUIRED)
//    public <V extends BaseVo> Integer removeByRemoveCondition(V vo) {
//
//        // 根据 @RemoveCondition 单表删除操作
//        return this.getDal().removeByRemoveCondition(this.convert2Po(vo));
//    }
//
//    /*
//     * 根据id查找
//     * @see com.saic.ebiz.cxj.service.IBaseService#findById(java.lang.Long, java.lang.Class)
//     */
//    @Override
//    public <V extends BaseVo> V findById(Long id, Class<V> requiredType) {
//
//        // 根据id查找
//        return this.getDal().findById(id, requiredType);
//    }
//
//    /*
//     * 根据id查找
//     * @see com.saic.ebiz.cxj.service.IBaseService#findById(java.lang.Long, java.lang.String, java.lang.Class)
//     */
//    @Override
//    public <V extends BaseVo> V findById(Long id, String isDeleted, Class<V> requiredType) {
//
//        // 根据id查找
//        return this.getDal().findById(id, isDeleted, requiredType);
//    }
//
//    /*
//     * (non-Javadoc)
//     * @see com.saic.ebiz.cxj.service.IBaseService#findByCondition(org.ebiz.cxj.common.vo.BaseVo, java.lang.Class)
//     */
//    @Override
//    public <V extends BaseVo> V findByCondition(V vo, Class<V> requiredType) {
//
//        // 根据实体中的非空条件查找
//        return this.getDal().findByCondition(this.convert2Po(vo), requiredType);
//    }
//
//    /*
//     * 根据实体中的非空条件查找
//     * @see com.saic.ebiz.cxj.service.IBaseService#findByCondition(org.ebiz.cxj.common.vo.BaseVo)
//     */
//    @SuppressWarnings("unchecked")
//    @Override
//    public <V extends BaseVo> V findByCondition(V vo) {
//
//        // 根据实体中的非空条件查找
//        return (V)this.getDal().findByCondition(this.convert2Po(vo), vo.getClass());
//    }
//
//    /*
//     * 根据实体中的非空条件查找
//     * @see com.saic.ebiz.cxj.service.IBaseService#queryForList(org.ebiz.cxj.common.vo.BaseVo)
//     */
//    @SuppressWarnings("unchecked")
//    @Override
//    public <V extends BaseVo> List<V> queryForList(V vo) {
//
//        // 根据实体中的非空条件查找
//        return (List<V>) this.getDal().queryForList(this.convert2Po(vo), vo.getClass());
//    }
//
//    /*
//     * (non-Javadoc)
//     * @see com.saic.ebiz.cxj.service.IBaseService#queryForList(org.ebiz.cxj.common.vo.BaseVo, java.lang.Class,
//     * com.ibm.framework.dal.pagination.Pagination)
//     */
//    @Override
//    public <V extends BaseVo> PaginationResult<List<V>> queryForList(V vo, Class<V> requiredType, Pagination pagination) {
//
//        // 根据实体中的非空条件查找
//        return this.getDal().queryForList(this.convert2Po(vo), requiredType, pagination);
//    }
//
//    /*
//     * (non-Javadoc)
//     * @see com.saic.ebiz.cxj.service.IBaseService#queryByParentId(java.lang.Long, java.lang.String, java.lang.Class)
//     */
//    @Override
//    public <V extends BaseVo> List<V> queryByParentId(Long parentId, Class<V> requiredType) {
//        // 根据 @ParentId,isDeleted 查找
//        return this.getDal().queryByParentId(parentId, requiredType);
//    }
//
//    /*
//     * (non-Javadoc)
//     * @see com.saic.ebiz.cxj.service.IBaseService#queryByParentId(java.lang.Long, java.lang.String, java.lang.Class)
//     */
//    @Override
//    public <V extends BaseVo> List<V> queryByParentId(Long parentId, String isDeleted, Class<V> requiredType) {
//        // 根据 @ParentId,isDeleted 查找
//        return this.getDal().queryByParentId(parentId, isDeleted, requiredType);
//    }
//
//    /*
//     * Vo对象转换成Po对象
//     * @param vo Vo对象
//     * @return Po对象
//     */
//    private <V extends BaseVo> P convert2Po(V vo) {
//        try {
//            P po = PoClass.newInstance();
//            BeanCopyUtil.copyProps(vo, po);
//            return po;
//        } catch (InstantiationException e) {
//            throw new WemallException("", e);
//        } catch (IllegalAccessException e) {
//            throw new WemallException("", e);
//        }
//    }
//
//    /**
//     * 根据当前泛型T和带有 @Id 声明的PO属性参数做成默认的PO对象
//     *
//     * @param parentId 带有 @Id 声明的PO属性参数
//     * @return PO对象
//     * @author dongzejun
//     */
//    protected P makePoWithId(Long id) {
//        // PO实体对象
//
//        Method[] methods = PoClass.getMethods();
//        for (Method method : methods) {
//            if (method.isAnnotationPresent(Id.class) && method.isAnnotationPresent(Column.class)) {
//                Method writeMethod = BeanUtils.findPropertyForMethod(method).getWriteMethod();
//                writeMethod.setAccessible(true);
//
//                try {
//                    P po = PoClass.newInstance();
//                    writeMethod.invoke(po, id);
//                    return po;
//                } catch (Exception e) {
//                    new WemallException("", "System exception!");
//                }
//            }
//        }
//
//        throw new WemallException("", "Entity define error!");
//    }
//
//    /**
//     * 根据当前泛型T和带有 @ParentId 声明的PO属性参数做成默认的PO对象
//     *
//     * @param parentId  带有 @ParentId 声明的PO属性参数
//     * @return PO对象
//     * @author dongzejun
//     */
//    protected P makePoWithParentId(Long parentId) {
//        // PO实体对象
//
//        Method[] methods = PoClass.getMethods();
//        for (Method method : methods) {
//            if (method.isAnnotationPresent(ParentId.class) && method.isAnnotationPresent(Column.class)) {
//                Method writeMethod = BeanUtils.findPropertyForMethod(method).getWriteMethod();
//                writeMethod.setAccessible(true);
//
//                try {
//                    P po = PoClass.newInstance();
//                    writeMethod.invoke(po, parentId);
//                    return po;
//                } catch (Exception e) {
//                    new WemallException("", "System exception!");
//                }
//            }
//        }
//
//        throw new WemallException("", "Entity define error!");
//    }

}
