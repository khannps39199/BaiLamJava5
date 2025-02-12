<template>
    <div v-if="loading">Loading...</div>
    <ReusableTable
      v-if="!loading && categoryColumns.length > 0"
      title="Category List"
      :data="categories"
      :columns="categoryColumns"
    />
    <ReusableTable
      v-if="!loading && categoryColumns.length > 0"
      title="Product List"
      :data="products"
      :columns="productColumns"
    />
  
</template>
<script setup >

import ReusableTable from "./components/ReusableCompoment/reusetable.vue";

</script>
<script>

export default {
  data() {
    return {
      categories: [],
      categoryColumns: [],
      loading: true,
      products: [],
      productColumns: [],
      loadingPro: true,
    };
  },
  methods: {
    async fetchCategories() {
      try {
        const response = await fetch("http://localhost:8080/tempgetcategory");
        const data = await response.json();
        this.categories = data;

        if (data.length > 0) {
          this.categoryColumns = Object.keys(data[0]).map((key) => ({
            key,
            label: this.formatLabel(key), // Calls formatLabel
          }));
        }
      } catch (error) {
        console.error("Error fetching categories:", error);
      } finally {
        this.loading = false;
      }
    },
    formatLabel(key) {
      // Convert keys like "category_name" to "Category Name"
      return key
        .replace(/_/g, " ")
        .replace(/\b\w/g, (char) => char.toUpperCase());
    },
    async fetchProducts() {
      try {
        const response = await fetch("http://localhost:8080/api/getProducts");
        const dataPro = await response.json();
        this.products = dataPro;

        if (dataPro.length > 0) {
          this.productColumns = Object.keys(dataPro[0]).map((key) => ({
            key,
            label: this.formatLabel(key), // Calls formatLabel
          }));
        }
      } catch (error) {
        console.error("Error fetching categories:", error);
      } finally {
        this.loadingPro = false;
      }
    },
    formatLabel(key) {
      // Convert keys like "category_name" to "Category Name"
      return key
        .replace(/_/g, " ")
        .replace(/\b\w/g, (char) => char.toUpperCase());
    },
  },

    created() {
      this.fetchCategories();this.fetchProducts();
    },
};
</script>