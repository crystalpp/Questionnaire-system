<template>
  <div class="creatQues">
    <new-ques v-if="createQuesType === 'newQues'"></new-ques>
    <template-ques v-if="createQuesType === 'templateQues'"></template-ques>
  </div>
</template>
<script>
import newQuest from '../creatQues/newQues'
import templateQues from '../creatQues/templateQues'
import { mapState } from 'vuex'
export default {
  components: {
    'new-ques': newQuest,
    'template-ques': templateQues
  },
  data () {
    return {
    }
  },
  computed: {
    ...mapState({
      createQuesType: state => state.commonState.createQuesType
    })
  },
  mounted () {
  },
  methods: {
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
