package com.jw.demo.app.util.aws.s3;

import java.net.URL;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.jw.demo.common.response.DefaultResponse;
import com.jw.demo.common.response.FailResponse;
import com.jw.demo.common.response.InfoResponse;
import com.jw.demo.common.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.HttpMethod;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;

public class S3Util {
    private Logger log = LoggerFactory.getLogger(getClass());

    public static S3Util getInstance() {
        return new S3Util();
    }

    /**
     * 上传对象
     * 
     * @param accessKey     亚马逊接口凭证
     * @param secretKey     亚马逊接口凭证
     * @param region        亚马逊区域
     * @param bucketName    存储桶名称
     * @param objectKey     对象名称
     * @param objectContent 对象内容
     */
    public Response uploadObject(String region, String bucketName, String objectKey, String objectContent) {
        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(region).build();
            s3Client.putObject(bucketName, objectKey, objectContent);
        } catch (Exception e) {
            log.error("S3Util.uploadObject", e);
            e.printStackTrace();
            return new FailResponse();
        }
        return new DefaultResponse();
    }

    /**
     * 生成对象预签名URL
     * 
     * @param accessKey  亚马逊接口凭证
     * @param secretKey  亚马逊接口凭证
     * @param region     亚马逊区域
     * @param bucketName 存储桶名称
     * @param objectKey  对象名称
     * @return
     */
    public Response generatePresignedUrl(String region, String bucketName, String objectKey) {
        URL url = null;
        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(region).build();
            GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, objectKey)
                    .withMethod(HttpMethod.GET);
            url = s3Client.generatePresignedUrl(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new FailResponse();
        }
        return url == null ? new FailResponse() : new InfoResponse<>(url.toString());
    }

}
