<template>
  <div class="login">
    <b-row class="justify-content-md-center">
        <b-col col md="4">
            <b-card title="Login" sub-title="Log into your account">
                <div>
                    <b-form >
                        <div class="text-left">
                        <b-form-group
                            id="input-group-email"
                            label="Email address:"
                            label-for="input-email"
                        >
                            <b-form-input
                                id="input-email"
                                type="email"
                                v-model="form.email"
                                required
                            ></b-form-input>
                        </b-form-group>
                        <b-form-group
                            id="input-group-password"
                            label="Password:"
                            label-for="input-password"
                        >
                            <b-form-input
                                id="input-password"
                                type="password"
                                v-model="form.password"
                                required
                            ></b-form-input>
                        </b-form-group>
                    </div>
                    <div>
                        <b-button class="text-right" type="submit" variant="primary">Log in</b-button>
                    </div> 
                    </b-form>
                    <!-- <b-card class="mt-3" header="Form Data Result">
                    <pre class="m-0">{{ form }}</pre>
                    </b-card> -->
                </div>

            </b-card>
        </b-col>
        
    </b-row>
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