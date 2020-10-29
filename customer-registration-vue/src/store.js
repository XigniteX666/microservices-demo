import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    customers: ""
  },
  mutations: {
    change(state, customers) {
      state.customers = customers;
    }
  },
  getters: {
    customers: state => state.customers
  },
  actions: {}
});
