<template>
<div class="about">
  {{msg}}
</div>
</template>

<script>
export default {
  name: 'about',
  data: () => {
    return {
      msg: '내가 개발한 어플이지롱'
    }
  }
}
</script>

<style>
h1,
h2 {
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
  color: #35495E;
}
</style>
