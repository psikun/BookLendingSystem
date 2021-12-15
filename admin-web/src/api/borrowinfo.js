import request from "@/utils/request";

export function getBorrowInfo(params) {
  return request({
    url: "/borrowinfo",
    method: "GET",
    params: params,
  });
}
