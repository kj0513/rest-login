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
            v-for="item in list"
            :key="item.name"
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
        @input="boardgetList(page)"
        ></v-pagination>
      </div>
    </v-row>
  </v-container>
</template>

<script>
import { mapState, mapActions } from "vuex"
export default {
  data () {
      return {
        page: 1,
        list: this.$store.state.boardlist,
        pagination:{
          page:1
        }
      }
    },
  created() {
    this.$store.dispatch('boardList')
  },
  computed: {

  },
  methods: {
    ...mapActions(['boardDetail','boardWrite','boardgetList']),
    test (page) {
      alert(page);
    }
  } 
}
</script>