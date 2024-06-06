package me.sjl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.sjl.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhanglifang
 * @since 2021-11-24
 */
@Mapper
public interface MemberMapper extends BaseMapper<MemberEntity> {


}
