import request from "@/utils/request";

export function getBookshelfByCategoryId(categoryId) {
  return request({
    url: "/location/getshelf/" + categoryId,
    method: "GET",
  });
}
