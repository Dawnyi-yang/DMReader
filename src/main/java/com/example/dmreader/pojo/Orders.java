package com.example.dmreader.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("t_orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    @TableField("Docnum")
    private Long Docnum;

    /**
     * 客户id
     */
    @TableField("Crdid")
    private String Crdid;

    /**
     * 客户名称
     */
    @TableField("Crdname")
    private String Crdname;

    /**
     * 地址
     */
    private String addr;

    /**
     * 产品数量
     */
    private Long num;

    /**
     * 是否出库
     */
    private Integer state;


}
