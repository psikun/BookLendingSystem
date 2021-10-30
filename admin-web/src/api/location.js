import request from "@/utils/request";

export function getLocationById(shelfId) {
  return request({
    url: "/location/" + shelfId,
    method: "GET",
  });
}
export function getBookshelfByCategoryId(categoryId) {
  return request({
    url: "/location/list/" + categoryId,
    method: "GET",
  });
}
