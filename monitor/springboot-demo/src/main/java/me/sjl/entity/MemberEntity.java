package me.sjl.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author zhanglifang
 * @since 2021-11-24
 */
@Getter
@Setter
@TableName("Member")
public class MemberEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * type = IdType.AUTO  禁止覆盖操作 会影响雪花id的生成
     */
    @TableId(value = "Id")
    private Long id;

    /**
     * 卡号
     */
    @TableField("CardNumber")
    private String cardNumber;

    /**
     * 外部会员卡，靓号
     */
    @TableField("cardnumberext")
    private String cardNumberExt;

    /**
     * 昵称
     */
    @TableField("NiceName")
    private String niceName;

    /**
     * 真实姓名
     */
    @TableField("RealName")
    private String realName;

    /**
     * 性别 1 男性 2 女性 3未知
     */
    @TableField("Gender")
    private Integer gender;

    @TableField("Birthday")
    private Long birthday;

    /**
     * 微信号
     */
    @TableField("we_chat")
    private String weChat;

    /**
     * 创建时间
     */
    @TableField("CreateTime")
    private Long createTime;

    @TableField("Phone")
    private String phone;

    @TableField("Photo")
    private String photo;

    /**
     * 状态  1.正常 2.禁用 3.废弃（会员信息已被合并主会员，当前记录废弃） 4.粉丝
     */
    @TableField("Status")
    private Integer status;

    /**
     * 更新时间
     */
    @TableField("UpdateTime")
    private Long updateTime;

    /**
     * 注册时间
     */
    @TableField("RegisterTime")
    private Long registerTime;

    @TableField("CustomerId")
    private Long customerId;

    /**
     * 入会时间
     */
    @TableField("MembershipTime")
    private Long membershipTime;

    /**
     * 注册来源 1.B2C商城 2.O2O商城 3.私域管家 4.手动录入 5.公众号
     */
    @TableField("RegisterSource")
    private Integer registerSource;

    /**
     * 省id
     */
    @TableField("ProvinceId")
    private Integer provinceId;

    /**
     * 市id
     */
    @TableField("CityId")
    private Integer cityId;

    /**
     * 区id
     */
    @TableField("areaid")
    private Integer areaId;

    /**
     * 上次登录时间
     */
    @TableField("LastLoginTime")
    private Long lastLoginTime;

    /**
     * 会员导购id
     */
    @TableField("guide_id")
    private Long guideId;

    /**
     * 会员导购企微userId
     */
    @TableField("corporate_wx_user_id")
    private String corporateWxUserId;

    /**
     * 开卡门店id
     */
    @TableField("open_store_id")
    private Long openStoreId;
    /**
     * 开卡导购id
     */
    @TableField("open_guide_id")
    private Long openGuideId;
    /**
     * 服务门店id
     */
    @TableField("service_store_id")
    private Long serviceStoreId;
    /**
     * 服务导购id
     */
    @TableField("service_guide_id")
    private Long serviceGuideId;

    /**
     * 业绩归属导购
     */
    @TableField("performance_attribution_guide_id")
    private Long performanceAttributionGuideId;

    /**
     * 业绩归属导购门店id
     */
    @TableField("performance_attribution_store_id")
    private Long performanceAttributionStoreId;

    /**
     * 最低会员等级
     */
    @TableField("lowest_leve_id")
    private Long lowestLeveId;

    /**
     * 当前保护期结束时间 为0 则表示当前等级是会员最低等级
     */
    @TableField("current_protection_end_time")
    private Long currentProtectionEndTime;

}
