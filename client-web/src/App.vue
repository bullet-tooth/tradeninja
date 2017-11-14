<template>
  <v-app>
    <navigation></navigation>

    <router-view></router-view>

    <v-footer fixed app>
      <span>Trade Ninja &copy; 2017</span>
    </v-footer>
  </v-app>
</template>

<script>
  import Navigation from '@/components/Navigation.vue'
  export default {
    components: {Navigation},
    data () {
      return {
        title: 'Trade ninja'
      }
    }
  }
</script>
