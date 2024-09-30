<template>

    <v-data-table
        :headers="headers"
        :items="getSpecDetail"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'GetSpecDetailView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            getSpecDetail : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/getSpecDetails'))

            temp.data._embedded.getSpecDetails.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.getSpecDetail = temp.data._embedded.getSpecDetails;
        },
        methods: {
        }
    }
</script>

