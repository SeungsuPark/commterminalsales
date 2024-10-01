import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/specComparations',
      component: () => import('../components/ui/SpecComparationGrid.vue'),
    },
    {
      path: '/orders',
      component: () => import('../components/ui/OrderGrid.vue'),
    },
    {
      path: '/retargettings',
      component: () => import('../components/ui/RetargettingGrid.vue'),
    },
    {
      path: '/insuranceSubscriptions',
      component: () => import('../components/ui/InsuranceSubscriptionGrid.vue'),
    },
    {
      path: '/payments',
      component: () => import('../components/ui/PaymentGrid.vue'),
    },
    {
      path: '/salesStatuses',
      component: () => import('../components/SalesStatusView.vue'),
    },
    {
      path: '/customers',
      component: () => import('../components/ui/CustomerGrid.vue'),
    },
    {
      path: '/messages',
      component: () => import('../components/ui/MessageGrid.vue'),
    },
  ],
})

export default router;
