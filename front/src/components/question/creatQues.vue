<template>
  <div class="creatQues">
    <new-ques v-if="createQuesType === 'newQues'"></new-ques>
    <template-ques v-if="createQuesType === 'templateQues'" @getType='getType'></template-ques>
  </div>
</template>
<script>
import newQuest from '../creatQues/newQues'
import templateQues from '../creatQues/templateQues'
// import { mapState } from 'vuex'
import commonFunc from '../../client/bll/apis/common/common'
export default {
  components: {
    'new-ques': newQuest,
    'template-ques': templateQues
  },
  data () {
    return {
      createQuesType: ''
    }
  },
  beforeRouteUpdate (to, from, next) {
    debugger
    this.createQuesType = commonFunc.getLocalStorage('createQuesType')
    next()
  },
  computed: {
    // ...mapState({
    //   createQuesType: state => state.commonState.createQuesType
    // })
  },
  mounted () {
    debugger
    this.createQuesType = commonFunc.getLocalStorage('createQuesType')
  },
  methods: {
    getType (data) {
      this.createQuesType = data
    }
  }
}
</script>
<style lang="scss" scoped>
.creatQues {
  width:100%;
  height: 100%;
  font-size: 0.14rem;
}
</style>
