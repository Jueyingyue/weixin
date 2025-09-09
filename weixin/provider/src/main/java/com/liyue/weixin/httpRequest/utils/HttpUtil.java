package com.liyue.weixin.httpRequest.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 通用 HTTP 请求工具类
 * 支持 GET 和 POST（表单 / JSON），可自定义请求头
 */
public class HttpUtil {

    /**
     * 发起 GET 请求
     *
     * @param urlStr   请求地址
     * @param headers  请求头（可选，可为 null）
     * @return 服务器返回的内容字符串
     * @throws Exception 请求失败时抛出异常
     */
    public static String doGet(String urlStr, Map<String, String> headers) throws Exception {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            // 创建 URL 对象
            URL url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(false);

            // 设置请求头
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }

            // 获取响应码
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 读取返回内容
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            } else {
                throw new RuntimeException("HTTP GET 请求失败，响应码：" + responseCode);
            }
        } finally {
            // 关闭资源
            if (reader != null) {
                reader.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    /**
     * 发起 POST 请求（JSON 格式提交）
     *
     * @param urlStr   请求地址
     * @param jsonBody JSON 字符串请求体
     * @param headers  请求头（可选，可为 null）
     * @return 服务器返回的内容字符串
     * @throws Exception 请求失败时抛出异常
     */
    public static String doPostJson(String urlStr, String jsonBody, Map<String, String> headers) throws Exception {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        OutputStream outputStream = null;
        try {
            URL url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);

            // 设置请求头
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }

            // 写入 JSON 请求体
            if (jsonBody != null && !jsonBody.isEmpty()) {
                outputStream = connection.getOutputStream();
                outputStream.write(jsonBody.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
            }

            // 获取响应码
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            } else {
                throw new RuntimeException("HTTP POST 请求失败，响应码：" + responseCode);
            }
        } finally {
            // 关闭资源
            if (outputStream != null) {
                outputStream.close();
            }
            if (reader != null) {
                reader.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    /**
     * 发起 POST 请求（表单格式提交）
     *
     * @param urlStr   请求地址
     * @param formData 表单数据，格式如 "key1=value1&key2=value2"
     * @param headers  请求头（可选，可为 null）
     * @return 服务器返回的内容字符串
     * @throws Exception 请求失败时抛出异常
     */
    public static String doPostForm(String urlStr, String formData, Map<String, String> headers) throws Exception {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        OutputStream outputStream = null;
        try {
            URL url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);

            // 设置表单提交的 Content-Type
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }

            // 写入表单数据
            if (formData != null && !formData.isEmpty()) {
                outputStream = connection.getOutputStream();
                outputStream.write(formData.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
            }

            // 获取响应
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            } else {
                throw new RuntimeException("HTTP POST 表单请求失败，响应码：" + responseCode);
            }
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (reader != null) {
                reader.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
