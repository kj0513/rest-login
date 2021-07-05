<template>
  <v-card style ="width:1100px; height:600px; padding-left:40px; padding-top:40px">
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
            v-for="item in boardlist"
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
    <div class="text-left pt-3">
        <v-btn
          color="primary"
          router :to="{name:'boardwrite'}"
        >글쓰기
        </v-btn>
      </div>
      <div class="text-cetner">
       <v-pagination
        v-model="page"
        :length="4"
        prev-icon="mdi-menu-left"
        next-icon="mdi-menu-right"
        ></v-pagination>
      </div>
    </v-row>
  </v-card>
</template>

<script>
import { mapState, mapActions } from "vuex"
export default {
  created() {
    this.$store.dispatch('boardList')
  },
  computed: {
    ...mapState(["boardlist"])
  },
  methods: {
    ...mapActions(['boardDetail','boardWrite']),
    test (bId) {
      alert(bId);
    }
  } 
}
</script>