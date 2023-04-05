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
public class Orderdeatil implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单号
     */
    @TableField("Docnum")
    private Long Docnum;

    /**
     * 产品id
     */
    private Long goodid;

    /**
     * 产品数量
     */
    private Long num;


}
