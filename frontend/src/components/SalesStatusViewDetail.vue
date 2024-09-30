<template>

    <v-card outlined>
        <v-card-title>
            SalesStatus # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="OrderId" v-model="item.orderId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Count" v-model="item.count" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ProductId" v-model="item.productId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="CustomerGender" v-model="item.customerGender" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CustomerRegion" v-model="item.customerRegion" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="Insurance" v-model="item.insurance" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Manufacturer" v-model="item.manufacturer" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PhoneColor" v-model="item.phoneColor" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'SalesStatusViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/salesStatuses/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

