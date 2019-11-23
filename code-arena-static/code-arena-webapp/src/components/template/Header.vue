<template>
  <div class="header">
    <vs-navbar class="nabarx" color="#1F74FF">
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
  name: 'Header'
}
</script>

<style scoped>
.title {
    color: #ffffff;
    font-weight: 400;
    font-size: 20pt;
}
</style>
