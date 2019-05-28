<template>
  <div class="fill-container">
     <pc-preview :survey='survey' :pcOrPhone ='pcOrPhone' :currentParticPateId='currentParticPateId' v-if="currentParticPateId" ></pc-preview>
     <!-- <phone-preview :survey='survey' :currentParticPateId='currentParticPateId' v-if="currentParticPateId && pcOrPhone === 'phone'"></phone-preview> -->
  </div>
</template>
<script>
// import phonePreview from '../components/preview/phonePreview'
import pcPreview from '../components/preview/pcPreview'
import surverApi from '../client/bll/apis/surver'
import participatenApi from '../client/bll/apis/participate'
import questionApi from '../client/bll/apis/question'
import commonFunc from '../client/bll/apis/common/common'
export default {
  components: {
    'pc-preview': pcPreview
    // 'phone-preview': phonePreview
  },
  data () {
    return {
      survey: {
        title: '',
        descr: '',
        surverQuestions: [],
        participatIp: '',
        particiAddress: '',
        particiDevice: ''
      },
      ipFlag: false,
      fillEndTimeFlag: false,
      partcipateInfo: '',
      currentParticPateId: '',
      pcOrPhone: 'phone'
    }
  },
  async mounted () {
    commonFunc.setLocalStorage('resultOrFill', 'fill')
    commonFunc.setLocalStorage('fillOrCreat', 'fill')
    commonFunc.setLocalStorage('editOrPreview', 'preview')
    await this.getIp()
    await this.getAddress()
    await this.getDeviceType()
    await this.getAll()
    if (!this.ipFlag) {
      await this.getSurvers()
      if (this.fillEndTimeFlag) {
        this.$router.push({name: 'error'})
      } else {
        await this.getSurverQuesions()
        await this.addNewParticipate()
      }
    } else {
      // commonFunc.showMessage('你已经填写过该问卷，请勿重新填写', 'error')
      // await this.addNewParticipate()
      // await this.getSurvers()
      // await this.getSurverQuesions()
      this.$router.push({name: 'error'})
    }
  },
  methods: {
    isLimitIp (data) {
      if (data.length !== 0) {
        for (let item of data) {
          if (item.participateIp === this.participatIp) {
            this.ipFlag = true
            return
          }
        }
      }
    },
    async getAll () {
      let params = {
        surverId: this.$route.params.id
      }
      let res = await participatenApi.getAll(params)
      if (res.code === 0) {
        console.log(res.data)
        this.isLimitIp(res.data)
      }
    },
    async addNewParticipate () {
      let params = {
        ip: this.participatIp,
        address: this.particiAddress,
        device: this.particiDevice,
        surverId: this.$route.params.id
      }
      let res = await participatenApi.addNewParticipate(params)
      if (res.code === 0) {
        this.currentParticPateId = res.data
      }
    },
    async getAddress () {
      let res = await participatenApi.getAddress()
      if (res.code === 0) {
        this.particiAddress = res.data
        console.log(this.particiAddress)
      }
    },
    async getIp () {
      let res = await participatenApi.getIp()
      if (res.code === 0) {
        this.participatIp = res.data
        console.log(this.participatIp)
      }
    },
    async getDeviceType () {
      let res = await participatenApi.getDeviceType()
      if (res.code === 0) {
        this.particiDevice = res.data
        if (this.particiDevice === 'MOBILE_SAFARI') {
          this.pcOrPhone = 'phone'
          // document.getElementsByTagName('html')[0].style.fontSize = '50px'
        } else {
          // document.getElementsByTagName('html')[0].style.fontSize = '50px'
          this.pcOrPhone = 'pc'
        }
        alert(this.particiDevice)
      }
    },
    async getSurvers () {
      let surverId = this.$route.params.id
      let res = await surverApi.search(surverId)
      if (res.code === 0) {
        this.survey.title = res.data[0].surverTitle
        this.survey.descr = res.data[0].surverDescription
        if (res.data[0].surverEndtime < new Date().getTime()) {
          this.fillEndTimeFlag = true
        }
      }
    },
    async getSurverQuesions () {
      let surverId = this.$route.params.id
      let res = await questionApi.searchBySueverId(surverId)
      console.log(res)
      if (res.code === 0) {
        // this.surverQuestionsData = res.data
        this.transTypeCode(res.data)
      }
    },
    transTypeCode (data) {
      for (let item of data) {
        let oneitem = {}
        if (item.quetypeId === '1') {
          item.quesType = 'radioselect'
        } else if (item.quetypeId === '2') {
          item.quesType = 'Multiselect'
        } else if (item.quetypeId === '3') {
          item.quesType = 'Drop-down'
        } else if (item.quetypeId === '4') {
          item.quesType = 'textselect'
        } else if (item.quetypeId === '5') {
          item.quesType = 'measure'
        } else if (item.quetypeId === '6') {
          item.quesType = 'matrix-radio'
        } else if (item.quetypeId === '7') {
          item.quesType = 'matrix-multi'
        }
        oneitem.type = item.quesType
        oneitem.title = item.questionName
        oneitem.questionId = item.questionId
        oneitem.subdesc = item.questionDirection
        oneitem.required = item.questionNeed
        oneitem.surverId = item.surverId
        oneitem.options = item.options
        oneitem.questions = item.subQuestions
        this.survey.surverQuestions.push(oneitem)
      }
    }
  }
}
</script>
<style lang="scss" scoped>

</style>
