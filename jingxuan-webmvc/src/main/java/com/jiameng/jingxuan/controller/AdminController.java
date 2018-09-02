package com.jiameng.jingxuan.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.jiameng.jingxuan.common.util.Constants.*;
import static com.jiameng.jingxuan.common.util.ConstantUtil.MINUS;
import static com.jiameng.jingxuan.common.util.ConstantUtil.BLANK;
import static com.jiameng.jingxuan.common.util.ConstantUtil.DOT;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.jcraft.jsch.ChannelSftp;
import com.jiameng.jingxuan.config.WebMVCResourceProperties;
import com.jiameng.jingxuan.model.domain.Admin;
import com.jiameng.jingxuan.model.domain.ProductCategory;
import com.jiameng.jingxuan.model.enums.AdminStatusEnum;
import com.jiameng.jingxuan.service.IAdminService;
import com.jiameng.jingxuan.utils.FileUploadUtil;

@Controller
@RequestMapping("/admin")
public class AdminController {
  private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

  @Autowired
  IAdminService adminService;
  @Autowired
  protected WebMVCResourceProperties properties;

  /**
   * 测试编码
   */
  @RequestMapping(value = "/test", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject test(@RequestBody JSONObject search) {
    JSONObject result = new JSONObject();
    String name = search.getString("name");
    logger.debug("========测试编码========:" + name);
    System.out.println("========测试编码========:" + name);
    if (idNull(result, StringUtils.isBlank(name), "产品类目名称不能为空！", EMPTY)) return result;
    
    result.put("name",name);

    return result;
  }

  /**
   * 搜索产品
   */
  @RequestMapping(value = "/product/search", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject search(@RequestBody JSONObject search) {
    JSONObject result = new JSONObject();
    String name = search.getString("name");
    if (idNull(result, StringUtils.isBlank(name), "产品类目名称不能为空！", EMPTY)) return result;
    return result;
  }


  /**
   * 搜索产品类目
   */
  @RequestMapping(value = "/product/category/search", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject searchCategory(@RequestBody JSONObject search) {
    JSONObject result = new JSONObject();

    String name = search.getString("name");
    if (idNull(result, StringUtils.isBlank(name), "产品类目名称不能为空！", EMPTY)) return result;

    return null;
  }

  /**
   * 更新产品类目
   */
  @RequestMapping(value = "/product/category/update", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject updateProductCategory(@RequestBody JSONObject productCategorys) {
    Integer id = productCategorys.getInteger("id");
    String name = productCategorys.getString("name");
    String img = productCategorys.getString("img");

    JSONObject result = new JSONObject();

    if (idNull(result, StringUtils.isBlank(name), "产品类目id不能为空！", EMPTY)) return result;

    if (idNull(result, StringUtils.isBlank(name), "名称不能为空！", EMPTY)) return result;

    if (idNull(result, StringUtils.isBlank(img), "图片地址不能为空！", EMPTY)) return result;

    ProductCategory productCategory = new ProductCategory();
    productCategory.setId(id);
    productCategory.setName(name);
    productCategory.setRemark(name);
    productCategory.setImgUrl(img);

    boolean bRet = adminService.updateCategoryStatus(productCategory);
    if (bRet == false) {
      System.out.println("saveProductCategory: save product category failed");
      result.put("code", ERROE);
      result.put("msg", "update product category failed");
      result.put(DATA, null);
      return result;
    }

    result.put("code", SUCCESS);
    result.put("msg", "success");
    result.put(DATA, null);
    return result;
  }

  /**
   * 删除 产品类目
   */
  @RequestMapping(value = "/product/category/delete", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject deleteCategory(@RequestBody JSONObject deleteCategory) {
    JSONObject result = new JSONObject();

    Integer id = deleteCategory.getInteger("id");

    if (idNull(result, id == null, "id不能为空！", EMPTY)) return result;

    boolean flag = adminService.deleteProductCategory(id);
    if (idNull(result, !flag, "删除产品类目失败，请重试！", UPDATE_ERROE)) return result;
    result.put(MSG, "success");
    result.put(CODE, SUCCESS);
    result.put(DATA, null);
    return result;
  }

  /**
   * 修改类目状态 状态-0:禁用; 1:启用; 3:删除;
   */
  @RequestMapping(value = "/product/update/category/status", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject updateCategoryStatus(@RequestBody JSONObject categoryStatus) {
    JSONObject result = new JSONObject();
    JSONObject data = new JSONObject();

    Integer id = categoryStatus.getInteger("id");
    Short status = categoryStatus.getShort("status");

    if (idNull(result, id == null, "id不能为空！", EMPTY)) return result;

    if (idNull(result, status == null, "status不能为空！", EMPTY)) return result;

    ProductCategory category = new ProductCategory();
    category.setId(Integer.valueOf(id));
    category.setStatus(status);

    boolean flag = adminService.updateCategoryStatus(category);
    if (idNull(result, flag == false, "状态修改失败，请重试！", UPDATE_ERROE)) return result;

    result.put(MSG, "success");
    result.put(CODE, SUCCESS);
    result.put(DATA, null);
    return result;
  }

  private boolean idNull(JSONObject result, boolean b, String s, int empty) {
    if (b) {
      result.put(MSG, s);
      result.put(CODE, empty);
      result.put(DATA, null);
      return true;
    }
    return false;
  }

  /**
   * 获取产品列表
   */
  @RequestMapping(value = "/product/getCategory", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject name(@RequestBody JSONObject productCategorys) {
    List<ProductCategory> categories = adminService.getCategory();
    JSONObject result = new JSONObject();
    JSONObject data = new JSONObject();

    result.put("code", SUCCESS);
    result.put("msg", "success");
    result.put(DATA, categories);

    return result;
  }

  /**
   * 保存类目，新增类目
   *
   * @param productCategorys
   * @return
   */
  @RequestMapping(value = "/save/category", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject saveProductCategory(@RequestBody JSONObject productCategorys) {
    String name = productCategorys.getString("name");
    String img = productCategorys.getString("img");

    JSONObject result = new JSONObject();
    JSONObject data = new JSONObject();

    if (idNull(result, StringUtils.isBlank(name), "名称不能为空！", EMPTY)) return result;

    if (idNull(result, StringUtils.isBlank(img), "图片地址不能为空！", EMPTY)) return result;

    Date date = new Date();

    ProductCategory productCategory = new ProductCategory();
    productCategory.setName(name);
    productCategory.setRemark(name);
    productCategory.setSort(0);
    productCategory.setStatus((short) 0);// 默认禁止状态
    productCategory.setImgUrl(img);
    productCategory.setCreateTime(date);

    boolean bRet = adminService.saveProductCategory(productCategory);
    if (bRet == false) {
      System.out.println("saveProductCategory: save product category failed");
      result.put("code", ERROE);
      result.put("msg", "save product category failed");
      result.put(DATA, null);
      return result;
    }

    data.put("name", name);
    data.put("imgUrl", img);
    data.put("createTime", date);

    result.put("code", SUCCESS);
    result.put("msg", "success");
    // result.put(DATA, data);

    return result;
  }

  @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject uploadFiles(@RequestParam(value = "file", required = false) MultipartFile[] file) {
    JSONObject result = new JSONObject();
    JSONObject data = new JSONObject();
    ArrayList<JSONObject> images = new ArrayList<JSONObject>();
    JSONObject img = new JSONObject();
    try {
      for (MultipartFile mf : file) {
        if (!mf.isEmpty()) {
          img.put("name", mf.getOriginalFilename());
          img.put("url", upload(mf.getOriginalFilename(), mf));
          images.add(img);
        }
      }
      data.put("images", images);
      result.put(MSG, "success");
      result.put(CODE, 0);
      result.put(DATA, data);
      return result;

    } catch (Exception e) {
      result.put(MSG, "图片上传失败");
      result.put(CODE, 400);
      return result;
    }

  }

  @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject uploadFileHandler(@RequestParam("file") MultipartFile file) {
    JSONObject result = new JSONObject();
    JSONObject data = new JSONObject();
    JSONObject img = new JSONObject();
    if (!file.isEmpty()) {
      try {

        String originalFilename = file.getOriginalFilename();

        String fileUrl = upload(originalFilename, file);
        result.put(MSG, "success");
        result.put(CODE, 0);
        data.put("imgurl", fileUrl);
        data.put("name", originalFilename);
        result.put(DATA, data);

        System.out.println("saveProductCategory: save product category success11111111:" + originalFilename);
        System.out.println("saveProductCategory: save product category success22222222:" + file.getName());

        return result;
      } catch (Exception e) {
        return (JSONObject) result.put(MSG,
                "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage());
      }
    } else {
      return (JSONObject) result.put(MSG,
              "You failed to upload " + file.getOriginalFilename() + " because the file was empty.");
    }
  }

  @RequestMapping(value = "/save/product/category", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject saveProductCategory(String name, String remark, Integer sort, ServletRequest request) {
    JSONObject result = new JSONObject();
    JSONObject data = new JSONObject();

    System.out.println("saveProductCategory: name=" + name + ", remark=" + remark + ", sort=" + sort);
    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
    Iterator<String> iterator = multipartRequest.getFileNames();
    while (iterator.hasNext()) {
      MultipartFile file = multipartRequest.getFile(iterator.next());
      if (file != null && StringUtils.isNotBlank(file.getOriginalFilename())) {
        String imgUrl = upload(file.getOriginalFilename(), file);

        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(name);
        productCategory.setRemark(remark);
        productCategory.setSort(sort);
        productCategory.setStatus((short) 0);// 默认禁止状态
        productCategory.setImgUrl(imgUrl);
        productCategory.setCreateTime(new Date());

        boolean bRet = adminService.saveProductCategory(productCategory);
        if (bRet == false) {
          System.out.println("saveProductCategory: save product category failed");
          result.put("code", "9999");
          result.put("msg", "save product category failed");
          return result;
        }
      }
    }

    System.out.println("saveProductCategory: save product category success");

    data.put("test", "OK");
    result.put("code", 0);
    result.put("msg", "success");
    result.put("data", data);
    return result;
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject login(String username, String password, HttpServletRequest request) {
    JSONObject result = new JSONObject();
    JSONObject data = new JSONObject();

    System.out.println("login: username=" + username + ", password=" + password);

    data.put("username", username);
    result.put("code", 0);
    result.put("msg", "success");
    result.put("data", data);
    return result;
  }

  /**
   * 获取token
   */
  @RequestMapping(value = "/token", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject getToken(@RequestBody JSONObject userInfo, HttpServletRequest request) {
    JSONObject result = new JSONObject();

    logger.info("getToken: userInfo=" + userInfo.toJSONString());

    String username = userInfo.getString("username");
    String password = userInfo.getString("password");

    if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
      result.put(CODE, PHONE_NUMBER_EMPTY);
      result.put(MSG, "登录账号或密码不能为空!");
      result.put(DATA, null);
      return result;
    }

    Admin admin = adminService.getAdmin(username);
    if (admin == null) {
      result.put(CODE, ACCOUNT_NOT_EXISTS);
      result.put(MSG, "账号不存在!");
      result.put(DATA, null);
      return result;
    }

    if (!StringUtils.equals(DigestUtils.md5Hex(password), admin.getPassword())) {
      result.put(CODE, ACCOUNT_NOT_EXISTS);
      result.put(MSG, "输入的密码错误!");
      result.put(DATA, null);
      return result;
    }

    if (admin.getStatus() == AdminStatusEnum.DISABLED.value()) {
      result.put(CODE, ACCOUNT_DISABLED);
      result.put(MSG, "该账号被禁用 !");
      result.put(DATA, null);
      return result;
    }

    request.getSession().setAttribute(properties.getSession(), admin);

    JSONObject data = new JSONObject();
    data.put("token", request.getSession().getId());
    result.put(CODE, 0);
    result.put(MSG, "成功");
    result.put(DATA, data);

    return result;
  }

  @RequestMapping(value = "/userinfo", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject getUserInfo(@RequestBody JSONObject loginInfo, HttpServletRequest request) {
    JSONObject result = new JSONObject();

    logger.info("getUserInfo: loginInfo=" + loginInfo.toJSONString());

    String token = loginInfo.getString("token");
    if (StringUtils.isBlank(token)) {
      result.put(CODE, TOKEN_EMPTY);
      result.put(MSG, "token为空!");
      result.put(DATA, null);
      return result;
    }

    HttpSession session = request.getSession();
    if (!StringUtils.equals(session.getId(), token)) {
      result.put(CODE, TOKEN_EXPIRED);
      result.put(MSG, "登录超时(1)，请重新登录!");
      result.put(DATA, null);
      return result;
    }

    Admin admin = (Admin) request.getSession().getAttribute(properties.getSession());
    if (admin == null) {
      result.put(CODE, TOKEN_EXPIRED);
      result.put(MSG, "登录超时(2)，请重新登录!");
      result.put(DATA, null);
      return result;
    }

    JSONObject data = new JSONObject();
    data.put("id", admin.getId());
    data.put("name", admin.getName());
    data.put("realName", admin.getRealName());

    result.put(CODE, 0);
    result.put(MSG, "success");
    result.put(DATA, data);

    return result;
  }

  @RequestMapping(value = "/quit", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject quit(@RequestBody JSONObject loginInfo, HttpServletRequest request) {
    JSONObject result = new JSONObject();

    logger.info("quit: loginInfo=" + loginInfo.toJSONString());

    request.getSession().invalidate();

    result.put(CODE, 0);
    result.put(MSG, "success");
    return result;
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  protected String upload(String originalFilename, MultipartFile file) {
    int ret = -1;
    if (file != null && StringUtils.isNotBlank(originalFilename)) {
      InputStream stream = null;
      try {
        FileUploadUtil sf = new FileUploadUtil();
        String[] uploadAddr = properties.getUploadAddr().split(":");
        ChannelSftp sftp = sf.connect(uploadAddr[0], Integer.valueOf(uploadAddr[1]),
                properties.getUploadUsername(), properties.getUploadPassword());
        if (sftp == null) {
          return originalFilename;
        }

        stream = file.getInputStream();
        String uuid = UUID.randomUUID().toString();
        uuid = StringUtils.replace(uuid, MINUS, BLANK);
        String suffix = StringUtils.substring(originalFilename, StringUtils.lastIndexOf(originalFilename, DOT));
        String fileName = uuid + suffix;
        String directory = "/usr/share/nginx/html/images/";
        String newName = directory + fileName;
        ret = sf.upload(directory, stream, newName, sftp);
        sf.closeMySFTP(sftp);
        String pre = "http://" + properties.getDownloadAddr() + "/images/";
        originalFilename = pre + fileName;
      } catch (IOException e) {
        e.getMessage();
      } finally {
        try {
          stream.close();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }

    if (ret != 0) {
      originalFilename = "";
    }
    return originalFilename;
  }
}
