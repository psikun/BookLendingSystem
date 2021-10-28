<template>
  <el-card shadow="always">添加书籍</el-card>
  <div class="add-form">
    <el-card shadow="always" style="display: flex; justify-content: center">
      <el-form ref="form" label-width="80px" label-position="left">
        <el-form-item label="书籍名称">
          <el-input
            placeholder="请输入书籍名称"
            style="width: 300px"
          ></el-input>
        </el-form-item>
        <el-form-item label="作者">
          <el-input placeholder="请输入作者" style="width: 300px"></el-input>
        </el-form-item>
        <el-form-item label="出版社">
          <el-input placeholder="请输入出版社" style="width: 300px"></el-input>
        </el-form-item>
        <el-form-item label="ISBN号码">
          <el-input
            placeholder="请输入ISBN号码"
            style="width: 300px"
          ></el-input>
        </el-form-item>
        <el-form-item label="分类">
          <el-cascader
            v-model="categoryId"
            :options="categoryData"
            @change="handleChange"
            style="width: 300px"
          ></el-cascader>
        </el-form-item>
        <el-form-item label="书架编号">
          <el-select v-model="shelfId" placeholder="Select">
            <el-option
              v-for="item in bookShelfData"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="索书号">
          <el-input placeholder="请输入索书号" style="width: 300px"></el-input>
        </el-form-item>
        <el-form-item label="书籍描述">
          <el-input
            placeholder="请输入书籍描述"
            style="width: 500px"
            type="textarea"
          ></el-input>
        </el-form-item>
        <el-button type="danger" @click="dialogVisible = true"
          >取消添加
        </el-button>
        <el-button type="primary">确认添加</el-button>
        <el-dialog
          v-model="dialogVisible"
          title="确定取消吗？"
          width="30%"
          :before-close="handleClose"
        >
          <span>这将会丢失所有数据</span>
          <template #footer>
            <span class="dialog-footer">
              <el-button @click="dialogVisible = false">继续添加</el-button>
              <el-button type="primary" @click="dialogVisible = false"
                >确认取消</el-button
              >
            </span>
          </template>
        </el-dialog>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import { getLevelCategories, getSubCategories } from "@/api/category";
import { getBookshelfByCategoryId } from "@/api/location";

export default {
  name: "BookAdd",
  created() {
    // 调用函数获取分类信息
    this.getCategories();
  },
  data() {
    return {
      categoryId: [0, 0],
      shelfId: null,
      dialogVisible: false,
      categoryData: [],
      bookShelfData: [],
      parentId: 0,
    };
  },
  methods: {
    // 获取分类信息
    getCategories() {
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
    // 根据分类获取书架信息
    getBookShelf() {
      getBookshelfByCategoryId(this.categoryId[1]).then((res) => {
        // 定义书架
        let shelf = res.data;
        // 刷新数据
        this.bookShelfData = [];
        this.shelfId = null;
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
    // 处理分类选择框
    handleChange() {
      this.getBookShelf();
    },
    handleClose() {},
  },
};
</script>

<style scoped>
.add-form {
  padding-top: 30px;
  padding-left: 200px;
  padding-right: 200px;
}
</style>
