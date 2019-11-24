<template>
  <div class="header" v-if="!toggle">
    <vs-navbar class="nabarx large" color="#1F74FF">
      <div slot="title">
        <vs-navbar-title>
          <span class="title">Code Arena</span>
        </vs-navbar-title>
      </div>
    </vs-navbar>
  </div>
</template>

<script>
export default {
  name: 'Header',
  props: {
      toggle: Boolean
  }
}
</script>

<style scoped>
.large {
  height: 45px !important;
}
.title {
    color: #ffffff;
    font-weight: 400;
    font-size: 20pt;
}
</style>
