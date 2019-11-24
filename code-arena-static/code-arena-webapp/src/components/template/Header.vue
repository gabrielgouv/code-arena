<template>
  <div class="header" v-if="!toggle">
    <vs-navbar class="nabarx large">
      <!-- <div slot="title">
        <vs-navbar-title>
          <span class="title">Code Arena</span>
        </vs-navbar-title>
      </div> -->
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
  height: 20px !important;
  background: #640064 !important;
  background-image: linear-gradient(30deg,rgba(var(--vs-primary),1),rgba(var(--vs-primary),.5)) !important;
}
.title {
    color: #ffffff;
    font-weight: 400;
    font-size: 19pt;
}
</style>
