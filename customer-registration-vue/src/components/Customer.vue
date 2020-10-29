<template>
  <div>
    <div>Firstname: <input v-model="firstName" /></div>
    <div>LastName: <input v-model="lastName" /></div>
    <div>Age: <input v-model="age" /></div>
    <button v-on:click="submitCustomer">Submit</button>
    <div>{{ error }}</div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data: function() {
    return {
      firstName: "",
      lastName: "",
      age: "",
      error: ""
    };
  },
  methods: {
    submitCustomer: function() {
      axios
        .post("http://localhost:8080/customer", {
          firstName: this.firstName,
          lastName: this.lastName,
          age: this.age
        })
        .then(() => {
          this.updateCustomerStore();
        })
        .catch(error => {
          this.error = error;
        });
    },
    updateCustomerStore: function() {
      axios
        .get("http://localhost:8080/customer/all")
        .then(response => this.$store.commit("change", response.data))
        .catch(error => console.log(error));
    }
  }
};
</script>

<style></style>
