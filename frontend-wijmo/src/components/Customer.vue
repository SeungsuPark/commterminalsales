<template>
    <div>
        <String label="Region" v-model="value.region" :editMode="editMode"/>
        <String label="Gender" v-model="value.gender" :editMode="editMode"/>

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
    name: 'Customer',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "customers"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

