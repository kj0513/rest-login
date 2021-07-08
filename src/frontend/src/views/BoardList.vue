<template>
  <v-container>
    <v-simple-table style="width: 200%">
      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-left">
              No
            </th>
            <th class="text-left">
              제목
            </th>
            <th class="text-left">
              작성자
            </th>
            <th class="text-left">
              날짜
            </th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="item in boardlist.list"
            :key="item.bId"
            @click="boardDetail(item.bId)"
          >
            <td>{{ item.bId }}</td>
            <td>{{ item.bTitle }}</td>
            <td>{{ item.username }}</td>
            <td>{{ item.bDateTime }}</td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>
    <v-row>
      <div class="text-right pt-3">
          <v-btn
            color="primary"
            router :to="{name:'boardwrite'}"
          >글쓰기
          </v-btn>
      </div>
    </v-row>
    <v-row>
      <div class="overflow-auto pt-4">
       <v-pagination
        v-model="page"
        :length="4"
        prev-icon="mdi-menu-left"
        next-icon="mdi-menu-right"
        @input="boardList(page)"
        ></v-pagination>
      </div>
    </v-row>
  </v-container>
</template>
<!-- @input="boardList({page:page, type:type, keyword:keyword})" -->
<script>
import { mapState, mapActions } from "vuex"
export default {
  data () {
      return {
        page: 1
      //  list: this.$store.state.boardlist
      }
    },
  created() {
    this.$store.dispatch('boardList', this.page)
  },
  computed: {
    ...mapState(['boardlist'])
    // pageCount() {
    //     let listLeng = this.listArray.length,
    //       listSize = this.pageSize,
    //       page = Math.floor(listLeng / listSize);
    //   if (listLeng % listSize > 0) page += 1;
      
    //   return page;
    // }

  },
  methods: {
    ...mapActions(['boardDetail','boardWrite','boardList']),
    test (page) {
      alert(page);
    }
  } 
}
</script>