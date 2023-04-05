package com.example.dmreader.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.dmreader.pojo.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVo  {
    private Long Docnum;
    /**
     * 客户id
     */

    private String Crdid;
    private String Crdname;

    /**
     * 规格
     */
    private String addr;

    /**
     * 商品条码
     */


    /**
     * 产品数量
     */
    private Long Num;

    /**
     * 是否出库
     */
    private Integer State;
}
