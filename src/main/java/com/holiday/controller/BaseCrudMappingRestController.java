package com.holiday.controller;

import com.diboot.core.controller.BaseCrudRestController;
import com.diboot.core.entity.BaseEntity;
import com.diboot.core.vo.JsonResult;
import com.diboot.core.vo.Pagination;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.Serializable;

/**
* 通用CRUD通用父类RestController，子类继承即可拥有CRUD接口（禁止只读接口Controller继承）
* @author Elvis
* @version 1.0.0
* @date 2020-01-18
* Copyright © Elvis.com
*/
public class BaseCrudMappingRestController<E extends BaseEntity, VO extends Serializable> extends BaseCrudRestController {
    private static final Logger log = LoggerFactory.getLogger(BaseCrudMappingRestController.class);

    /***
    * 查询ViewObject的分页数据
    * <p>
    * url请求参数示例: /list?field=abc&pageSize=20&pageIndex=1&orderBy=id
    * </p>
    * @return
    * @throws Exception
    */
    @GetMapping("/list")
    public JsonResult getViewObjectListWithMapping(E entity, Pagination pagination, HttpServletRequest request) throws Exception{
        return getViewObjectList(entity, pagination, request);
    }

    /***
    * 根据资源id查询ViewObject
    * @param id ID
    * @return
    * @throws Exception
    */
    @GetMapping("/{id}")
    public JsonResult getViewObjectWithMapping(@PathVariable("id")Serializable id, HttpServletRequest request) throws Exception{
        return getViewObject(id, request);
    }

    /***
    * 创建资源对象
    * @param entity
    * @return JsonResult
    * @throws Exception
    */
    @PostMapping("/")
    public JsonResult createEntityWithMapping(@Valid @RequestBody E entity, HttpServletRequest request) throws Exception {
        return createEntity(entity, request);
    }

    /***
    * 根据ID更新资源对象
    * @param entity
    * @return JsonResult
    * @throws Exception
    */
    @PutMapping("/{id}")
    public JsonResult updateEntityWithMapping(@PathVariable("id")Serializable id, @Valid @RequestBody E entity, HttpServletRequest request) throws Exception {
        return updateEntity(id, entity, request);
    }

    /***
    * 根据id删除资源对象
    * @param id
    * @return
    * @throws Exception
    */
    @DeleteMapping("/{id}")
    public JsonResult deleteEntityWithMapping(@PathVariable("id")Serializable id, HttpServletRequest request) throws Exception {
        return deleteEntity(id, request);
    }

}