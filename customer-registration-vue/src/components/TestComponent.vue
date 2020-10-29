<template>
  <div>
    <div>counter: {{ counter }}</div>
    <div>result: {{ result }}</div>
    <div>lopen: {{ run }}</div>
    <button v-on:click="submitCustomer">CallService!</button>
  </div>
</template>
<script>
import axios from "axios";
export default {
  data: function() {
    return {
      counter: 0,
      run: true,
      result: ""
    };
  },
  methods: {
    submitCustomer: function() {
      console.log("test");
      for (let index = 0; index < 1000; index++) {
        this.callService();
      }
    },
    callService: function() {
      axios.get("http://localhost:8080/service2/greeting");
      this.counter++;
    }
  }
};
</script>
