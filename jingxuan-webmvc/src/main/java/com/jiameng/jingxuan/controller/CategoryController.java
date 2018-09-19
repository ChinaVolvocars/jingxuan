package com.jiameng.jingxuan.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {


  @ResponseBody
  @RequestMapping(value = "/category/home", method = RequestMethod.GET)
  public JSONObject categoryHome(@RequestBody JSONObject jsonObject) {

    return null;
  }


}
