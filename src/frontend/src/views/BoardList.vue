<template>
  <v-container>
    <v-data-table style="width: 200%"
    :headers="headers"
    :items="$store.state.boardlist"
    :items-per-page="5"
    @click:row="boardDetail"
    class="elevation-1"
    >
     <template v-slot:top>
       <v-toolbar
        flat
      >
        <v-toolbar-title>게시판</v-toolbar-title>
        <v-divider
          class="mx-4"
          inset
          vertical
        ></v-divider>
        <v-spacer></v-spacer>
       </v-toolbar>
       <!-- <v-list-item
        :key="item.bId"
         @click="boardDetail(item.bId)"
        >
         <v-list-item-content >
         <v-list-item-subtitle v-html="item.bTitle"></v-list-item-subtitle>
         <v-list-item-subtitle v-html="item.bContent"></v-list-item-subtitle>
        </v-list-item-content>
        </v-list-item> -->
     </template>
    </v-data-table>
    <div class="text-right pt-3">
      <v-btn
        color="primary"
        router :to="{name:'boardwrite'}"
      >글쓰기
      </v-btn>
    </div>
  </v-container>
</template>

<script>
import { mapState, mapActions } from "vuex"
export default {
  data(){
    return{
      headers: [
        { text: 'No', align: 'center', sortable: false, value: 'bId' },
        { text: '제목', align: 'center', sortable: false, value: 'bTitle' },
        { text: '작성자', align: 'center', sortable: false, value: 'username' },
        { text: '날짜', align: 'center', sortable: false, value: 'bDateTime' },
      ],
    }
  },
  created() {
    this.$store.dispatch('boardList')
  },
  computed: {
    ...mapState(["boardlist"])
  },
  methods: {
    ...mapActions(['boardDetail','boardWrite'])
  } 
}
</script>