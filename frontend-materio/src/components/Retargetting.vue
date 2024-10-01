<template>
    <div>
        <String label="CustomerId" v-model="value.customerId" :editMode="editMode"/>
        <String label="ProductId" v-model="value.productId" :editMode="editMode"/>
        <Number label="ReturnCount" v-model="value.returnCount" :editMode="editMode"/>

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

import BaseEntity from './base-ui/BaseEntity.vue'
import String from './primitives/String.vue'
import Number from './primitives/Number.vue'

export default {
    name: 'Retargetting',
    mixins:[BaseEntity],
    components:{
        String,
        Number,
    },
    
    data: () => ({
        path: "retargettings"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
