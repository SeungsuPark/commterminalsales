<template>
    <div>
        <String label="Spec" v-model="value.spec" :editMode="editMode"/>
        <String label="Manufacturer" v-model="value.manufacturer" :editMode="editMode"/>
        <String label="PhoneColor" v-model="value.phoneColor" :editMode="editMode"/>
        <String label="PhoneType" v-model="value.phoneType" :editMode="editMode"/>

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

export default {
    name: 'Spec',
    mixins:[BaseEntity],
    components:{
        String,
    },
    
    data: () => ({
        path: "specs"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
