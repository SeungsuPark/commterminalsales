

<template>
    <v-app id="inspire">
        <div>
            <v-app-bar color="primary" app clipped-left flat>
                <v-toolbar-title>
                    <span class="second-word"
                        style="font-weight:700;"
                    >
                        <v-app-bar-nav-icon
                            @click="openSideBar()"
                            style="z-index:1;
                            width:30px;
                            height: 30px;
                            margin-right:10px;
                            margin-top: -4px;
                            font-weight:300;
                            font-size:33px;"
                        >
                            <div style="line-height:100%; color:#fff">≡</div>
                        </v-app-bar-nav-icon>
                    </span>
                </v-toolbar-title>
                <!-- <span v-if="urlPath!=null" 
                    class="mdi mdi-home" 
                    key="" 
                    to="/" 
                    @click="goHome()"
                    style="margin-left:10px; font-size:20px; cursor:pointer;"
		        ></span> 
                <v-spacer></v-spacer> -->

            </v-app-bar>

            <v-navigation-drawer app clipped flat v-model="sideBar">
                <v-lis style="padding: 0px;">
                    <v-list-item
                        class="px-5"
                        key="home"
                        to="/"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;border-bottom: 1px #ddd solid;"
                    >
                        Home
                    </v-list-item>
                    <v-list-item
                        class="px-5"
                        key="specComparations"
                        to="/specs/specComparations"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;border-bottom: 1px #ddd solid;"
                    >
                        단말기 스펙 비교
                    </v-list-item>

                    <v-list-item
                        class="px-5"
                        key="specs"
                        to="/specs/specs"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;border-bottom: 1px #ddd solid;"
                    >
                        단말기스펙
                    </v-list-item>


                    <v-list-item
                        class="px-5"
                        key="orders"
                        to="/orders/orders"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;border-bottom: 1px #ddd solid;"
                    >
                        Order
                    </v-list-item>


                    <v-list-item
                        class="px-5"
                        key="retargettings"
                        to="/marketings/retargettings"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;border-bottom: 1px #ddd solid;"
                    >
                        Retargetting
                    </v-list-item>


                    <v-list-item
                        class="px-5"
                        key="insuranceSubscriptions"
                        to="/insurances/insuranceSubscriptions"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;border-bottom: 1px #ddd solid;"
                    >
                        InsuranceSubscription
                    </v-list-item>


                    <v-list-item
                        class="px-5"
                        key="payments"
                        to="/payments/payments"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;border-bottom: 1px #ddd solid;"
                    >
                        Payment
                    </v-list-item>



                    <v-list-item
                        class="px-5"
                        key="customers"
                        to="/customers/customers"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;border-bottom: 1px #ddd solid;"
                    >
                        Customer
                    </v-list-item>

                    <v-list-item
                        class="px-5"
                        key="messages"
                        to="/customers/messages"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;border-bottom: 1px #ddd solid;"
                    >
                        Message
                    </v-list-item>


                </v-lis>
            </v-navigation-drawer>
        </div>

        <v-main>
            <v-container style="padding:20px;" v-if="urlPath" fluid>
                <router-view></router-view>
            </v-container>
            <v-container style="padding:20px;" v-else fluid>
                <div style="width:100%; margin:0px 0px 0px 0px; position: relative;">
                    
                    <div class="App-main-text-overlap"></div>
                    <div class="App-sub-text-overlap"></div>
                </div>
                <v-row>
                    <v-col cols="4" class="d-flex justify-center" v-for="(aggregate, index) in aggregate" :key="index">
                        <div 
                            class="flip-card"
                            @mouseover="flipCard(index)"
                            @mouseleave="unflipCard(index)"
                            :class="{ 'is-flipped': flipped[index] }"
                            
                        >
                            <div class="flip-card-inner">
                                <div class="flip-card-front" style="width:100%">
                                    <v-card
                                        class="mx-auto"
                                        style="width:100%; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                        outlined
                                    >
                                        <v-list-item style="padding:15px; margin:0px;">
                                            <v-img style="width:100%; height:120px; border-radius: 10px;" :src="aggregate.ImageUrl"></v-img>
                                        </v-list-item>
                                        <div style="text-align: center; padding:10px 15px 15px 15px; margin-top:-10px;">
                                            <h2>{{ aggregate.title }}</h2>
                                            <div>{{ aggregate.description }}</div>
                                        </div>
                                    </v-card>
                                </div>
                                <div class="flip-card-back"  style="width:100%">
                                    <v-card
                                        color="primary"
                                        class="mx-auto"
                                        style="width:auto; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                        outlined
                                        :key="aggregate.key"
                                        :to="aggregate.route"
                                        @click="changeUrl()"
                                    >
                                        <v-list-item style="padding:15px; margin:0px;">
                                            <v-img style="width:100%; height:120px; border-radius: 10px;" :src="aggregate.ImageUrl"></v-img>
                                        </v-list-item>
                                        <h2 style="color:white;">{{ aggregate.title }} 관리</h2>
                                    </v-card>
                                </div>
                            </div>
                        </div>
                    </v-col>
                </v-row>
            </v-container>
        </v-main>
    </v-app>
</template>

<script>

export default {
    name: "App",
    data: () => ({
        useComponent: "",
        drawer: true,
        components: [],
        sideBar: true,
        urlPath: null,
        flipped: [],
        ImageUrl: '',
        aggregate: [
            { 
                title: '단말기 스펙 비교', 
                description: '', 
                key: 'specComparations', 
                route: '/specs/specComparations',
                ImageUrl: '',
            },
            { 
                title: '단말기스펙', 
                description: '', 
                key: 'specs', 
                route: '/specs/specs',
                ImageUrl: '',
            },
            { 
                title: 'Order', 
                description: '', 
                key: 'orders', 
                route: '/orders/orders',
                ImageUrl: '',
            },
            { 
                title: 'Retargetting', 
                description: '', 
                key: 'retargettings', 
                route: '/marketings/retargettings',
                ImageUrl: '',
            },
            { 
                title: 'InsuranceSubscription', 
                description: '', 
                key: 'insuranceSubscriptions', 
                route: '/insurances/insuranceSubscriptions',
                ImageUrl: '',
            },
            { 
                title: 'Payment', 
                description: '', 
                key: 'payments', 
                route: '/payments/payments',
                ImageUrl: '',
            },
            { 
                title: 'Customer', 
                description: '', 
                key: 'customers', 
                route: '/customers/customers',
                ImageUrl: '',
            },
            { 
                title: 'Message', 
                description: '', 
                key: 'messages', 
                route: '/customers/messages',
                ImageUrl: '',
            },
            
        ],
    }),
    
    async created() {
      var path = document.location.href.split("#/")
      this.urlPath = path[1];

    },
    watch: {
        cards(newCards) {
            this.flipped = new Array(newCards.length).fill(false);
        },
    },

    mounted() {
        var me = this;
        me.components = this.$ManagerLists;
    },

    methods: {
        openSideBar(){
            this.sideBar = !this.sideBar
        },
        changeUrl() {
            var path = document.location.href.split("#/")
            this.urlPath = path[1];
            this.flipped.fill(false);
        },
        goHome() {
            this.urlPath = null;
        },
        flipCard(index) {
            this.$set(this.flipped, index, true);
        },
        unflipCard(index) {
            this.$set(this.flipped, index, false);
        },
    }
};
</script>
<style>
</style>
