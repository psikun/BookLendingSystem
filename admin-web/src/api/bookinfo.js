import request from "@/utils/request";

export function getBookInfo(params) {
  return request({
    url: "/bookinfo",
    method: "GET",
    params: params,
  });
}

export function getBookById(id) {
  return request({
    url: "/bookinfo/" + id,
    method: "GET",
  });
}

export function addBook(data) {
  return request({
    url: "/bookinfo/add",
    method: "POST",
    data: data,
  });
}
export function updateBook(data) {
  return request({
    url: "/bookinfo/update",
    method: "POST",
    data: data,
  });
}

export function deleteBook(id) {
  return request({
    url: "/bookinfo/" + id,
    method: "DELETE",
  });
}
