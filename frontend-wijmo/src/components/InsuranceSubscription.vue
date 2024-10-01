<template>
    <div>
        <String label="CustomerId" v-model="value.customerId" :editMode="editMode"/>
        <String label="ProductId" v-model="value.productId" :editMode="editMode"/>
        <String label="TerminalProductId" v-model="value.terminalProductId" :editMode="editMode"/>

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
    name: 'InsuranceSubscription',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "insuranceSubscriptions"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

