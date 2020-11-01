package com.csuylg.modules.system.controller;

import com.csuylg.common.utils.FileUploadUtils;
import com.csuylg.common.utils.Md5Utils;
import com.csuylg.common.web.CommonResponse;
import com.csuylg.config.MorningConfig;
import com.csuylg.modules.system.domain.Notice;
import com.csuylg.modules.system.domain.NoticeImg;
import com.csuylg.modules.system.service.NoticeImgService;
import com.csuylg.modules.system.service.NoticeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 通知公告
 *
 * @author dyf
 */
@RestController
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @Autowired
    private NoticeImgService noticeImgService;

    /**
     * 响应用户请求通知列表操作
     */
    @GetMapping("/InfoSrcServlet")
    public List<String> list(Integer page){
        PageHelper.startPage(page, 15);
        return noticeService.selectNoticeList();
    }

    /**
     * 响应用户请求通知详情，返回通知正文
     */
    @GetMapping("/InfoDetailServlet")
    public String getInfo(String title){
        if(null == title){
            return "暂时没有新通知。";
        }
        return noticeService.selectContentByTitle(title);
    }

    /**
     * 获取某条通知的图片的url数组
     */
    @GetMapping("/ImgSrcServlet")
    public List<String> getImgList(String title){
        return noticeService.selectImgListByTitle(title);
    }

    /**
     * 响应管理员发布通知
     */
    @PostMapping("/ActUploadServlet")
    public void add(@RequestParam("img") MultipartFile file, String title, String detail) throws IOException {
        Notice notice = new Notice(title, detail, new Date());
        int noticeId = noticeService.insertNotice(notice);

        String img = FileUploadUtils.upload(MorningConfig.getNoticeImgPath() + Md5Utils.hash(title), file);
        noticeImgService.insertNoticeImg(new NoticeImg(img, noticeId));
    }

    /**
     * 响应管理员删除通知
     */
    @PostMapping("/ActDelServlet")
    public CommonResponse remove(String title){
        noticeService.deleteNoticeByTitle(title);
        return CommonResponse.success();
    }
}
