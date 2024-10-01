<template>
    <div>
        <String label="Product" v-model="value.product" :editMode="editMode"/>
        <String label="CustomerId" v-model="value.customerId" :editMode="editMode"/>
        <String label="PaymentMethod" v-model="value.paymentMethod" :editMode="editMode"/>
        <BigDecimal offline label="Amount" v-model="value.amount" :editMode="editMode" @change="change"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>

import BaseEntity from './base-ui/BaseEntity'

export default {
    name: 'Payment',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "payments"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

