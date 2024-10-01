<template>
  <v-container fluid>
    <v-row>
      <v-card
          v-for="(card, index) in cards"
          :key="index"
          class="mx-auto"
          style="height:300px; width:300px; margin-bottom:20px;"
          outlined
      >
        <v-list-item>
          <v-icon style="margin-top: 30%; margin-left: 37.5%;" color="primary" size="64">mdi-apps</v-icon>
        </v-list-item>
        <v-card-actions>
          <v-btn
              class="mx-auto"
              outlined
              rounded
              :to="card.link"
              style="font-weight:500; font-size:20px; border:solid 2px; max-width:250px; overflow:hidden; margin-top: 10%;"
          >
              {{ card.text }}
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Index',
  data: () => ({
    cards: [
      {
          text: "단말기 스펙 비교",
          link: "/specComparations",
      },
      {
          text: "단말기스펙",
          link: "/specs",
      },
      {
          text: "Order",
          link: "/orders",
      },
      {
          text: "Retargetting",
          link: "/retargettings",
      },
      {
          text: "InsuranceSubscription",
          link: "/insuranceSubscriptions",
      },
      {
          text: "Payment",
          link: "/payments",
      },
      {
          text: "Customer",
          link: "/customers",
      },
      {
          text: "Message",
          link: "/messages",
      },
    ],
  }),
};
</script>
