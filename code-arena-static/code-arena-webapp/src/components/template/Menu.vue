<template>
  <div class="menu" v-if="!toggle">
    <vs-sidebar static-position default-index="1" color="primary" class="sidebarx" spacer>
      <div class="header-sidebar" slot="header">
        <br/>
        <v-gravatar :email="user.email" />
        <br/>
        <h4>
          {{ user.name }}
        </h4>
      </div>

      <vs-sidebar-item index="1" icon="dashboard">
        <router-link class="menu-link" to="/dashboard">Dashboard</router-link>
      </vs-sidebar-item>

      <vs-sidebar-item index="2" icon="list_alt">
        <router-link class="menu-link" to="/challenges">Challenges</router-link>
      </vs-sidebar-item>

      <vs-sidebar-item index="3" icon="favorite">
        <router-link class="menu-link" to="/challenges/favorites">Favorite challenges</router-link>
      </vs-sidebar-item>

      <vs-sidebar-item index="4" icon="check">
        <router-link class="menu-link" to="/challenges/solved">Solved challenges</router-link>
      </vs-sidebar-item>

      <vs-sidebar-item index="5" icon="send">
        <router-link class="menu-link" to="/challenges/create">Create a challenge</router-link>
      </vs-sidebar-item>

      <vs-divider icon="person" position="left">
        User
      </vs-divider>

      <vs-sidebar-item index="6" icon="verified_user">
        <router-link class="menu-link" to="/user/configuration">Configurations</router-link>
      </vs-sidebar-item>
      <vs-sidebar-item index="7" icon="account_box">
        <router-link class="menu-link" to="/user/profile">Profile</router-link>
      </vs-sidebar-item>

      <vs-divider icon="warning" position="left">
        Administration
      </vs-divider>

      <vs-sidebar-item index="8" icon="build">
        <router-link class="menu-link" to="/admin">Administration</router-link>
      </vs-sidebar-item>

      <div class="footer-sidebar" slot="footer">
        <vs-button icon="reply" color="danger" type="flat">log out</vs-button>
        <vs-button icon="settings" color="primary" type="border"></vs-button>
      </div>

    </vs-sidebar>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'Menu',
  props: {
      toggle: Boolean
  },
  computed: mapState(['user'])
}
</script>

<style>
.parentx-static {
  overflow: hidden;
  height: 500px;
  position: fixed;
}
.header-sidebar {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  width: 100%;
}
.header-sidebar h4 {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
}
.header-sidebar h4 > button {
  margin-left: 10px;
}
.footer-sidebar {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
}
.footer-sidebar > button {
  border: 0px solid rgba(0,0,0,0) !important;
  border-left: 1px solid rgba(0,0,0,0.07) !important;
  border-radius: 0px !important;
}
.sidebarx {
    height: calc(100vh - 38px);
}
.vs-sidebar--background {
    width: 0 !important;
    height: 0 !important;
}

.vs-sidebar--item a {
  padding: 5px !important;
  margin-left: 10px !important;
}
.menu-link {
  font-size: 12pt !important;
}
</style>
