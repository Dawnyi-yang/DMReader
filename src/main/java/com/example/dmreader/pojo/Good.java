package com.example.dmreader.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Good implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 规格
     */
    private String spec;

    /**
     * 商品条码
     */
    private Long sptm;

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


}
