import request from "@/utils/request";

export function getBookInfo(params) {
  return request({
    url: "/bookinfo",
    method: "GET",
    params: params,
  });
}

export function addBooks(data) {
  return request({
    url: "/bookinfo",
    method: "POST",
    data: data,
  });
}
