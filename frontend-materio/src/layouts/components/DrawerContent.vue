<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: 'Spec' }" />
        <VerticalNavLink
            :item="{
                title: '단말기 스펙 비교',
                to: '/specComparations',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '단말기스펙',
                to: '/specs',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'Order' }" />
        <VerticalNavLink
            :item="{
                title: 'Order',
                to: '/orders',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'Marketing' }" />
        <VerticalNavLink
            :item="{
                title: 'Retargetting',
                to: '/retargettings',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'Insurance' }" />
        <VerticalNavLink
            :item="{
                title: 'InsuranceSubscription',
                to: '/insuranceSubscriptions',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'Payment' }" />
        <VerticalNavLink
            :item="{
                title: 'Payment',
                to: '/payments',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'Salesdashboard' }" />
        <VerticalNavSectionTitle :item="{ heading: 'Customer' }" />
        <VerticalNavLink
            :item="{
                title: 'Customer',
                to: '/customers',
            }"
        />
        <VerticalNavLink
            :item="{
                title: 'Message',
                to: '/messages',
            }"
        />
    </ul>
</template>
