import { createRouter, createWebHistory } from 'vue-router';
import ToAddStu from '../components/ToAddStu.vue'; // Login component
import ListStu from '../components/ListStu.vue'; // Registration component
import SendNotification from '../components/SendNotification.vue'; // Registration component
import filter from '../components/filter.vue'; // Registration component
const routes = [
    { path: '/AddStu', name: 'ToAddStu', component: ToAddStu },
    { path: '/List', name: 'ListStu', component: ListStu },
    { path: '/Notification', name: 'Notification', component: SendNotification },
    { path: '/Filter', name: 'Filter', component: filter}
  ];
  
  const router = createRouter({
    history: createWebHistory(),
    routes,
  });
 
  export default router;