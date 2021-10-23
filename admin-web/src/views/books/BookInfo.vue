<template>
  <!--  书籍信息卡片-->
  <el-card shadow="always" class="card">
    <span>书籍信息</span>
    <el-button type="primary" plain>添加书籍</el-button>
  </el-card>
  <!--书籍信息表格-->
  <div class="book-info-table">
    <el-table
      :data="tableData"
      border
      stripe
      highlight-current-row
      select-on-indeterminate
      :header-cell-style="tableClass"
      :cell-style="tableClass"
    >
      <el-table-column type="selection" label="选择" />
      <el-table-column prop="id" label="编号" sortable />
      <el-table-column prop="name" label="名称" />
      <el-table-column prop="author" label="作者" />
      <el-table-column prop="press" label="出版社" />
      <el-table-column prop="isbn" label="ISBN号码" />
      <el-table-column label="分类">
        <template v-slot="scope">
          <el-button type="text" @click="getrows(scope.row)"
            >{{ scope.row.category.categoryName }}
          </el-button>
        </template>
      </el-table-column>

      <el-table-column prop="location" label="书籍位置">
        <el-table-column prop="category.location.bookshelf" label="书架" />
        <el-table-column prop="locationNumber" label="编号" />
      </el-table-column>
      <el-table-column
        prop="description"
        label="书籍描述"
        show-overflow-tooltip
      />
      <el-table-column prop="borrowingStatus" label="书籍状态">
        <el-table-column label="借阅状态">
          <template v-slot="scope">
            <el-button
              type="success"
              size="small"
              round
              v-if="scope.row.borrowingStatus"
              >已借出
            </el-button>
            <el-button type="danger" v-else round size="small"
              >未借出
            </el-button>
          </template>
        </el-table-column>
        <el-table-column label="借阅信息">
          <template v-slot="scope">
            <el-button
              type="warning"
              size="mini"
              round
              :disabled="!scope.row.borrowingStatus"
              >借阅信息
            </el-button>
          </template>
        </el-table-column>
      </el-table-column>
      <el-table-column
        prop="operation"
        label="操作"
        @click="getrows"
        width="140"
        fixed="right"
      >
        <template v-slot="scope">
          <el-button
            type="primary"
            icon="el-icon-edit"
            circle
            @click="getrows(scope.row)"
          ></el-button>
          <el-popconfirm
            confirm-button-text="确定"
            cancel-button-text="不了，谢谢"
            icon="el-icon-info"
            icon-color="red"
            title="确定要删除吗?"
          >
            <template #reference>
              <el-button type="danger" icon="el-icon-delete" circle></el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
  </div>
  <!--  分页-->
  <div class="pagination-block">
    <el-pagination
      v-model:currentPage="currentPage"
      background
      :page-sizes="[5, 10, 15, 20]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    >
    </el-pagination>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "BookInfo",
  created() {
    this.load();
  },
  data() {
    return {
      currentPage: 1,
      total: 10,
      pageSize: 5,
      pageNum: 1,
      tableData: [],
    };
  },
  methods: {
    load() {
      // load()函数，页面加载时调用，用来加载页面数据
      request
        .get("/api/bookinfo", {
          params: {
            // 参数:当前的页码和页面大小
            pageNum: this.currentPage,
            pageSize: this.pageSize,
          },
        })
        .then((res) => {
          console.log(res);
          this.tableData = res.data;
        });
    },
    handleSizeChange(pageSize) {
      // 改变当前每页的个数触发
      this.pageSize = pageSize;
      this.load();
    },
    handleCurrentChange(pageNum) {
      // 改变当前页码触发
      this.pageNum = pageNum;
      this.load();
    },
    tableClass() {
      // 表头居中显示
      return "text-align:center";
    },
    getrows(row) {
      console.log(row);
    },
  },
};
</script>

<style scoped>
.card {
  width: 100%;
  display: flex;
  justify-content: space-between;
}

.book-info-table {
  margin: 0;
  padding-top: 10px;
  width: 100%;
}
.pagination-block {
  text-align: right;
  margin-top: 30px;
  margin-bottom: 20px;
  margin-right: 50px;
}
</style>
