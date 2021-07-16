<template>
  <v-container>
    <!-- <v-card-title>
      게시판
      <v-spacer></v-spacer>
      <v-text-field
        v-model="searchType"
        label="Search"
        single-line
        hide-details
      ></v-text-field>
    </v-card-title> -->


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
        :length="boardlist.pagination.lastPage"
        prev-icon="mdi-menu-left"
        next-icon="mdi-menu-right"
        @input="boardList({searchType,keyword,page})"
        ></v-pagination>
      </div>
    </v-row>
<!-- @input="boardList({page})" -->



    <v-row>
    <div>
      <select v-model="searchType">
        <option disabled value="">- 선택 -</option>
        <option value="bTitle">제목</option>
        <option value="username">작성자</option>
      </select>

      <span>선택함: {{ searchType }}</span>
      <!-- <v-select
          :items="items"
          label="Standard"
        ></v-select> -->
       <v-text-field
          v-model="keyword"
          label="Search"
          single-line
          hide-details
        ></v-text-field>
        {{ keyword }}
	</div>
  <div class="text-right pt-3">
        <v-btn 
          rounded
          block 
          color="blue darken-3" 
          dark 
          @click="boardList({searchType,keyword,page})"
        >
          검색
        </v-btn>
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
        page: 1,
        searchType:null,
        keyword:null,
        // selected:null,
        // search:null,
      //  list: this.$store.state.boardlist
      }
    },
  created() {
    this.$store.dispatch('boardList', {page: this.page})
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