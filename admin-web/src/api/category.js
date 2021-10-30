import request from "@/utils/request";

export function geCategoryById(categoryId) {
  return request({
    url: "/category/" + categoryId,
    method: "GET",
  });
}
export function getLevelCategories(level) {
  return request({
    url: "/category/level/" + level,
    method: "GET",
  });
}

export function getSubCategories(parentId) {
  return request({
    url: "/category/parent/" + parentId,
    method: "GET",
  });
}
