package com.fly4j.shop.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fly4j.shop.goods.pojo.entity.GoodsAttributeValue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: TODO自定义会员阶梯价格Dao
 * @author: Mr.
 * @create: 2020/3/14 15:17
 **/
public interface GoodsAttributeValueMapper extends BaseMapper<GoodsAttributeValue> {

    @Insert("<script>" +
            "  insert into goods_attribute_value (goods_id,goods_attribute_id,value) values" +
            "        <foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\">" +
            "            (#{item.goodsId,jdbcType=BIGINT}," +
            "            #{item.goodsAttributeId,jdbcType=BIGINT}," +
            "            #{item.value,jdbcType=VARCHAR})" +
            "        </foreach>"+
            "</script>")
    int insertList(@Param("list") List<GoodsAttributeValue> goodsLadderList);
}
