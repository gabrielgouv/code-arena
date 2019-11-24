import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Dashboard from '../views/Dashboard.vue'
import AdminDashboard from '../views/AdminDashboard.vue'
import FavoriteChallenges from '../views/FavoriteChallenges.vue'
import Challenges from '../views/Challenges.vue'
import ResolvedChallenges from '../views/ResolvedChallenges.vue'
import CreateChallenge from '../views/CreateChallenge.vue'
import UserConfig from '../views/UserConfig.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/dashboard',
    name: 'dashboard',
    component: Dashboard
  },
  {
    path: '/admin',
    name: 'admin-dashboard',
    component: AdminDashboard
  },
  {
    path: '/challenges',
    name: 'challenges',
    component: Challenges
  },
  {
    path: '/challenges/favorites',
    name: 'favorite-challenges',
    component: FavoriteChallenges
  },
  {
    path: '/challenges/solved',
    name: 'solved-challenges',
    component: ResolvedChallenges
  },
  {
    path: '/challenges/create',
    name: 'create-challenges',
    component: CreateChallenge
  },
  {
    path: '/user/configuration',
    name: 'user-configuration',
    component: UserConfig
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
