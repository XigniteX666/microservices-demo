<template>
  <div>
    Customers
    <ul>
      <li v-for="customer in this.$store.getters.customers" :key="customer.id">
        {{ customer.id }} - {{ customer.firstName }} - {{ customer.lastName }}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from "axios";
export default {
  mounted() {
    axios
      .get("http://localhost:8080/customer/all")
      .then(response => this.$store.commit("change", response.data));
  }
};
</script>

<style></style>
