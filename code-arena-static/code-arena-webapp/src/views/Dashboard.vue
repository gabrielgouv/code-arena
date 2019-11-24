<template>
  <div class="dashboard">
    <PageTitle title="Dashboard" subtitle="Your dashboard"/>
    <br/>
    <br/>
    <br/>
    <b-row>
        <b-col md="12">
            <vs-row vs-justify="center">
                <vs-col type="flex" vs-justify="center" vs-align="center" vs-w="5">
                    <vs-card actionable class="cardx">
                        <div slot="header">
                            <h3>Java</h3>
                            <h6>LANGUAGE PROFICIENCY</h6>
                        </div>
                        <br/>
                        <div>
                            <vs-progress :height="12" :percent="9" color="success">success</vs-progress>
                            <span><strong>9%</strong> (6/69 challenges solved)</span>
                        </div>
                        <br/>
                            <div slot="footer">
                            <vs-row vs-justify="flex-end">
                                <vs-button class="card-button" color="success" type="gradient" >Continue</vs-button>
                            </vs-row>
                        </div>
                    </vs-card>
                </vs-col>

                <vs-col vs-w="1"></vs-col>

                <vs-col type="flex" vs-justify="center" vs-align="center" vs-w="5">
                    <vs-card actionable class="cardx">
                        <div slot="header">
                            <h3>Python</h3>
                            <h6>LANGUAGE PROFICIENCY</h6>
                        </div>
                        <br/>
                        <div>
                            <vs-progress :height="12" :percent="0" color="primary">success</vs-progress>
                            <span>Not started</span>
                        </div>
                        <br/>
                            <div slot="footer">
                            <vs-row vs-justify="flex-end">
                                <vs-button class="card-button" color="primary" type="gradient" >Start Coding!</vs-button>
                            </vs-row>
                        </div>
                    </vs-card>
                </vs-col>
                
            </vs-row>
        </b-col>
    </b-row>

  </div>
</template>

<script>
import PageTitle from '@/components/template/PageTitle'

export default {
  name: 'Dashboard',
  components: { PageTitle }
}
</script>

<style scoped>
.con-vs-card {
    padding: 10px;
}
.card-button {
    width: 100%;
}
</style>