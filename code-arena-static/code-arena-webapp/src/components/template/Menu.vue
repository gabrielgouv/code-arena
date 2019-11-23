<template>
  <div class="menu" v-if="!toggle">
    <vs-sidebar static-position default-index="1" color="primary" class="sidebarx" spacer>

      <div class="header-sidebar" slot="header">
        <vs-avatar  size="70px" src="https://randomuser.me/api/portraits/men/85.jpg"/>

        <h4>
          User
        </h4>

      </div>

      <vs-sidebar-item index="1" icon="dashboard">
        Dashboard
      </vs-sidebar-item>

      <vs-sidebar-item index="2" icon="favorite">
        Favorite challenges
      </vs-sidebar-item>

      <vs-sidebar-item index="3" icon="check">
        Resolved challenges
      </vs-sidebar-item>

      <vs-sidebar-item index="4" icon="send">
        Submit a new challenge
      </vs-sidebar-item>

      <vs-divider icon="person" position="left">
        User
      </vs-divider>

      <vs-sidebar-item index="5" icon="verified_user">
        Configurations
      </vs-sidebar-item>
      <vs-sidebar-item index="6" icon="account_box">
        Profile
      </vs-sidebar-item>
      <vs-sidebar-item index="7" >
        Card
      </vs-sidebar-item>

      <div class="footer-sidebar" slot="footer">
        <vs-button icon="reply" color="danger" type="flat">log out</vs-button>
        <vs-button icon="settings" color="primary" type="border"></vs-button>
      </div>

    </vs-sidebar>
  </div>
</template>

<script>
export default {
  name: 'Menu',
  props: {
      toggle: Boolean
  }
}
</script>

<style>
.parentx-static {
  overflow: hidden;
  height: 500px;
  position: relative;
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

</style>
