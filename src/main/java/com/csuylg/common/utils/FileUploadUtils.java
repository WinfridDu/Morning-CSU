package com.csuylg.common.utils;

import com.csuylg.config.MorningConfig;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * 文件上传工具类
 * 
 * @author dyf
 */
public class FileUploadUtils {
    /**
     * 默认上传的地址
     */
    public static String defaultBaseDir = MorningConfig.getProfile();
    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";

    private static int counter = 0;

    public static String getDefaultBaseDir()
    {
        return defaultBaseDir;
    }

    /**
     * 以默认配置进行文件上传
     *
     * @param file 上传的文件
     * @return 文件名称
     */
    public static String upload(MultipartFile file) throws IOException {
        try {
            return upload(getDefaultBaseDir(), file);
        } catch (Exception e) {
            throw new IOException(e.getMessage(), e);
        }
    }

    /**
     * 文件上传
     *
     * @param baseDir 相对应用的基目录
     * @param file 上传的文件
     * @return 返回上传成功的文件名
     * @throws IOException 比如读写文件出错时
     */
    public static String upload(String baseDir, MultipartFile file) throws IOException {
        String fileName = extractFilename(file);
        return upload(baseDir, file, fileName);
    }

    /**
     * 文件上传
     *
     * @param baseDir 相对应用的基目录
     * @param file 上传的文件
     * @param fileName 文件名
     * @return 返回上传成功的文件名
     * @throws IOException 比如读写文件出错时
     */
    public static String upload(String baseDir, MultipartFile file, String fileName) throws IOException {
        File desc = getAbsoluteFile(baseDir, fileName);
        file.transferTo(desc);
        return getPathFileName(baseDir, fileName);
    }

    /**
     * 编码文件名
     */
    public static String extractFilename(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String extension = getExtension(file);
        fileName = encodingFilename(fileName) + "." + extension;
        return fileName;
    }

    public static File getAbsoluteFile(String uploadDir, String fileName) throws IOException {
        File desc = new File(uploadDir + File.separator + fileName);

        if (!desc.getParentFile().exists()) {
            desc.getParentFile().mkdirs();
        }
        if (!desc.exists()) {
            desc.createNewFile();
        }
        return desc;
    }

    private static String getPathFileName(String uploadDir, String fileName) {
        int dirLastIndex = MorningConfig.getProfile().length() + 1;
        String currentDir = StringUtils.substring(uploadDir, dirLastIndex);
        return RESOURCE_PREFIX + "/" + currentDir + "/" + fileName;
    }

    /**
     * 编码文件名
     */
    private static String encodingFilename(String fileName) {
        fileName = fileName.replace("_", " ");
        fileName = Md5Utils.hash(fileName + System.nanoTime() + counter++);
        return fileName;
    }

    /**
     * 获取文件名的后缀
     * 
     * @param file 表单文件
     * @return 后缀名
     */
    public static String getExtension(MultipartFile file) {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        if (StringUtils.isEmpty(extension)) {
            extension = MimeTypeUtils.getExtension(Objects.requireNonNull(file.getContentType()));
        }
        return extension;
    }
}