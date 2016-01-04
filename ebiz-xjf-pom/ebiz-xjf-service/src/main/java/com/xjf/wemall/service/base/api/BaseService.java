/*
 * Copyright (C), 2013-2015, 上海汽车集团股份有限公司
 * FileName: BaseService.java
 * Author:   baowenzhou
 * Date:     2015年10月08日 上午8:34:23
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.base.api;

/**
 * Sevice基类接口
 *
 * @author baowenzhou
 */
public interface BaseService {
//public interface BaseService<P extends BasePo, Dal extends BaseDal<P>> {
//
//    /**
//     * 获取当前的Dal对象
//     *
//     * @return
//     * @author dongzejun
//     */
//    BaseDal<P> getDal();
//
//    /**
//     * 获取当前Login用户的ID
//     *
//     * @return 当前Login用户的ID
//     * @author dongzejun 2015年5月21日
//     */
//    Long getLoginUserId();
//
//    /**
//     * 根据VO实体对象，单表添加操作<BR>
//     * 注意: VO属性必须与PO属性相同
//     *
//     * @param vo VO实体对象
//     * @return 主键ID
//     * @author dongzejun
//     */
//    <V extends BaseVo> Long create(V vo);
//
//    /**
//     * VO中的主键(ID)有值的情况下update（更新非空字段），否则create<BR>
//     * 注意: VO属性必须与PO属性相同
//     * 
//     * @param vo VO实体对象
//     * @return 主键ID
//     * @author dongzejun
//     */
//    <V extends BaseVo> Long createOrUpdate(V vo);
//
//    /**
//     * 根据@ID, 单表修改记录（更新全部字段）<BR>
//     * 注意: VO属性必须与PO属性相同
//     * 
//     * @param vo 包含主键(ID)的VO实体对象
//     * @return 成功更新的记录条数
//     * @author dongzejun
//     */
//    <V extends BaseVo> Integer update(V vo);
//
//    /**
//     * 根据@ID, 单表修改记录（更新全部字段）<BR>
//     * 注意: VO属性必须与PO属性相同
//     * 
//     * @param vo 包含主键(ID)的VO实体对象
//     * @return 成功更新的记录条数
//     * @author dongzejun
//     */
//    <V extends BaseVo> Integer updateWithNull(V vo);
//
//    /**
//     * 根据 @Id, 单表修改记录（更新实体对象中的非空字段）<BR>
//     * 注意: VO属性必须与PO属性相同
//     *
//     * @param vo VO实体对象
//     * @return 成功更新的记录条数
//     * @author dongzejun
//     */
//    <V extends BaseVo> Integer dynamicUpdate(V vo);
//
//    /**
//     * 根据 @ParentId, 单表修改记录（更新实体对象中的非空字段）<BR>
//     * 注意: VO属性必须与PO属性相同
//     *
//     * @param vo VO实体对象
//     * @return 成功更新的记录条数
//     */
//    <V extends BaseVo> Integer dynamicUpdateByParentId(V vo);
//
//    /**
//     * 根据 @Id 单表物理删除操作
//     *
//     * @param id 带有 @Id 声明的PO属性参数
//     * @return 成功删除的记录数
//     * @author dongzejun
//     */
//    Integer removeById(Long id);
//
//    /**
//     * 根据 @Id 单表逻辑删除操作
//     *
//     * @param id 带有 @Id 声明的PO属性参数
//     * @return 成功删除的记录数
//     * @author dongzejun
//     */
//    Integer deleteById(Long id);
//
//    /**
//     * 根据 @ParentId 单表物理删除操作
//     *
//     * @param parentId 带有 @ParentId 声明的PO属性参数
//     * @return 成功物理删除的记录数
//     * @author dongzejun
//     */
//    Integer removeByParentId(Long parentId);
//
//    /**
//     * 根据 @ParentId 单表物理删除操作
//     *
//     * @param t 实体PO对象
//     * @return 成功物理删除的记录数
//     */
//    <V extends BaseVo> int removeByParentId(V v);
//
//    /**
//     * 根据 @ParentId 单表逻辑删除操作
//     *
//     * @param parentId 带有 @ParentId 声明的PO属性参数
//     * @return 成功逻辑删除的记录数
//     * @author dongzejun
//     */
//    Integer deleteByParentId(Long parentId);
//
//    /**
//     * 根据 @RemoveCondition 单表删除操作<BR>
//     * 注意: VO属性必须与PO属性相同
//     *
//     * @param vo VO实体对象
//     * @return 成功删除的记录数
//     * @author dongzejun
//     */
//    <V extends BaseVo> Integer removeByRemoveCondition(V vo);
//
//    /**
//     * 根据id查找
//     *
//     * @param id ID
//     * @param requiredType 返回对象类型
//     * @return requiredType对象
//     * @author dongzejun
//     */
//    <V extends BaseVo> V findById(Long id, Class<V> requiredType);
//
//    /**
//     * 根据id查找
//     *
//     * @param id ID
//     * @param isDeleted 逻辑删除标志
//     * @param requiredType 返回对象类型
//     * @return requiredType对象
//     * @author dongzejun
//     */
//    <V extends BaseVo> V findById(Long id, String isDeleted, Class<V> requiredType);
//
//    /**
//     * 根据实体中的非空条件查找<BR>
//     * 注意: VO属性必须与PO属性相同
//     *
//     * @param vo VO实体对象
//     * @param requiredType 查找结果对象类型
//     * @return 查找结果的首条记录
//     * @author dongzejun
//     */
//    <V extends BaseVo> V findByCondition(V vo, Class<V> requiredType);
//
//    /**
//     * 根据实体中的非空条件查找<BR>
//     * 注意: VO属性必须与PO属性相同
//     *
//     * @param vo VO实体对象
//     * @param requiredType 查找结果对象类型
//     * @return 查找结果的首条记录
//     * @author dongzejun
//     */
//    <V extends BaseVo> V findByCondition(V vo);
//
//    /**
//     * 根据实体VO中的非空条件查找<BR>
//     * 注意: VO属性必须与PO属性相同
//     *
//     * @param vo 实体VO对象
//     * @return 查找结果列表
//     * @author dongzejun
//     */
//    <V extends BaseVo> List<V> queryForList(V vo);
//
//    /**
//     * 根据实体中的非空条件查找
//     *
//     * @param vo 实体VO对象
//     * @param requiredType 查找结果对象类型
//     * @param pagination 翻页信息
//     * @return 查找结果列表
//     */
//    <V extends BaseVo> PaginationResult<List<V>> queryForList(V vo, Class<V> requiredType, Pagination pagination);
//
//    /**
//     * 根据 @ParentId 查找
//     *
//     * @param parentId 带有 @ParentId 声明的PO属性参数
//     * @return 查找结果列表
//     * @author dongzejun
//     */
//    <V extends BaseVo> List<V> queryByParentId(Long parentId, Class<V> requiredType);
//
//    /**
//     * 根据 @ParentId,isDeleted 查找
//     *
//     * @param parentId 带有 @ParentId 声明的PO属性参数
//     * @param isDeleted 逻辑删除标记
//     * @return 查找结果列表
//     * @author dongzejun
//     */
//    <V extends BaseVo> List<V> queryByParentId(Long parentId, String isDeleted, Class<V> requiredType);

}
