package com.example.dmreader.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodVo {

    private Long Docnum;

    private Long id;
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

    /**
     * 产品数量
     */
    private Long Num;

}
