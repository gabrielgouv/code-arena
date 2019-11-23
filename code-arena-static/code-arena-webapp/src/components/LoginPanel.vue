<template>
  <div class="login">
    <vs-row vs-justify="center">
        <vs-col type="flex" vs-justify="center" vs-align="center" vs-w="6">
            <vs-card>
            <div slot="header">
                <h3>
                Log into your account
                </h3>
            </div>
            <div vs-justify="center">
                <vs-input class="form-input" label-placeholder="E-mail" v-model="form.email"/>
                <vs-input class="form-input" type="password" label-placeholder="Password" v-model="form.password"/>
            </div>
            <div>
                <vs-button color="primary" type="flat">Create an account</vs-button>
                <vs-button color="primary" type="filled">Log in</vs-button>
            </div>
            </vs-card>
        </vs-col>
    </vs-row>
  </div>
</template>

<script>
export default {
  name: 'login',
  data() {
      return {
          form: {
              email: '',
              password: ''
          }
      }
  }
}
</script>

<style scoped>
.form-input {
    width: 100%;
    margin-bottom: 30px;
}
</style>