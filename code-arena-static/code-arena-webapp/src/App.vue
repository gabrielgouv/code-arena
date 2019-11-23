<template>
  <div id="app">
    <vs-row>
      <vs-col vs-w="12">
        <Header/>
      </vs-col>
    </vs-row>

    <vs-row>
      <vs-col vs-w="2">
        <Menu/>
      </vs-col>
      <vs-col vs-w="10">
        <Content/>
      </vs-col>
    </vs-row>

  </div>
</template>

<script>
import Header from './components/template/Header'
import Menu from './components/template/Menu'
import Content from './components/template/Content'

export default {
  name: 'App',
  components: {
    Header,
    Menu,
    Content
  }
}
</script>

<style>
#app {
  font-family: 'Open Sans', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  height: 100%;
}

</style>
