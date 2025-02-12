<template>
    <div>
      <h2>{{ title }}</h2>
      <table border="1" cellpadding="8" cellspacing="0">
        <thead>
          <tr>
            <th v-for="column in columns" :key="column.key">
              {{ column.label }}
            </th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(item, index) in data" :key="index">
            <td v-for="column in columns" :key="column.key">
              {{ item[column.key] }}
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </template>
  
  <script>
  export default {
    name: "ReusableTable",
    props: {
      title: {
        type: String,
        default: "Table",
      },
      data: {
        type: Array,
        required: true,
      },
      columns: {
        type: Array,
        required: true,
      },
    },
  };
  </script>
  
  <style scoped>
  table {
    width: 100%;
    border-collapse: collapse;
  }
  
  th, td {
    text-align: left;
    padding: 8px;
  }
  
  th {
    background-color: #f4f4f4;
  }
  </style>
  