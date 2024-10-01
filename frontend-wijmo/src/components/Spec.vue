<template>
    <div>
        <String label="Spec" v-model="value.spec" :editMode="editMode"/>
        <String label="PhoneColor" v-model="value.phoneColor" :editMode="editMode"/>
        <String label="PhoneType" v-model="value.phoneType" :editMode="editMode"/>
        <Photo offline label="Image" v-model="value.image" :editMode="editMode" @change="change"/>
        <Manufacturer offline label="Manufacturer" v-model="value.manufacturer" :editMode="editMode" @change="change"/>

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
    name: 'Spec',
    mixins:[BaseEntity],
    components:{
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

