<template>
  <div class="dash-card">
    <vs-card actionable class="cardx">
        <div slot="header">
            <h3>{{ title }}</h3>
            <h6 class="card-subtitle">{{ category ? category.toUpperCase() : category }}</h6>
        </div>
        <br/>
        <div>
            <vs-progress :height="12" :percent="percentDone" :color="challengesDone > 0 ? 'success' : 'primary'">success</vs-progress>
            <template>
                <span v-if="challengesDone > 0">
                    <strong>{{ percentDone }}%</strong> ({{ challengesDone }}/{{ totalChallenges }} challenges solved)
                </span>
                <span v-else>
                    Not started
                </span>
            </template>
            
        </div>
        <br/>
        <vs-button v-if="challengesDone > 0" class="card-button" color="success" type="gradient">Continue</vs-button>
        <vs-button v-else class="card-button" color="primary" type="gradient">Start Coding!</vs-button>
    </vs-card>
  </div>
</template>

<script>
export default {
  name: 'DashCard',
  props: [
      'title',
      'category',
      'challengesDone',
      'totalChallenges'
  ],
  computed: {
      percentDone() {
          return (this.challengesDone / this.totalChallenges) * 100;
      }
  }
}
</script>

<style scoped>
.con-vs-card {
    padding: 5px 5px 0 5px;
}
.card-button {
    width: 100%;
}
.card-subtitle {
    color: #868686;
    margin-top: 5px;
}
</style>