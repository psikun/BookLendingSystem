import axios from "axios";

const request = axios.create({
  baseURL: "/api",
  timeout: 5000,
});

// 请求拦截器，在请求发送前对请求做一些处理
request.interceptors.request.use(
  (config) => {
    // 设置内容类型为JSON数据格式以及编码为utf-8
    config.headers["Content-Type"] = "application/json;charset=utf-8";
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// 响应拦截器，在接口响应后统一处理结果
request.interceptors.response.use(
  (response) => {
    // 定义res接收响应数据
    let res = response.data;
    // 兼容服务端返回的字符串数据
    if (typeof res === "string") {
      res = res ? JSON.parse(res) : res;
    }
    return res;
  },
  (error) => {
    console.log("err" + error); // for debug
    return Promise.reject(error);
  }
);

export default request;
