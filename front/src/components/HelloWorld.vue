<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>Essential Links</h2>
  </div>
</template>

<script>
import testApi from '../client/bll/apis/test.js'
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'demo'
    }
  },
  async mounted () {
    await this.getData()
  },
  methods: {
    async getData () {
      let id = 1
      let data = await testApi.getById(id)
      this.msg = data.name
    }
  }
  // ready () {
  //   var that = this
  //   that.$http({
  //     method: 'GET',
  //     url: 'http://localhost:8080/article/get/1'
  //   }).then(function (data) {
  //     that.msg = data.desc
  //     console.log(data)
  //   }, function (error) {
  //     console.log(error)
  //   })
  // }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
