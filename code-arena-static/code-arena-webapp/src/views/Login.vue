<template>
  <div class="login-view">
      <LoginPanel></LoginPanel>
  </div>
</template>

<script>
import LoginPanel from "@/components/LoginPanel.vue";

export default { 
  name: 'login-view',
  components: {
    LoginPanel
  }
}
</script>
