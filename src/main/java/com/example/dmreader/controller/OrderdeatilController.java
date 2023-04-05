package com.example.dmreader.controller;


import com.example.dmreader.pojo.User;
import com.example.dmreader.service.IOrderdeatilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangchenyi
 */
@Controller
@RequestMapping("/orderdeatil")
public class OrderdeatilController {
    @Autowired
    private IOrderdeatilService iOrderdeatilService;

}
