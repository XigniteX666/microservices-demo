<template>
  <div class="home">
    <TestComponent />
  </div>
</template>

<script>
// @ is an alias to /src
import TestComponent from "@/components/TestComponent";

export default {
  name: "home",
  components: {
    TestComponent
  }
};
</script>
