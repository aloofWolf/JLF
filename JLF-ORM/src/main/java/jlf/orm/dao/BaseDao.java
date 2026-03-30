package jlf.orm.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jlf.orm.metadata.bean.page.BasePageRequest;
import jlf.orm.metadata.bean.page.BasePageResponse;
import jlf.orm.metadata.entity.BaseEntity;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @param <T>
 * @author Lone Wolf
 * @ClassName: BaseDao
 * @Description: DAO父类
 * @date 2010年9月10日
 */
public interface BaseDao<T extends BaseEntity> extends BaseMapper<T> {

    /**
     * @param id
     * @return
     * @Title: getById
     * @Description: 根据id查询实体，如果实体被@Cache注解标注，则会优先去缓存中查询
     */
    @SuppressWarnings("unchecked")
    default T getById(Long id) {
        return (T) BaseDaoExt.get().getById(this, id);
    }

    /**
     * @param basePageRequest
     * @param wrapper
     * @return
     * @Title: getPage
     * @Description: 分页查询
     */
    default BasePageResponse<T> getPage(BasePageRequest basePageRequest, QueryWrapper<T> wrapper) {
        IPage<T> page = new Page<>(basePageRequest.getPageNum(), basePageRequest.getSizeNum());
        page = this.selectPage(page, wrapper);
        return new BasePageResponse<T>(page);
    }

    /**
     * @return
     * @Title: getStringRedisTemplate
     * @Description: 获取RedisTemplate对象
     */
    default RedisTemplate<String, String> getStringRedisTemplate() {
        return BaseDaoExt.get().stringRedisTemplate;
    }

}
