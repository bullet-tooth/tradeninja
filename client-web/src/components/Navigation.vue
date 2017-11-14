<template>
  <div>
    <template v-if="logged">
      <v-navigation-drawer persistent :mini-variant="miniVariant" :clipped="clipped" v-model="drawer"
                           enable-resize-watcher clipped app>
        <v-list>
          <v-list-tile>
            <v-list-tile-content>
              <v-list-tile-title>Navigation</v-list-tile-title>
            </v-list-tile-content>
            <v-list-tile-action>
              <v-btn icon @click.stop="miniVariant = !miniVariant">
                <v-icon v-html="miniVariant ? 'chevron_right' : 'chevron_left'"></v-icon>
              </v-btn>
            </v-list-tile-action>
          </v-list-tile>

          <v-list-tile v-for="(item, i) in user_items" :key="i" router :to="item.ref">
            <v-list-tile-action>
              <v-icon v-html="item.icon"></v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title v-text="item.title"></v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
          <v-divider></v-divider>
          <div class="mb-3"></div>
          <v-list-tile v-for="(item, i) in admin_items" :key="i" router :to="item.ref">
            <v-list-tile-action>
              <v-icon v-html="item.icon"></v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title v-text="item.title"></v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
        </v-list>
      </v-navigation-drawer>
    </template>

    <!--Top toolbar-->
    <v-toolbar fixed app clipped-left>
      <v-toolbar-side-icon v-if="logged" @click.stop="drawer = !drawer"></v-toolbar-side-icon>
      <v-toolbar-title class="mx-5" v-text="title"></v-toolbar-title>
      <!--<v-spacer></v-spacer>-->
      <!--<v-text-field solo prepend-icon="search" placeholder="Search"></v-text-field>-->
      <v-btn class="mx-5" disabled icon @click="console.log('resources')">
        resources
      </v-btn>
      <v-btn class="mx-5" disabled icon @click="console.log('info')">
        info
      </v-btn>

      <v-spacer></v-spacer>
      <template v-if="!logged">
        <v-btn icon disabled>
          register
        </v-btn>
        <v-btn class="mx-5" icon @click="doLogin">
          login
        </v-btn>
      </template>
      <template v-else>
        <v-avatar >
          <v-btn icon disabled>
            <v-icon>account_box</v-icon>
          </v-btn>
        </v-avatar>
        <v-btn class="mr-3" icon @click="doLogout">
          <v-icon>exit_to_app</v-icon>
        </v-btn>
      </template>
    </v-toolbar>
  </div>
</template>

<script>
  export default {
    methods: {
      doLogin: function () {
        console.log('login')
        this.$router.push({name: 'Home'})
        this.logged = !this.logged
      },
      doLogout: function () {
        console.log('doLogout')
        this.$router.push({name: 'Main'})
        this.logged = !this.logged
      }
    },
    data () {
      return {
        clipped: false,
        drawer: true,
        logged: false,
        user_items: [
          {icon: 'home', title: 'Home', ref: '/home'},
          {icon: 'dashboard', title: 'Dashboard', ref: '/dashboard'},
          {icon: 'timeline', title: 'Trading', ref: '/history'},
          {icon: 'cached', title: 'Transactions', ref: '/history'}
        ],
        admin_items: [
          {icon: 'settings', title: 'Settings', ref: '/settings'},
          {icon: 'security', title: 'Security', ref: '/security'},
          {icon: 'person', title: 'Profile', ref: '/profile'}
        ],
        miniVariant: false,
        title: 'Trade ninja'
      }
    }
  }
</script>
