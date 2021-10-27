<template>
  <el-card class="add-form" shadow="always">
    <el-form ref="form" label-width="80px" label-position="left">
      <el-form-item label="书籍名称">
        <el-input placeholder="请输入书籍名称" style="width: 300px"></el-input>
      </el-form-item>
      <el-form-item label="作者">
        <el-input placeholder="请输入作者" style="width: 300px"></el-input>
      </el-form-item>
      <el-form-item label="出版社">
        <el-input placeholder="请输入出版社" style="width: 300px"></el-input>
      </el-form-item>
      <el-form-item label="ISBN号码">
        <el-input placeholder="请输入ISBN号码" style="width: 300px"></el-input>
      </el-form-item>
      <el-form-item label="分类">
        <el-cascader
          v-model="categoryId"
          :options="categoryData"
          @change="handleChange"
        ></el-cascader>
        <p>{{ categoryId }}</p>
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
</template>

<script>
import { getLevelCategories, getSubCategories } from "@/api/category";

export default {
  name: "BookAdd",
  created() {
    // 调用函数获取分类信息
    this.getCategories();
  },
  data() {
    return {
      categoryId: "",
      dialogVisible: false,
      categoryData: [],
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
    handleClose() {},
    handleChange() {},
  },
};
</script>

<style scoped>
.add-form {
  padding-left: 200px;
}
</style>
