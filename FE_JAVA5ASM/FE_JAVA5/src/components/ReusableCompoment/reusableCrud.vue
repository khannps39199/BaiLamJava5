<template>
    <div>
      <h1>{{ title }}</h1>
  
      <!-- Form -->
      <form @submit.prevent="saveItem">
        <div v-for="field in fields" :key="field.key">
          <label :for="field.key">{{ field.label }}:</label>
          <input
            v-if="field.type === 'text'"
            :id="field.key"
            v-model="formData[field.key]"
            :type="field.type"
          />
          <input
            v-if="field.type === 'number'"
            :id="field.key"
            v-model.number="formData[field.key]"
            :type="field.type"
          />
          <!-- Add other field types as needed -->
        </div>
        <button type="submit">{{ isEditing ? 'Update' : 'Create' }}</button>
      </form>
  
      <hr />
  
      <!-- List of Items -->
      <ul>
        <li v-for="item in items" :key="item[primaryKey]">
          {{ formatItem(item) }}
          <button @click="editItem(item)">Edit</button>
          <button @click="deleteItem(item[primaryKey])">Delete</button>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  import apiService  from "../../Javascript/abstractAxios.js";


  
  export default {  
    props: {
      title: { type: String, required: true },
      resource: { type: String, required: true },
      fields: { type: Array, required: true }, // [{ key: 'name', label: 'Name', type: 'text' }]
      primaryKey: { type: String, default: "id" },
    },
    data() {
      return {
        items: [],
        formData: {},
        isEditing: false,
      };
    },
    methods: {
      // Fetch all items
      fetchItems() {
        apiService.getAll(this.resource).then((response) => {
          this.items = response.data;
        });
      },
  
      // Save or Update an item
      saveItem() {
        if (this.isEditing) {
          apiService.update(this.resource, this.formData[this.primaryKey], this.formData).then(() => {
            this.resetForm();
            this.fetchItems();
          });
        } else {
          apiService.create(this.resource, this.formData).then(() => {
            this.resetForm();
            this.fetchItems();
          });
        }
      },
  
      // Edit an item
      editItem(item) {
        this.formData = { ...item };
        this.isEditing = true;
      },
  
      // Delete an item
      deleteItem(id) {
        apiService.delete(this.resource, id).then(() => {
          this.fetchItems();
        });
      },
  
      // Reset form
      resetForm() {
        this.formData = {};
        this.isEditing = false;
      },
  
      // Format item for display
      formatItem(item) {
        return this.fields
          .map((field) => `${field.label}: ${item[field.key]}`)
          .join(", ");
      },
    },
    mounted() {
      this.fetchItems();
    },
  };
  </script>
  