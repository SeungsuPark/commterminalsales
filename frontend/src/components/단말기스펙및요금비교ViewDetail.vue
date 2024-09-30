<template>

    <v-card outlined>
        <v-card-title>
            단말기스펙및요금비교 # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: '단말기스펙및요금비교ViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/단말기스펙및요금비교/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

