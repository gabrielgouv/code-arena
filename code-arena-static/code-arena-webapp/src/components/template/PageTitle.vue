<template>
  <div class="page-title">
    <h2 class="title">{{ title }}</h2>
    <h5 class="subtitle">{{ subtitle }}</h5>
    <vs-divider></vs-divider>
  </div>
</template>

<script>
export default {
  name: 'PageTitle',
  props: {
      title: String,
      subtitle: String
  }
}
</script>

<style scoped>
.page-title .title {
    color: #616161;
}
.page-title .subtitle {
    color: #cccccc;
}
</style>