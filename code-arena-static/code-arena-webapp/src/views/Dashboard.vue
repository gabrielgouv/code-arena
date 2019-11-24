<template>
  <div class="dashboard">
    <PageTitle title="Dashboard" subtitle="Your dashboard"/>
    <br/>
    <br/>
    <b-row>
        <b-col md="12">
            <vs-row vs-justify="center">
                <vs-col type="flex" vs-justify="center" vs-align="center" vs-w="5">
                    <DashCard 
                        title="Java" 
                        category="Language Proficiency"
                        challenges-done="5"
                        total-challenges="10"
                        />
                </vs-col>

                <vs-col vs-w="1"></vs-col>

                <vs-col type="flex" vs-justify="center" vs-align="center" vs-w="5">
                    <DashCard 
                        title="Python" 
                        category="Language Proficiency"
                        challenges-done="0"
                        total-challenges="16"
                        />
                </vs-col>
                
            </vs-row>
        </b-col>
    </b-row>

  </div>
</template>

<script>
import PageTitle from '@/components/template/PageTitle'
import DashCard from '@/components/dashboard/DashCard'

export default {
  name: 'Dashboard',
  components: { PageTitle, DashCard }
}
</script>

<style scoped>

</style>