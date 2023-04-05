package com.example.dmreader.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangchenyi
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Goodlist implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 列表号
     */
    @TableField("Docnum")
    private Long Docnum;

    /**
     * 商品条码
     */
    private Long goodsptm;

    /**
     * 有效期
     */
    private String vlidity;

    /**
     * 生产日期
     */
    private String scrq;

    /**
     * 批次
     */
    private String benchid;

    /**
     * 产品数量
     */
    private Long num;


}
