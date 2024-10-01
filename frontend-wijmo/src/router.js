
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import SpecComparationManager from "./components/ui/SpecComparationGrid"
import SpecManager from "./components/ui/SpecGrid"

import OrderManager from "./components/ui/OrderGrid"

import RetargettingManager from "./components/ui/RetargettingGrid"

import InsuranceSubscriptionManager from "./components/ui/InsuranceSubscriptionGrid"

import PaymentManager from "./components/ui/PaymentGrid"


import SalesStatusView from "./components/SalesStatusView"
import CustomerManager from "./components/ui/CustomerGrid"
import MessageManager from "./components/ui/MessageGrid"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/specComparations',
                name: 'SpecComparationManager',
                component: SpecComparationManager
            },
            {
                path: '/specs',
                name: 'SpecManager',
                component: SpecManager
            },

            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },

            {
                path: '/retargettings',
                name: 'RetargettingManager',
                component: RetargettingManager
            },

            {
                path: '/insuranceSubscriptions',
                name: 'InsuranceSubscriptionManager',
                component: InsuranceSubscriptionManager
            },

            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },



            {
                path: '/salesStatuses',
                name: 'SalesStatusView',
                component: SalesStatusView
            },
            {
                path: '/customers',
                name: 'CustomerManager',
                component: CustomerManager
            },
            {
                path: '/messages',
                name: 'MessageManager',
                component: MessageManager
            },



    ]
})
