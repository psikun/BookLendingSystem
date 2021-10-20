module.exports = {
  // 开启代理服务器
  devServer: {
    proxy: {
      // 请求前缀
      "/api": {
        target: "http://localhost:8090",
        pathRewrite: { "^/api": "" },
        ws: true,
        // 用于控制请求头中的host值
        changeOrigin: true,
      },
    },
  },
};
