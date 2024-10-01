
<template>

    <v-data-table
        :headers="headers"
        :items="salesStatus"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'SalesStatusView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "orderId", value: "orderId" },
                { text: "productId", value: "productId" },
                { text: "customerGender", value: "customerGender" },
                { text: "customerRegion", value: "customerRegion" },
                { text: "insurance", value: "insurance" },
                { text: "manufacturer", value: "manufacturer" },
                { text: "phoneColor", value: "phoneColor" },
            ],
            salesStatus : [],
        }),
        async created() {
            var me = this;
            setInterval(function(){me.load()}, 1000);
        },
        methods: {
            async load() {
                var temp = await axios.get(axios.fixUrl('/salesStatuses'))

                temp.data._embedded.salesStatuses.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

                this.salesStatus = temp.data._embedded.salesStatuses;
            }
        }
    }
</script>

