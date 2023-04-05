package com.example.dmreader.vo;


import com.example.dmreader.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailVo {
    private User user;
    private List<GoodVo> goodVo;

}
