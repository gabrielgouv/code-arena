import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import '@/plugins/bootstrap-vue.plugin'
import '@/plugins/vuesax.plugin'
import '@/plugins/vue-gravatar.plugin'

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
