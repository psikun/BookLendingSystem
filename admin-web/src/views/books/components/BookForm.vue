<template>
  <el-form
    ref="bookInfoForm"
    :model="bookInfo"
    :rules="rules"
    label-width="100px"
    label-position="left"
  >
    <el-form-item label="书籍名称" prop="name">
      <el-input
        placeholder="请输入书籍名称"
        style="width: 300px"
        v-model="bookInfo.name"
        :label="bookInfo.name"
      ></el-input>
    </el-form-item>
    <el-form-item label="作者" prop="author">
      <el-input
        placeholder="请输入作者"
        style="width: 300px"
        v-model="bookInfo.author"
        label="bookInfo.author"
      ></el-input>
    </el-form-item>
    <el-form-item label="出版社" prop="press">
      <el-input
        placeholder="请输入出版社"
        style="width: 300px"
        v-model="bookInfo.press"
        :label="bookInfo.press"
      ></el-input>
    </el-form-item>
    <el-form-item label="定价" prop="price">
      <el-input
        placeholder="请输入图书定价"
        style="width: 300px"
        v-model="bookInfo.price"
        :label="bookInfo.price"
        type="number"
      ></el-input>
    </el-form-item>
    <el-form-item label="ISBN号码" prop="isbn">
      <el-input
        placeholder="请输入ISBN号码"
        style="width: 300px"
        v-model="bookInfo.isbn"
        :label="bookInfo.isbn"
      ></el-input>
    </el-form-item>
    <el-form-item label="分类" prop="categoryId">
      <el-cascader
        v-model="bookInfo.categoryId"
        :options="categoryData"
        @change="handleChange"
        style="width: 300px"
        placeholder="选择分类"
      ></el-cascader>
    </el-form-item>
    <el-form-item label="书架编号" prop="locationId">
      <el-select
        v-model="bookInfo.locationId"
        placeholder="请先选择分类"
        :disabled="this.bookInfo.categoryId === null"
      >
        <el-option
          v-for="item in bookShelfData"
          :key="item.value"
          :label="item.label"
          :value="item.value"
        >
        </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="索书号" prop="callNumber">
      <el-input
        placeholder="请输入索书号"
        style="width: 300px"
        v-model="bookInfo.callNumber"
        :label="bookInfo.locationNumber"
      ></el-input>
    </el-form-item>
    <el-form-item label="书籍描述" prop="description">
      <el-input
        placeholder="请输入书籍描述"
        style="width: 500px"
        type="textarea"
        v-model="bookInfo.description"
        :label="bookInfo.description"
      ></el-input>
    </el-form-item>
  </el-form>
</template>

<script>
import { getLevelCategories, getSubCategories } from "@/api/category";
import { getBookshelfByCategoryId } from "@/api/location";

export default {
  name: "BookForm",
  created() {
    // 调用函数获取分类信息
    this.getCategoriesSelect();
  },
  data() {
    return {
      bookInfo: {
        name: "",
        author: "",
        press: "",
        isbn: "",
        categoryId: null,
        locationId: null,
        price: "",
        callNumber: "",
        description: "",
      },
      categoryData: [],
      bookShelfData: [],
      parentId: 0,
      rules: {
        name: [
          {
            required: true,
            message: "请输入图书名称",
            trigger: "blur",
          },
        ],
        author: [
          {
            required: true,
            message: "请输入图书作者",
            trigger: "blur",
          },
        ],
        press: [
          {
            required: true,
            message: "请输入图书出版社",
            trigger: "blur",
          },
        ],
        price: [
          {
            required: true,
            message: "请输入图书定价",
            trigger: "blur",
          },
        ],
        isbn: [
          {
            required: true,
            message: "请输入图书ISBN号码",
            trigger: "blur",
          },
          {
            message: "ISBN号码长度应为13",
            len: 13,
            trigger: "blur",
          },
        ],
        locationId: [
          {
            required: true,
            message: "请选择图书书架",
            trigger: "blur",
          },
        ],
        categoryId: [
          {
            required: true,
            message: "请选择图书分类",
            trigger: "change",
          },
        ],

        locationNumber: [
          {
            required: true,
            message: "请输入图书索书号",
            trigger: "change",
          },
        ],
      },
    };
  },
  methods: {
    // 获取分类选择
    getCategoriesSelect() {
      // 定义一级分类
      let firstCategories = [];
      // 传入level参数，调用api，获取一级分类
      getLevelCategories(1).then((res) => {
        // 一级分类赋值
        firstCategories = res.data;
        // 遍历一级分类
        for (let i = 0; i < firstCategories.length; i++) {
          // 定义二级分类
          let secondCategories = [];
          // 传入父级ID参数，调用api，获取二级分类
          getSubCategories(firstCategories[i].categoryId).then((res) => {
            // 二级分类赋值
            secondCategories = res.data;
            // 定义孩子
            let children = [];
            // 如果二级分类不为空，并且长度大于0，则将分类名字和Id加入到孩子列表中
            if (secondCategories != null && secondCategories.length > 0) {
              for (let j = 0; j < secondCategories.length; j++) {
                children.push({
                  label: secondCategories[j].categoryName,
                  value: secondCategories[j].categoryId,
                });
              }
            }
            // 将分类信息赋值给categoryData
            this.categoryData.push({
              label: firstCategories[i].categoryName,
              value: firstCategories[i].categoryId,
              children: children,
            });
          });
        }
      });
    },
    // 根据分类获取书架选择
    getBookShelfSelect() {
      getBookshelfByCategoryId(this.bookInfo.categoryId[1]).then((res) => {
        // 定义书架
        let shelf = res.data;
        // 刷新数据
        this.bookShelfData = [];
        // 如果不为空则遍历赋值
        if (shelf != null) {
          for (let i = 0; i < shelf.length; i++) {
            this.bookShelfData.push({
              label: shelf[i].bookshelf,
              value: shelf[i].locationId,
            });
          }
        }
      });
    },
    // 验证表格
    validateForm() {
      return this.$refs["bookInfoForm"].validate((valid) => {
        if (valid) {
          console.log(this.bookInfo);
          return this.bookInfo;
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    getBookInfo(data) {
      this.bookInfo = data;
      this.bookInfo.categoryId = [
        data.category.parentId,
        data.category.categoryId,
      ];
      this.bookInfo.locationId = data.location.locationId;
      this.bookInfo.price = data.price.toString();
      this.getBookShelfSelect();
    },
    // 处理分类选择框
    handleChange() {
      this.bookInfo.locationId = null;
      this.getBookShelfSelect();
    },
  },
};
</script>

<style scoped></style>
