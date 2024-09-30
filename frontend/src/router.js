
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import SpecSpecComparationManager from "./components/listers/SpecSpecComparationCards"
import SpecSpecComparationDetail from "./components/listers/SpecSpecComparationDetail"

import OrderOrderManager from "./components/listers/OrderOrderCards"
import OrderOrderDetail from "./components/listers/OrderOrderDetail"

import MarketingRetargettingManager from "./components/listers/MarketingRetargettingCards"
import MarketingRetargettingDetail from "./components/listers/MarketingRetargettingDetail"

import InsuranceInsuranceSubscriptionManager from "./components/listers/InsuranceInsuranceSubscriptionCards"
import InsuranceInsuranceSubscriptionDetail from "./components/listers/InsuranceInsuranceSubscriptionDetail"

import PaymentPaymentManager from "./components/listers/PaymentPaymentCards"
import PaymentPaymentDetail from "./components/listers/PaymentPaymentDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/specs/specComparations',
                name: 'SpecSpecComparationManager',
                component: SpecSpecComparationManager
            },
            {
                path: '/specs/specComparations/:id',
                name: 'SpecSpecComparationDetail',
                component: SpecSpecComparationDetail
            },

            {
                path: '/orders/orders',
                name: 'OrderOrderManager',
                component: OrderOrderManager
            },
            {
                path: '/orders/orders/:id',
                name: 'OrderOrderDetail',
                component: OrderOrderDetail
            },

            {
                path: '/marketings/retargettings',
                name: 'MarketingRetargettingManager',
                component: MarketingRetargettingManager
            },
            {
                path: '/marketings/retargettings/:id',
                name: 'MarketingRetargettingDetail',
                component: MarketingRetargettingDetail
            },

            {
                path: '/insurances/insuranceSubscriptions',
                name: 'InsuranceInsuranceSubscriptionManager',
                component: InsuranceInsuranceSubscriptionManager
            },
            {
                path: '/insurances/insuranceSubscriptions/:id',
                name: 'InsuranceInsuranceSubscriptionDetail',
                component: InsuranceInsuranceSubscriptionDetail
            },

            {
                path: '/payments/payments',
                name: 'PaymentPaymentManager',
                component: PaymentPaymentManager
            },
            {
                path: '/payments/payments/:id',
                name: 'PaymentPaymentDetail',
                component: PaymentPaymentDetail
            },



    ]
})
